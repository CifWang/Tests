package fs2m126;
/**
 * 
 * @author cifengwang
 *
 */
import java.text.DecimalFormat;;

public class ConvertMoney {
	
	private static final String[] STR_UNIT= {"零","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟"};
	private static final String[] STR_NUM= {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	
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
		if(num.indexOf(".")!=-1) {
			num=num.substring(0, num.indexOf("."));
		}
		num=new StringBuffer(num).reverse().toString();
		StringBuffer temp=new StringBuffer();
		for(int i=0;i<num.length();i++) {
			temp.append(STR_UNIT[i]);
			temp.append(STR_NUM[num.charAt(i)-48]);
		}
		num=temp.reverse().toString();
		num=numReplace(num,"零拾","零");
		num=numReplace(num,"零仟","零");
		num=numReplace(num,"零佰","零");
		num=numReplace(num,"零万","万");
		num=numReplace(num,"零亿","亿");
		num=numReplace(num,"零零","零");
		num=num.substring(0,num.length()-1);
		return num;
	}
	
	public static String numReplace(String number, String oldStr, String newStr) {
		int tempIndex1=number.indexOf(oldStr.charAt(0));
		int tempIndex2=number.indexOf(oldStr.charAt(1));
		if (tempIndex1+1==tempIndex2) {
			number=number.replace(oldStr, newStr);
		}
		return number;
	}
	
	public static String getDecimal(String num) {
		return "";
	}
	
	public static void main(String[] args) {
		String str=convert(1000000);
		System.out.println(str);
	}

}
