package pattern.command;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-30
 * Time: 17:14
 * 命令接口
 */
public interface Command {
    //执行方法
    public void execute();

    //这里还可以加入撤销方法，回滚方法等
}
