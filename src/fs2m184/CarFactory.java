package fs2m184;

public class CarFactory {
	//根据车型创建对象
	public static Car getCar(String info) {
		if (info.equalsIgnoreCase("BMW")) {
			return new BMW();//直接这样就可以创建对象了
		}
		else if (info.equalsIgnoreCase("Benz")) {
			return new Benz();
		}else return null;
	}

}
