package pattern.command;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-30
 * Time: 17:16
 * To change this template use File | Settings | File Templates.
 */
public class Control {

    private Command fistCommand;
    private Command kickCommand;
    private Command moveCommand;

    public Control(Command fistCommand, Command kickCommand, Command moveCommand) {
        super();
        this.fistCommand = fistCommand;
        this.kickCommand = kickCommand;
        this.moveCommand = moveCommand;
    }

    public void fist(){
        fistCommand.execute();
    }

    public void kick(){
        kickCommand.execute();
    }

    public void move(){
        moveCommand.execute();
    }

}