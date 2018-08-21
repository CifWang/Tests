package fs2m174;

public class Point {
	public Point() {}
	private double x;
	private double y;
	
	public void setLocation(double a,double b) {
		this.x=a;
		this.y=b;
	}
	
	public double[] getLocation() {
		double[] d=new double[2];
		d[0]=this.x;
		d[1]=this.y;
		return d;
	}

}
