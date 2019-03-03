package Geom;

import java.util.ArrayList;

import Coords.myCoords;

/**
 * this class represent a simple fruit 
 */
public class Packman extends Point3D{

	//Variable statements
	private static final long serialVersionUID = 1L;
	private int speed;
	private double time1;
	private Point3D p;
	private Route r;

	/**
	 * Packman constructor
	 */
	public Packman() {
		this.speed = 1;
		this.p = new Point3D();	
		this.time1 = 0;
		this.r = new Route();
		this.r.add(new Point3D(this.p));
	}

	/**
	 * Packman constructor
	 * @param pac build a packman from a packman 
	 */
	public Packman(Packman pac) {
		this.speed = pac.speed;
		this.p = pac.p;
		this.time1 = 0;
		this.r = new Route();
		this.r.add(this.p);
	}

	/**
	 * Packman constructor
	 * @param p12 build a packman from a Point3D
	 */
	public Packman(Point3D p12) {
		this.speed = 1;
		this.p = new Point3D(p12);
		this.time1 = 0;
		this.r = new Route();
		this.r.add(new Point3D(this.p));
	}
	
	/**
	 * Packman constructor
	 * @param p12 build a packman from a Point3D
	 * @param speed add speed Variable
	 */
	public Packman(Point3D p12, int speed) {
		this.speed = speed;
		this.p = new Point3D(p12);
		this.time1 = 0;
		this.r = new Route();
		this.r.add(new Point3D(this.p));
	}

	/**
	 * @return Point3D get the point from the packman
	 */
	public Point3D getPoint() {
		return this.p;
	}

	/**
	 * add Roete method
	 * @param p the point3d that we wont to add to the route
	 */
	public void addRoete(Point3D p) {
		this.r.add(new Point3D(p));

	}

	/**
	 * move method
	 * @param p the point3d that we wont to move
	 */
	public void move(Point3D p) {
		this.p = p;
	}

	/**
	 * @return packman speed
	 */
	public int getSpeed() {
		return this.speed;
	}

	/**
	 * @return packman time
	 */
	public double getTime() {
		return this.time1;
	}

	/**
	 * add time method
	 * @param t the packman time
	 */
	public void addTime(double t) {
		this.time1 = t;
	}

	/**
	 * print a string that Property the packman
	 * @return string that Property the packman
	 */
	public String toString() {
		String str = "";
		for(int i=0 ; i<this.r.size() ; i++) {
			str += (this.r.get(i) + "  /  ");
		}
		System.out.println(r.size());
		str +=  "   point3d:  " + p.toString(); 
		return str;
	}

	/**
	 * @return the packman route
	 */
	public Route getRoute() {
		return this.r;
	}

	double distancex;
	double distancey;
	double distance;
	double startx;
	double starty;
	int i = -1;
	double time12 = -1;
	double time123 = 0;
	int count = 1;
	Point3D p1 = new Point3D();

	/**
	 * calculate were the packman located in real-time
	 * @param time the packman time in real-time
	 */
	public void now(int time) {
		while (time > time12 && i<this.getRoute().size()-1) {
			i++;
			if(i<this.getRoute().size()-1)
				distance = myCoords.getInstance().distanceV2d(this.getRoute().get(i), this.getRoute().get(i+1));
			time12 += (distance/this.speed);
		}
		if(i<this.getRoute().size()-1) {
			time123 = (distance/this.speed);
			if(i!=0) {
				distancex = (((this.getRoute().get(i+1).get_x()-this.getRoute().get(i).get_x()) / time123));
				distancey = (((this.getRoute().get(i+1).get_y()-this.getRoute().get(i).get_y()) / time123));
			}
			else {
				if(count==1) {
					p1 = new Point3D(this.getRoute().get(i));
					count++;
				}
				distancex = (((this.getRoute().get(i+1).get_x()-p1.get_x()) / time123));
				distancey = (((this.getRoute().get(i+1).get_y()-p1.get_y()) / time123));
			}
			this.p.set_x(this.p.get_x() + distancex);
			this.p.set_y(this.p.get_y() + distancey);
		}
	}


}
