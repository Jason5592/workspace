package pattern.command;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-30
 * Time: 17:14
 * 接受者
 */
public class GameMachine {

    public void fist() {
        System.out.println("出拳");
    }

    public void kick() {
        System.out.println("出脚");
    }

    public void move(String direction) {
        System.out.println("向" + direction + "移动");
    }

}