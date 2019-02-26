package Geom;

import java.util.ArrayList;



public class Packmans {
	
	private ArrayList<Packman> Packmansa;

	public Packmans() {
		Packmansa = new ArrayList<Packman>();
	}
	
	public void add(Packman p) {
		Packmansa.add(p);
	}
	
	public int size() {
		return Packmansa.size();
	}
	
	public Packman get(int i) {
		return Packmansa.get(i);
	}
	
	public void remove(int i) {
		Packmansa.remove(i);
	}
		
}