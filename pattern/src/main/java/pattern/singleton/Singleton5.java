package pattern.singleton;

/**
 * 枚举类(线程安全，调用效率高，不能延时加载，可以天然防止反射和反序列化调用)
 */
public enum Singleton5 {

    INSTANCE;

    public void singletonOperation(){
    }
}
