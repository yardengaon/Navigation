package Geom;

import java.util.ArrayList;

/**
 * this class represent an array of fruits to any packman (the route)
 */
public class Route {
	
	//Variable statements
	private ArrayList<Point3D> Point3Dsa;

	/**
	 * Route constructor
	 */
	public Route() {
		Point3Dsa = new ArrayList<Point3D>();
	}
	
	/**
	 * add Point3D method
	 * @param p the Point3D that we wont to add to the Route
	 */
	public void add(Point3D p) {
		Point3Dsa.add(new Point3D(p));
	}
	
	/**
	 * size method
	 * @return the size of the Route array
	 */
	public int size() {
		return Point3Dsa.size();
	}
	
	/**
	 * get a specific Point3D from the Route array
	 * @param i the index that the Point3D localized
	 * @return the specific Point3D from the array
	 */
	public Point3D get(int i) {
		return Point3Dsa.get(i);
	}
	
	/**
	 * print a string that Property the Route
	 * @return string that Property the Route
	 */
	public String toString() {
		String sum = "";
		for (int i=0 ; i<this.size() ; i++) {
			sum += this.get(i).toString() + "  ";
		}
		return sum;
	}
	
}