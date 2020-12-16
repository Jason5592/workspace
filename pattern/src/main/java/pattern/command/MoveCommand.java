package pattern.command;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-30
 * Time: 17:16
 * To change this template use File | Settings | File Templates.
 */
public class MoveCommand implements Command {
    private GameMachine machine;
    private String direction;


    public MoveCommand(GameMachine machine,String direction) {
        super();
        this.machine = machine;
        this.direction = direction;
    }



    @Override
    public void execute() {
        machine.move(direction);
    }



}