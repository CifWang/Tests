package fs2m165;

public class Test2 {
	public static void main(String[] args) {
		Cat cat1=new Cat("Hello",1,4,"black");
		Cat cat2=new Cat("world",12,21,"yellow");
		Cat cat3=new Cat("Hello",1,4,"black");
		System.out.println("hashCode of cat1: "+cat1.hashCode());
		System.out.println("hashCode of cat2: "+cat2.hashCode());
		System.out.println("hashCode of cat3: "+cat3.hashCode());
		System.out.println("cat1 equals cat2? "+cat1.equals(cat2));
		System.out.println("cat1 equals cat3? "+cat1.equals(cat3));
	}

}
