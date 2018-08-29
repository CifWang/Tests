package stringReplaceTest;

public class StringReplace {
	
	public static String numReplace(String number, String oldStr, String newStr) {
		int tempIndex1=number.indexOf(oldStr.charAt(0));
		int tempIndex2=number.indexOf(oldStr.charAt(1));
		System.out.println(tempIndex1);
		System.out.println(tempIndex2);
		if(tempIndex2-tempIndex1==1) {
			number=number.replace(oldStr, newStr);
		}
		//number=number.replace(oldStr, newStr);
		return number;
	}
	
	public static void main(String[] args) {
		String test="零佰零仟零万亿";
		String result=numReplace(test,"零佰","2");
		result=numReplace(test,"零仟","3");
		System.out.println(result);
	}

}
