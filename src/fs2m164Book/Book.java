package fs2m164Book;
/**
 * 定义图书类，在构造方法中加一个count，实例化的时候count计实例化次数，就可以记录销量
 * @author cifengwang
 *
 */
public class Book {
	private static int count=0;
	static String title;
	public Book(String title) {
		this.title=title;
		count++;
	}
	/**
	public static String getTitle() {
		return title;
	}
	*/
	public static int getCount() {
		return count;
	}

}
