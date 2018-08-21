package fs2m168;
/**根据运行参数的个数决定循环打印变量i值的次数
 * 
 * @author cifengwang
 *
 */
public class Test3 {
	
	public static void main(String[] args) { //args:运行参数
		for (int i=0;i<args.length;i++) {
			System.out.println(i);
		}
	}

}
