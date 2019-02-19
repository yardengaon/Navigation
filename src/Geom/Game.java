package Geom;

public class Game {
	
	private fruits f1;
	private Packmans p1;
	
	public Game(fruits f1 , Packmans p1) {
		this.f1 = f1;
		this.p1 = p1;
	}
	
	public void addPac(Packman p) {
		p1.add(p);
	}
	
	public int pacSize() {
		return p1.size();
	}
	
	public Packmans getPacs() {
		return p1;
	} 
	
	public Packman getPac(int i) {
		return p1.get(i);
	} 
	
	public void addFru(fruit f) {
		f1.add(f);
	}
	
	public int fruSize() {
		return f1.size();
	}
	
	public fruit getFru(int i) {
		return f1.get(i);
	}
	
	public fruits getFrus() {
		return f1;
	} 
	

	

}
