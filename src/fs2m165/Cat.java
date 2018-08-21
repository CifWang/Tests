package fs2m165;

public class Cat {
	private String name;
	private int age;
	private double weight;
	private String color;
	public Cat(String name, int age, double weight, String color) {
		this.name=name;
		this.age=age;
		this.weight=weight;
		this.color=color;
	}

	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass()!=obj.getClass()) {
			return false;
		}
		Cat cat=(Cat)obj;
		return (name.equals(cat.name))&&(age==cat.age)&&(weight==cat.weight)&&(color.equals(cat.color));
	}
	//int和double两个数据类型是基本数据类型，没有equals()
	
	@Override
	public int hashCode(){
		return name.hashCode()+age+(int)weight+color.hashCode();
	}

}
