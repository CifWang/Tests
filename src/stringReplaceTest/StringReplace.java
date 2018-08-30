package stringReplaceTest;
/**
 * 只能换第一次出现的，要把所有的都换掉呢？
 * @author cifengwang
 *
 */

public class StringReplace {
	
	/**
	public static String numReplace(String number, String oldStr, String newStr){
		StringBuffer num=new StringBuffer();
		num.append(number);
		int tempIndex=num.indexOf(oldStr);
		num.delete(tempIndex, tempIndex+2);//包括前面，不包括后面
		num.insert(tempIndex, newStr);
		
		//System.out.println(tempIndex1);
		
		System.out.println(tempIndex2);
		if(tempIndex2-tempIndex1==1) {
			number=number.replace(oldStr, newStr);
		}
		//number=number.replace(oldStr, newStr);
		return number;
	
		return num.toString();
	}*/
	
	public static String numReplace(String number, String oldStr, String newStr) {
		try {
			StringBuffer num=new StringBuffer();
			num.append(number);
			
			return num.toString();
			} catch(Exception e) {
				return number;
			}
	}
	
	public static StringBuffer replace(String s,String oldS, String newS, int OffSet) {
		StringBuffer sb=new StringBuffer();
		sb.append(s);
		sb.delete(OffSet, OffSet+oldS.length());
		sb.insert(OffSet, newS);
		return sb;
	}
	
	public static void main(String[] args) {
		String test="壹拾零万零万零仟零佰零万零零";
		//String result=numReplace(test,"零零","零");
		String result=numReplace(test,"零仟","零");
		result=numReplace(result,"零佰","零");
		result=numReplace(result,"零亿","零");
		result=numReplace(result,"零万","万");
		result=numReplace(result,"零零","零");
		//result=numReplace(test,"零佰","零");
		System.out.println(result);
	}

}
