package pattern.singleton;

/**
 * 饿汉式(线程安全，调用效率高，但是不能延时加载)
 */
public class Singleton1 {

    private static final Singleton1 singleton1 = new Singleton1();

    public int id;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return singleton1;
    }
}
