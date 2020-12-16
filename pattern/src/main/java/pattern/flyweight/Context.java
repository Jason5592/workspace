package pattern.flyweight;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-7-30
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 * 数据类
 */
public class Context {
    private int size;
    private char c;
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public char getC() {
        return c;
    }
    public void setC(char c) {
        this.c = c;
    }
    public Context(int size, char c) {
        super();
        this.size = size;
        this.c = c;
    }

}
