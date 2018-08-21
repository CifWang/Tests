package fs2m168;
/**
 * calculate the area of a rectangle
 * @author cifengwang
 *
 */

public class Rect {
	private double length;
	private double width;
	//constructor
	public Rect(double length,double width) {
		this.length=length;
		this.width=width;
	}
	//member method, return the Area
	double rectArea() {
		return this.length*this.width;
	}
	public static void main(String[] args) {
		Rect rect=new Rect(1.2,1.2);
		System.out.println("Area of the rectangle is "+rect.rectArea());
	}

}
