package Geom;

import java.util.ArrayList;

public class Route {
	
	private ArrayList<Point3D> Point3Dsa;


	public Route() {
		Point3Dsa = new ArrayList<Point3D>();
	}
	
	public void add(Point3D p) {
		Point3Dsa.add(new Point3D(p));
	}
	
	public int size() {
		return Point3Dsa.size();
	}
	
	public Point3D get(int i) {
		return Point3Dsa.get(i);
	}
	
	public String toString() {
		String sum = "";
		for (int i=0 ; i<this.size() ; i++) {
			sum += this.get(i).toString() + "  ";
		}
		return sum;
	}
	
}