package fs2m186;
/**
 * 员工有id,name和age，按照id进行排序
 * @author cifengwang
 *
 */
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	private int age;
	
	public Employee(int i, String n, int a) {
		this.id=i;
		this.name=n;
		this.age=a;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	@Override
	public int compareTo(Employee e) {
		if(this.id>e.getId()) {
			return 1;
		}else if (this.id<e.id) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("员工编号："+this.id+"，");
		sb.append("员工姓名："+this.name+"，");
		sb.append("员工年龄："+this.age+"。");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Employee e1=new Employee(3,"Java1",23);
		Employee e2=new Employee(2,"Java2",21);
		Employee e3=new Employee(1,"Java3",22);
		List<Employee> employees=new ArrayList();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		System.out.println("排序前：");
		for(Employee e: employees) {
			System.out.println(e.toString());
		}
		System.out.println("排序后：");
		Collections.sort(employees);
		for(Employee e: employees) {
			System.out.println(e.toString());
		}
	}

}
