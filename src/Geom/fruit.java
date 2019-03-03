package Geom;

/**
 * this class represent a simple fruit 
 */
public class fruit extends Point3D{
	
	//Variable statements
	private static final long serialVersionUID = 1L;
	private int speed;
	private Point3D p;
	
	/**
	 * fruit constructor
	 */
	public fruit() {
		this.speed = 1;
		this.p = new Point3D();	
	}
	
	/**
	 * fruit constructor
	 * @param pac build a fruit from a packman 
	 */
	public fruit(fruit pac) {
		this.speed = pac.speed;
		this.p = pac.p;	
	}
	
	/**
	 * fruit constructor
	 * @param p build a fruit from a point3D 
	 */
	public fruit(Point3D p) {
		this.speed = 1;
		this.p = new Point3D(p);	
	}
	
	/**
	 * @return Point3D get the point from the fruit
	 */
	public Point3D getPoint() {
		return this.p;
	}
	
	
}
