package fs2m126;
/**
 * 
 * @author cifengwang
 *
 */
import java.text.DecimalFormat;;

public class ConvertMoney {
	
	private static final String[] STR_UNIT1= {"","拾","佰","仟","万","拾","佰","仟","亿","拾","佰","仟"};
	private static final String[] STR_UNIT2= {"角","分"};
	private static final String[] STR_NUM= {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
	
	public static String convert(double d) {
		DecimalFormat df=new DecimalFormat("##.##");
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
			temp.append(STR_UNIT1[i]);
			temp.append(STR_NUM[num.charAt(i)-48]);//返回的是数字的ascii码，0-9是48到57，-48就是从零开始
		}
		num=temp.reverse().toString();
		num=numReplace(num,"零拾","零");
		num=numReplace(num,"零佰","零");
		num=numReplace(num,"零仟","零");
		num=numReplace(num,"零万","万");
		num=numReplace(num,"零亿","亿");
		num=numReplace(num,"零零","零");
		num=numReplace(num,"亿万","亿");
		
		if(num.lastIndexOf("零")==num.length()-1) {
			num=num.substring(0, num.length()-1);
		}
		//num=num.substring(0,num.length()-1);
		return num;
	}
	
	public static String getDecimal(String num) {
		if(num.indexOf(".")==-1) {
			return "";
		}
		//num=new StringBuffer(num).toString();
		num=num.substring(num.indexOf(".")+1);
		StringBuffer temp=new StringBuffer();
		for(int i=0;i<num.length();i++) {
			
			temp.append(STR_NUM[num.charAt(i)-48]);
			temp.append(STR_UNIT2[i]);
		}
		num=temp.toString();
		num=numReplace(num,"零角","零");
		
		return num;
	}
	
	public static String numReplace(String number, String oldStr, String newStr) {
		while(true) {
			if(number.indexOf(oldStr)==-1) {break;}
			number=number.replaceAll(oldStr, newStr);
		}
		return number;
	}
	
	public static void main(String[] args) {
		String str=convert(100.11);
		System.out.println(str);
	}

}
