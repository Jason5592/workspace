@echo off
setlocal enabledelayedexpansion

set JAVA_OPTS=-Xms128m -Xmx2048m

::set APP_HOME=
if not "%OS%"=="Windows_NT" set DEFAULT_APP_HOME=..
if "%OS%"=="Windows_NT" set DEFAULT_APP_HOME=%~dp0\..
if "%OS%"=="WINNT" set DEFAULT_APP_HOME=%~dp0\..
if "%APP_HOME%"=="" set APP_HOME=%DEFAULT_APP_HOME%

if exist "%APP_HOME%\jdk\bin\java.exe" (
  set "JAVA_HOME=%APP_HOME%\jdk"
)

::set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_45
if "%JAVA_HOME%"=="" (
  echo ERROR: JAVA_HOME not found in your environment.
  goto :EOF
)

if not exist "%JAVA_HOME%\bin\java.exe" goto javanotfound
if not exist "%JAVA_HOME%\bin\jps.exe" goto javahomeinvalid
goto SHOWMENU

:javanotfound
echo ERROR: JAVA_HOME is set to an invalid directory.
echo JAVA_HOME=%JAVA_HOME%
goto :EOF

:javahomeinvalid
echo ERROR: JAVA_HOME is set to an invalid directory.
echo JAVA_HOME = %JAVA_HOME%
goto :EOF

:SHOWMENU
if "%1"=="" (
  echo ****************************
  echo 1  start server
  echo 2  stop server
  echo 3  restart server
  echo 4  server status
  echo 5  server info
  echo 6  quit
  echo ****************************

  set /p CHOICE=Choice:
  if "!CHOICE!"=="1" set CMD=start
  if "!CHOICE!"=="2" set CMD=stop
  if "!CHOICE!"=="3" set CMD=restart
  if "!CHOICE!"=="4" set CMD=status
  if "!CHOICE!"=="5" set CMD=info
  if "!CHOICE!"=="6" set CMD=quit
) else (
  set CMD=%1
)

if "%CMD%"=="start" call :start
if "%CMD%"=="stop" call :stop
if "%CMD%"=="restart" call :restart
if "%CMD%"=="status" call :status
if "%CMD%"=="info" call :info
if "%CMD%"=="quit" call exit

pause
goto SHOWMENU
endlocal
goto :EOF

:checkpid
for /F "tokens=1,*" %%V in ('call "%JAVA_HOME%\bin\jps" -l^|findstr OperationMain.jar') do set "PSID=%%V"
goto :EOF

:start
setlocal
call :info
call :checkpid
if not "%PSID%"=="" (
  echo warn: Service has been started. ^(pid=%PSID%^) [ Failed ]
) else (
REM  echo "Starting Server ..."
  set "CURR_DIR=%~dp0"
  cd /d "%APP_HOME%"
  ::echo "%JAVA_HOME%\bin\java" %JAVA_OPTS% -jar OperationMain.jar
  "%JAVA_HOME%\bin\java" %JAVA_OPTS%  -jar OperationMain.jar
  echo Service has been stopped.
REM  @ping 127.0.0.1 -n 3 -w 1000 > nul
REM  call :checkpid
REM  if not "%PSID%"=="" (
REM    echo "Server start successd. (pid=%PSID%) [ OK ]"
REM  ) else (
REM    echo "Server start failed. [ Failed ]"
REM    ::if exist "%APP_HOME%\log\message.log" (
REM    ::    echo Error Log:
REM    ::    echo ********************************************************
REM    ::    tail -n 30 log/message.log
REM    ::    echo ********************************************************
REM    ::)
REM  )
  cd "%CURR_DIR%"
)
endlocal&goto :EOF

:stop
setlocal
call :checkpid
if "%PSID%"=="" (
  echo warn: Service is not running. [ Failed ]
) else (
  echo Stopping service ...
  taskkill /pid %PSID% /f
REM  call :checkpid
REM  if "%PSID%"=="" (
REM    echo Service stopped successfully. [ OK ]
REM  ) else (
REM    echo Failed to stop service. ^(pid=%PSID%^) [ Failed ]
REM  )
)
endlocal&goto :EOF

:restart
setlocal
call :stop
call :start
endlocal&goto :EOF

:status
setlocal
call :checkpid
if "%PSID%"=="" (
  echo Service is not running.
) else (
  echo Service is running. ^(pid=%PSID%^) [ OK ]
)
endlocal&goto :EOF

:info
setlocal
echo System Information:
echo ****************************
ver
echo USER=%username%
echo.
"%JAVA_HOME%/bin/java" -version
echo.
echo JAVA_HOME=%JAVA_HOME%
echo JAVA_OPTS=%JAVA_OPTS%
echo.
echo APP_HOME=%APP_HOME%
echo.
for /F "tokens=2,* delims==" %%V in  ('findstr "version" "%APP_HOME%\production\version.properties"') do set APP_VERSION=%%V
echo APP_VERSION=%APP_VERSION%
echo.
echo ****************************
endlocal&goto :EOF

:help
setlocal
echo "Usage: %1 {start|stop|restart|status|info}"
endlocal&goto :EOF