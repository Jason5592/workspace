package pattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-8-8
 * Time: 10:06
 * To change this template use File | Settings | File Templates.
 */
public abstract class Vehicle {

    private Transport implementor;

    public void transport(){
        implementor.transport();
    }
    public Transport getImplementor() {
        return implementor;
    }
    public void setImplementor(Transport implementor) {
        this.implementor = implementor;
    }

}
