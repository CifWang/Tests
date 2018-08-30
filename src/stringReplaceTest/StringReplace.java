package stringReplaceTest;
/**
 * 只能换第一次出现的，要把所有的都换掉呢？。。。String.replaceAll()........
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
		number=number.replaceAll(oldStr, newStr);
		return number;
	}
	
	public static void main(String[] args) {
		String test="壹拾零万零万零仟零佰零万零零";
		//String result=numReplace(test,"零零","零");
		test=numReplace(test,"零仟","零");
		test=numReplace(test,"零佰","零");
		test=numReplace(test,"零亿","零");
		test=numReplace(test,"零零","零");
		//result=numReplace(test,"零佰","零");
		test=numReplace(test,"零万","万");
		System.out.println(test);
	}

}
