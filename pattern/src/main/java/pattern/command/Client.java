package pattern.command;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-30
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    public static void main(String[] args) {

        GameMachine machine = new GameMachine();
        Command fistCommand = new FistCommand(machine);
        Command kickCommand = new KickCommand(machine);
        Command moveCommand = new MoveCommand(machine, "左");

        //Client 与 命令接受者(Machine)解耦

        Control control = new Control(fistCommand, kickCommand, moveCommand);
        control.fist();
        control.kick();
        control.move();

        //其实在不同命令模式的情况下就是下面这样直接调用，
        //就会让调用者和实际命令执行者紧紧耦合在一起，还有一个好处
        //就是可以在
        //machine.fist();
        //machine.kick();
        //machine.move("左");
    }

}