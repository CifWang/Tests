package fs2m141;
/**
 * 只用for和if去除字符串中所有空格
 * @author cifengwang
 *
 */
public class DeleteSpace {
	
	public static void DSpace(String s) {
		char [] c=s.toCharArray();
		int count=0;
		for(int i=0;i<c.length;i++) {
			if(c[i]==' ') {
				for (int j=i;j<c.length-1;j++) {
					c[j]=c[j+1];
					c[c.length-1]='a';
				}
				count++;
			}
		}
		for(int i=0;i<c.length-count-1;i++) {
			System.out.print(c[i]);
		}
	}
	
	public static void main(String[] args) {
		DSpace("he llo wor ld ");
		//System.out.println(s);
	}

}
