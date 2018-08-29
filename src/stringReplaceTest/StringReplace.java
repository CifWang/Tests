package stringReplaceTest;


public class StringReplace {
	
	public static String numReplace(String number, String oldStr, String newStr){
		StringBuffer num=new StringBuffer();
		num.append(number);
		int tempIndex=num.indexOf(oldStr);
		num.delete(tempIndex, tempIndex+2);//包括前面，不包括后面
		num.insert(tempIndex, newStr);
		
		//System.out.println(tempIndex1);
		/**
		System.out.println(tempIndex2);
		if(tempIndex2-tempIndex1==1) {
			number=number.replace(oldStr, newStr);
		}
		//number=number.replace(oldStr, newStr);
		return number;
		*/
		return num.toString();
	}
	
	public static void main(String[] args) {
		String test="零佰零仟零万亿";
		//String result=numReplace(test,"零零","零");
		String result=numReplace(test,"零仟","零");
		//result=numReplace(test,"零佰","零");
		System.out.println(result);
	}

}
