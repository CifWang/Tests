package fs2m174;
/**
 * 
 * @author cifengwang
 *
 */
public class GPSCar extends Car implements GPS {
	@Override
	public double[] getLocation() {
		Point point=new Point();
		point.setLocation(super.getSpeed(), super.getSpeed());
		return point.getLocation();
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString());
		sb.append(", Location: ("+getLocation()[0]+", "+getLocation()[1]+")");
		return sb.toString();
	}
	
	public static void main(String[] args) {
		GPSCar car=new GPSCar();
		car.setName("Audi");
		car.setSpeed(60.0);
		System.out.println(car);
	}


}
