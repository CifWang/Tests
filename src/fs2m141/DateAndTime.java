package fs2m141;
/**
 * 将今天的全部信息格式化后输出，再将日期以“年-月-日”的格式输出。
 * @author cifengwang
 *
 */

import java.util.Date;
import java.util.Locale;

public class DateAndTime {
	//public static Date today=new Date();
	public static void main(String[] args) {
		Date today=new Date();
		System.out.println(today);
		String a=String.format("%tY", today);
		String b=String.format("%tm", today);
		String c=String.format("%td", today);
		
		System.out.println(a+"-"+b+"-"+c);
	}

}
