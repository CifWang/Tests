package fs2m174;
/**
 * 
 * @author cifengwang
 *
 */
public class Car {
	private String name;
	private double speed;
	public Car() {}
	
	public void setName(String n) {
		this.name=n;
	}
	public void setSpeed(double s) {
		this.speed=s;
	}
	public String getName() {
		return this.name;
	}
	public double getSpeed() {
		return this.speed;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("name: "+this.name+", ");
		sb.append("speed: "+this.speed+"km/h");
		return sb.toString();
	}

}
