package iteratorTest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Iterator遍历Map
 * @author cifengwang
 *
 */
public class IteratorMap {
	public static void main(String[] args) {
		Map map=new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		
		Set set=map.keySet();
		//System.out.println(set);
		Iterator<Integer> keyIt=set.iterator();
		while(keyIt.hasNext()) {
			System.out.println(keyIt.next());
			//Integer intit=keyIt.next();
			//System.out.println(intit);
		}
		
		//Collection col=map.values();
		//System.out.println(col);
		
		/**
		//entrySet可以得到所有键值对组成的集合
		Set<Map.Entry<Integer, String>> entrySet=map.entrySet();
		Iterator<Map.Entry<Integer,String>> iter=entrySet.iterator();
		while(iter.hasNext()) {
			Map.Entry<Integer, String> entry=iter.next();
			System.out.println("键："+entry.getKey());
			System.out.println("值："+entry.getValue());
		}*/
	}

}
