package fs2m184;
/**
 * 测试效果
 * @author cifengwang
 *
 */
public class Customer {
	public static void main(String[] args) {
		System.out.println("顾客要买宝马：");
		Car bmw=CarFactory.getCar("BMW");
		System.out.println("提取："+bmw.getInfo());
	}

}
