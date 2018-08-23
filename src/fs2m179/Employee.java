package fs2m179;
/**
 * 普通员工
 * @author cifengwang
 *
 */
import java.util.Date;
public class Employee {
	private String name;
	private double salary;
	private Date birthday;
	
	public Employee() {
	}
	
	public Employee(String n, double s, Date b) {
		this.name=n;
		this.salary=s;
		this.birthday=b;
	}
	
	public void setName(String n) {
		this.name=n;
	}
	public void setSalary(double s) {
		this.salary=s;
	}
	public void setBirthday(Date b) {
		this.birthday=b;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	

}
