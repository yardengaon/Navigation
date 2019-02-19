package Geom;

public class fruit extends Point3D{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private int speed;
	private Point3D p;
	
	public fruit() {
		this.speed = 1;
		this.p = new Point3D();	
	}
	
	public fruit(fruit pac) {
		this.speed = pac.speed;
		this.p = pac.p;	
	}
	
	public fruit(Point3D p) {
		this.speed = 1;
		this.p = new Point3D(p);	
	}
	
	public Point3D getPoint() {
		return this.p;
	}
	
	
}
