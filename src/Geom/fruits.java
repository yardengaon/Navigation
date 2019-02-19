package Geom;

import java.util.ArrayList;

public class fruits {

	private ArrayList<fruit> fruitsa;

	
	public fruits() {
		fruitsa = new ArrayList<fruit>();
	}
	
	public fruits(fruits f) {
		fruitsa = new ArrayList<fruit>();
		for(int i=0 ; i<f.size() ; i++) {
			fruitsa.add(f.get(i));
		}
	}
	
	public void add(fruit p) {
		fruitsa.add(p);
	}
	
	public int size() {
		return fruitsa.size();
	}
	
	public fruit get(int i) {
		return fruitsa.get(i);
	}
	
	public void remove(int i) {
		fruitsa.remove(i);
	}
	
}
