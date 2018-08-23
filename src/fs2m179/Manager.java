package fs2m179;
/**
 * 继承Employee，定义bonus，给经理奖金
 * @author cifengwang
 *
 */
import java.util.Date;
public class Manager extends Employee {
	private double bonus;
	
	public void setBonus(double bo) {
	this.bonus=bo;	
	}
	
	public double getBonus() {
		return this.bonus;
	}

}
