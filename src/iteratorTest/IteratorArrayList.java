package iteratorTest;
/**
 * Iterator遍历ArrayList
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorArrayList {
	public static void main(String[] args) {
		List list=new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		Iterator iter=list.iterator();
		
		while(iter.hasNext()) {
			int j=(int)iter.next();
			System.out.println(j);
		}
	}
}
