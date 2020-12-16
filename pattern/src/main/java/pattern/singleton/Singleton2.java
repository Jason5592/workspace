package pattern.singleton;

/**
 * 懒汉式(线程安全，调用效率不高，但是能延时加载)
 */
public class Singleton2 {

    private static Singleton2 singleton2;

    public int id;

    private Singleton2() {}

    public static synchronized Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}
