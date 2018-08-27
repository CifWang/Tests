package fs2m126;
/**
 * 
 * @author cifengwang
 *
 */
import java.text.DecimalFormat;;

public class ConvertMoney {
	public static String convert(double d) {
		DecimalFormat df=new DecimalFormat("##.###");
		String strNum=df.format(d);
		//return strNum;
		if(strNum.indexOf(".")!=-1) {//有小数点
			String num=strNum.substring(0,strNum.indexOf("."));
			if(num.length()>12) {
				System.out.println("数字太大");
				return "";
			}
		}
		
		String point="";
		if (strNum.indexOf(".")!=-1) {
			point="元";
		}else {
			point="元整";
		}
		String result=getInteger(strNum)+point+getDecimal(strNum);
		if(result.startsWith("元")) {
			result=result.substring(1,result.length());
		}//整数部分是0
		return result;
	}
	
	public static String getInteger(String num) {
		return "";
	}
	
	public static String getDecimal(String num) {
		return "";
	}
	
	public static void main(String[] args) {
		String str=convert(234567.14234556);
		System.out.println(str);
	}

}
