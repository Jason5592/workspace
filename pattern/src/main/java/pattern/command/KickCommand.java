package pattern.command;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-30
 * Time: 17:16
 * To change this template use File | Settings | File Templates.
 */
public class KickCommand implements Command {
    private GameMachine machine;

    public KickCommand(GameMachine machine) {
        super();
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.kick();
    }

}