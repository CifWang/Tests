package staticTest1;
/**
 * 
 * @author cifengwang
 *
 */

public class Val1 {
	public static int time=3;
	public static void main(String[] args) {
		int time=4;
		System.out.println("time= "+time);
		System.out.println("Val1.time= "+Val1.time);
	}
}
