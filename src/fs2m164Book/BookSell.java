package fs2m164Book;
import java.util.Random;
import fs2m164Book.Book;
/**
 * 计算图书销量
 * @author cifengwang
 *
 */
public class BookSell {
	public static void main(String[] args) {
		String titles[]=new String[] {"java从入门到精通","java编程词典","深入理解java虚拟机"};
		for(int i=0;i<5;i++) {
			new Book(titles[new Random().nextInt(3)]);
			System.out.println("售出图书："+Book.title);
		}
		System.out.println("售出图书"+Book.getCount()+"本");
	}

}
