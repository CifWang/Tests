package testStringBuilder;
/**
 * 测试一下StringBuilder类的作用（从速度方面）
 * @author cifengwang
 *
 */
public class Jerque {
	public static void main(String[] args) {
		String str="";
		long startTime=System.currentTimeMillis();
		for(long i=0;i<100000;i++) {
			str=str+i;
		}
		long endTime=System.currentTimeMillis();
		long time=endTime-startTime;
		System.out.println("String: "+time);
		
		StringBuilder builder=new StringBuilder("");
		startTime=System.currentTimeMillis();
		for(long i=0;i<100000;i++) {
			builder.append(i);
		}
		endTime=System.currentTimeMillis();
		time=endTime-startTime;
		System.out.println("StringBuilder "+time);
	}

}
