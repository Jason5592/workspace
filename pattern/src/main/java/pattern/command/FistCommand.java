package pattern.command;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-30
 * Time: 17:15
 * 打拳
 */
public class FistCommand implements Command {
    private GameMachine machine;

    public FistCommand(GameMachine machine) {
        super();
        this.machine = machine;
    }


    @Override
    public void execute() {
        machine.fist();
    }


}