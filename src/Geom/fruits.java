package Geom;

import java.util.ArrayList;

/**
 * this class represent an array of fruits 
 */
public class fruits {

	//Variable statements
	private ArrayList<fruit> fruitsa;
	
	/**
	 * fruits constructor
	 */
	public fruits() {
		fruitsa = new ArrayList<fruit>();
	}
	
	/**
	 * fruits constructor by another fruits array
	 * @param f fruits array
	 */
	public fruits(fruits f) {
		fruitsa = new ArrayList<fruit>();
		for(int i=0 ; i<f.size() ; i++) {
			fruitsa.add(f.get(i));
		}
	}
	
	/**
	 * add fruit method
	 * @param p the fruit that we wont to add
	 */
	public void add(fruit p) {
		fruitsa.add(p);
	}
	
	/**
	 * size method
	 * @return the size of the fruits array
	 */
	public int size() {
		return fruitsa.size();
	}
	
	/**
	 * get a specific fruit from the fruits array
	 * @param i the index that the fruit localized
	 * @return the specific fruit from the array
	 */
	public fruit get(int i) {
		return fruitsa.get(i);
	}
	
	/**
	 * remove a specific fruit from the fruits array
	 * @param i the index that the fruit localized
	 */
	public void remove(int i) {
		fruitsa.remove(i);
	}
	
}
