package hashCodeandequals;
import java.util.*;
/**
 * 
 * @author cifengwang
 *
 */

public class Test1 {
	static String a=new String("java");
	static String b=new String("java");
	static String c=new String("world");
	static Integer x=1;
	static Integer y=1;
	static Integer z=2;
	static Dog dog1=new Dog("Yellow");
	static Dog dog2=new Dog("Yellow");
	static Dog dog3=new Dog("Eddie");
	public static void main(String[] args) {
		System.out.println("a.equals(b) is "+a.equals(b));
		System.out.print("a==b is ");
		System.out.println(a==b);
		System.out.println("a.equals(c) is "+a.equals(c));
		System.out.println("x.equals(y) is "+x.equals(y));
		System.out.println("x.equals(z) is "+x.equals(z));
		System.out.println("dog1.equals(dog2) is "+dog1.equals(dog2));
		System.out.println("dog1.equals(dog3) is "+dog1.equals(dog3));
	}
}

