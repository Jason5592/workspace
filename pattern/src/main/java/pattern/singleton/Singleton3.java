package pattern.singleton;

/**
 * Double CheckLock双重锁判断机制
 * 由于JVM底层模型原因，偶尔会出问题，不建议使用
 */
public class Singleton3 {

    private volatile static Singleton3 singleton3;

    private int id;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (singleton3 == null) {
            synchronized (Singleton3.class) {
                if (singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
