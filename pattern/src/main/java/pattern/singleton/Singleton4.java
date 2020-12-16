package pattern.singleton;

/**
 * 静态内部类实现模式(线程安全，调用效率高，可以延时加载)
 */
public class Singleton4 {

    private static class SingletonInstance {
        public static final Singleton4 singleton4 = new Singleton4();
    }

    private int id;

    private Singleton4() {}

    public static Singleton4 getInstance() {
        return SingletonInstance.singleton4;
    }
}
