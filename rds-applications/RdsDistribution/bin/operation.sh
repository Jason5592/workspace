#! /bin/bash

#该脚本为Linux下启动java程序的通用脚本。即可以作为开机自启动service脚本被调用，
#也可以作为启动java程序的独立脚本来使用。
#
#警告!!!：该脚本stop部分使用系统kill命令来强制终止指定的java程序进程。
#在杀死进程前，未作任何条件检查。在某些情况下，如程序正在进行文件或数据库写操作,
#可能会造成数据丢失或数据不完整。如果必须要考虑到这类情况，则需要改写此脚本,
#增加在执行kill命令前的一系列检查。

 
#执行程序启动所使用的系统用户，考虑到安全，推荐不使用root帐号
#RUNNING_USER=root
 
#项目程序所在的目录
#APP_HOME="/home/XXX/XXX"
if [ -z "$APP_HOME" ] ; then
  # use the location of this script to infer $DI_HOME
  whoami=`basename $0`
  whereami=`echo $0 | sed -e "s#^[^/]#\`pwd\`/&#"`
  whereami=`dirname $whereami`

  # Resolve any symlinks of the now absolute path, $whereami
  realpath_listing=`ls -l $whereami/$whoami`
  case "$realpath_listing" in
    *-\>\ /*)
      realpath=`echo $realpath_listing | sed -e "s#^.*-> ##"`
      ;;
    *-\>*)
      realpath=`echo $realpath_listing | sed -e "s#^.*-> #$whereami/#"`
      ;;
    *)
      realpath=$whereami/$whoami
      ;;
  esac
  APP_HOME=`dirname "$realpath"`/..
fi
APP_HOME=`cd $APP_HOME && pwd` 

###################################
#JDK路径，默认获取项目目录下jdk，
#如果没有，则查找环境变量，最后查找java运行文件目录
###################################

if [ -x "$APP_HOME/jdk/bin/java" ] ; then
  JAVA_HOME=$APP_HOME/jdk
elif [ -z "$JAVA_HOME" ] ; then
  java_file = `which java`
  if [ -n "$java_file" ] ; then
    JAVA_HOME=${"$java_file"/"/bin/java"/}
  fi
fi

#java虚拟机启动参数
#JAVA_OPTS="-ms512m -mx1024m -Xmn256m -Djava.awt.headless=true -XX:MaxPermSize=128m"
JAVA_OPTS="-Duser.language=zh -Duser.region=CN"
JAVA_OPTS="$JAVA_OPTS -server -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/home/heapdump"
JAVA_OPTS="$JAVA_OPTS -Xms512m -Xmx512m -Xss512K -XX:CompressedClassSpaceSize=128m -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=256m"
JAVA_OPTS="$JAVA_OPTS -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=3021 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
JAVA_OPTS="$JAVA_OPTS -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0 -XX:+CMSClassUnloadingEnabled -XX:LargePageSizeInBytes=128M -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=80 -XX:SoftRefLRUPolicyMSPerMB=0 -XX:+PrintClassHistogram -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintHeapAtGC -Xloggc:gc.log"

###################################
#(函数)判断程序是否已启动
#
#说明：
#使用ps查找命令行中有$APP_MAINCLASS的进程
###################################
 
checkpid() {
  psid_lines=`ps gaux | grep "jar RDSMain.jar" | grep -v grep | awk '{print $2}'`
  psid=`echo $psid_lines`
}

###################################
#(函数)启动程序
#
#说明：
#1. 首先调用checkpid函数，刷新$psid全局变量
#2. 如果程序已经启动（$psid不等于0），则提示程序已启动
#3. 如果程序没有被启动，则执行启动命令行
#4. 启动命令执行后，再次调用checkpid函数
#5. 如果步骤4的结果能够确认程序的pid,则打印[OK]，否则打印[Failed]
#注意：echo -n 表示打印字符后，不换行
#注意: "nohup 某命令 >/dev/null 2>&1 &" 的用法
###################################
start() {
  info
  checkpid

  if [ -n "$psid" ]; then
    echo -e "Service has been started. (pid=$psid) [\033[31m Failed \033[0m]"
  else
    port=`cat $APP_HOME/config/application.properties | grep server.port | awk -F "=" '{print $2}' | tr -d '\n\r'`
#    portview=`netstat -ln | grep $port | awk '{print $4}'`
    a=`lsof -i:$port | wc -l`
#    if [ "$portview" == ":::$port" ]; then
    if [ "$a" -gt "0" ]; then
      echo -n "Port($port) has been used"
      lsof -i:`echo $port` | grep -v PID | awk '{print $2}' | while read line
      do
        ps -p $line > /dev/null 2>&1
        if [ $? -eq 0 ]; then
          echo -n " by process($line)"
        fi
      done
      echo -e "Service start failed! [\033[31m Failed \033[0m]"
      exit 200
    fi
    [ $? -eq 200 ] && exit
    echo "Starting Server ..."
    CURR_DIR=`pwd`
    cd $APP_HOME
    nohup $JAVA_HOME/bin/java $JAVA_OPTS -jar RDSMain.jar >/dev/null 2>&1 &
#    echo "Service start succeed!"
#    JAVA_CMD="nohup $JAVA_HOME/bin/java $JAVA_OPTS -jar OperationMain.jar >/dev/null 2>&1 &"
#    echo "$JAVA_CMD"
#    su - $RUNNING_USER -c "$JAVA_CMD"
    sleep 3
    checkpid
    if [ -n "$psid" ]; then
      echo -e "Service start succeed. (pid=$psid) [\033[32m OK \033[0m]"
    else
      echo -e "Service start failed. [\033[31m Failed \033[0m]"
#      if [ -f "log/message.log" ]; then
#        echo -e "\033[31mError Log:\033[0m"
#        echo -e "\033[31m********************************************************\033[0m"
#        tail -n 30 log/message.log
#        echo -e "\033[31m********************************************************\033[0m"
#      fi
    fi
    cd $CURR_DIR
  fi
}
 
###################################
#(函数)停止程序
#
#说明：
#1. 首先调用checkpid函数，刷新$psid全局变量
#2. 如果程序已经启动（$psid不等于0），则开始执行停止，否则，提示程序未运行
#3. 使用kill -9 pid命令进行强制杀死进程
#4. 执行kill命令行紧接其后，马上查看上一句命令的返回值: $?
#5. 如果步骤4的结果$?等于0,则打印[OK]，否则打印[Failed]
#6. 为了防止java程序被启动多次，这里增加反复检查进程，反复杀死的处理（递归调用stop）。
#注意：echo -n 表示打印字符后，不换行
#注意: 在shell编程中，"$?" 表示上一句命令或者一个函数的返回值
###################################
stop() {
  checkpid

  if [ -n "$psid" ]; then
    echo "Stopping service ...(pid=$psid) "    
    kill -9 $psid
    #su - $RUNNING_USER -c "kill -9 $psid"
    checkpid
    if [ -z "$psid" ]; then
      echo -e "Service stopped successfully. [\033[32m OK \033[0m]"
    else
      echo -e "Failed to stop service. [\033[31m Failed \033[0m]"
    fi
  else
    echo -e "Service is not running. [\033[31m Failed \033[0m]"
  fi
}
 
###################################
#(函数)检查程序运行状态
#
#说明：
#1. 首先调用checkpid函数，刷新$psid全局变量
#2. 如果程序已经启动（$psid不等于0），则提示正在运行并表示出pid
#3. 否则，提示程序未运行
###################################
status() {
  checkpid

  if [ -n "$psid" ];  then
    echo "Service is running. (pid=$psid)"
  else
    echo "Service is not running."
  fi
}
 
###################################
#(函数)打印系统环境参数
###################################
info() {
  echo -e "\033[36mSystem Information:\033[0m"
  echo -e "\033[36m****************************\033[0m"
  #echo `head -n 1 /etc/issue`
  echo `uname -a`
  echo
  echo `$JAVA_HOME/bin/java -version`
  echo -e "\033[36mJAVA_HOME\033[0m=$JAVA_HOME"
  echo -e "\033[36mJAVA_OPTS\033[0m=$JAVA_OPTS"
  echo
  echo -e "\033[36mAPP_HOME\033[0m=$APP_HOME"

  version=`cat $APP_HOME/config/version.properties | grep version | awk -F "=" '{print $2}' | tr -d '\n\r'`
  echo -e "\033[36mAPP_VERSION\033[0m=$version"
  echo -e "\033[36m****************************\033[0m"
}
 
###################################
#读取脚本的第一个参数($1)，进行判断
#参数取值范围：{start|stop|restart|status|info}
#如参数不在指定范围之内，则打印帮助信息
###################################
case "$1" in
  'start')
    start
    ;;
  'stop')
    stop
    ;;
  'restart')
    stop
    start
    ;;
  'status')
    status
    ;;
  'info')
    info
    ;;
  *)
    echo "Usage: $0 {start|stop|restart|status|info}"
    exit 1
esac
