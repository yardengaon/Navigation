package Geom;

/**
 * this class represent an array of fruits and array of packmans
 */
public class Game {
	
	//Variable statements
	private fruits f1;
	private Packmans p1;
	
	/**
	 * Game constructor
	 * @param f1 the fruits array
	 * @param p1 the packmans array
	 */
	public Game(fruits f1 , Packmans p1) {
		this.f1 = f1;
		this.p1 = p1;
	}
	
	/**
	 * add packman method
	 * @param p the packman that we wont to add
	 */
	public void addPac(Packman p) {
		p1.add(p);
	}
	
	/**
	 * packmns array size method
	 * @return the size of the packmans array
	 */
	public int pacSize() {
		return p1.size();
	}
	
	/**
	 * get packmans method
	 * @return the pacmans method
	 */
	public Packmans getPacs() {
		return p1;
	} 
	
	/**
	 * get a specific packman from the packmans array
	 * @param i the index that the packman localized
	 * @return the specific packman from the packmans array
	 */
	public Packman getPac(int i) {
		return p1.get(i);
	} 
	
	/**
	 * add fruit method
	 * @param f the fruit that we wont to add to the game
	 */
	public void addFru(fruit f) {
		f1.add(f);
	}
	
	/**
	 * size fruits method
	 * @return the size of the fruits array
	 */
	public int fruSize() {
		return f1.size();
	}
	
	/**
	 * get a specific fruit from the fruits array
	 * @param i the index that the fruit localized
	 * @return the specific fruit from the array
	 */
	public fruit getFru(int i) {
		return f1.get(i);
	}
	
	/**
	 * get a fruits array
	 * @return fruits array from the game
	 */
	public fruits getFrus() {
		return f1;
	} 
	

	

}
