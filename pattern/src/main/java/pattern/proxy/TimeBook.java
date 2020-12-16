package pattern.proxy;


public class TimeBook implements TimeBookInterface {

	public void doAuditing(String name) { 
		System.out.println(name+"审核数据");
	}
}
