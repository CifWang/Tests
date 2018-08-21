package fs2m168;
/**
 * 编写一个类，定义一个修饰权限为private的成员变量，定义两个成员方法，一个方法实现为此成员变量赋值，另一个方法获取这个成员变量的值，保证其他继承该类时，可以获得这个成员变量的值
 * @author cifengwang
 *
 */

public class Test1 {
	public Test1() {}
	private int Val;
	public void setVal(int val) {
		this.Val=val;
	}
	public int getVal() {
		return this.Val;
	}

}
