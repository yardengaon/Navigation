package Geom;

import java.util.ArrayList;

/**
 * this class represent an array of Packmans 
 */
public class Packmans {
	
	//Variable statements
	private ArrayList<Packman> Packmansa;

	/**
	 * Packmans constructor
	 */
	public Packmans() {
		Packmansa = new ArrayList<Packman>();
	}
	
	/**
	 * add Packman method
	 * @param p the Packman that we wont to add
	 */
	public void add(Packman p) {
		Packmansa.add(p);
	}
	
	/**
	 * size method
	 * @return the size of the Packmans array
	 */
	public int size() {
		return Packmansa.size();
	}
	
	/**
	 * get a specific Packman from the Packmans array
	 * @param i the index that the Packman localized
	 * @return the specific Packman from the array
	 */
	public Packman get(int i) {
		return Packmansa.get(i);
	}
	
	/**
	 * remove a specific Packman from the Packmans array
	 * @param i the index that the Packman localized
	 */
	public void remove(int i) {
		Packmansa.remove(i);
	}
		
}