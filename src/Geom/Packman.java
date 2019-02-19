package Geom;

import java.util.ArrayList;

import Coords.myCoords;

public class Packman extends Point3D{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int speed;
	private double time1;
	private Point3D p;
	private Route r;


	public Packman() {
		this.speed = 1;
		this.p = new Point3D();	
		this.time1 = 0;
		this.r = new Route();
		this.r.add(new Point3D(this.p));
	}

	public Packman(Packman pac) {
		this.speed = pac.speed;
		this.p = pac.p;
		this.time1 = 0;
		this.r = new Route();
		this.r.add(this.p);
	}

	public Packman(Point3D p12) {
		this.speed = 1;
		this.p = new Point3D(p12);
		this.time1 = 0;
		this.r = new Route();
		this.r.add(new Point3D(this.p));
	}
	
	public Packman(Point3D p12, int speed) {
		this.speed = speed;
		this.p = new Point3D(p12);
		this.time1 = 0;
		this.r = new Route();
		this.r.add(new Point3D(this.p));
	}

	public Point3D getPoint() {
		return this.p;
	}

	public void addRoete(Point3D p) {
		this.r.add(new Point3D(p));

	}

	public void move(Point3D p) {
		this.p = p;
	}

	public int getSpeed() {
		return this.speed;
	}

	public double getTime() {
		return this.time1;
	}

	public void addTime(double t) {
		this.time1 = t;
	}

	public String toString() {
		String str = "";
		for(int i=0 ; i<this.r.size() ; i++) {
			str += (this.r.get(i) + "  /  ");
		}
		System.out.println(r.size());
		str +=  "   point3d:  " + p.toString(); 
		return str;
	}

	public Route getRoute() {
		return this.r;
	}

	myCoords c = new myCoords();
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

	public void now(int time) {
		while (time > time12 && i<this.getRoute().size()-1) {
			i++;
			if(i<this.getRoute().size()-1)
				distance = c.distanceV2d(this.getRoute().get(i), this.getRoute().get(i+1));
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
