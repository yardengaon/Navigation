package Geom;

import java.util.ArrayList;
import java.util.Comparator;
import Coords.myCoords;
import GUI.MainWindow;


public class ShortestPathAlgo {

	private Game Game1;

	public ShortestPathAlgo(Game g) {
		this.Game1 = g;
	}

	public void route(Game g) {

		double distance3 = 0;
		double start = 10000000000.0;
		double time = 0;
		int counter = -1;
		int counter1 = -1;
		fruits f1 = g.getFrus();
		Packmans p1 = g.getPacs();
		int fruSize = f1.size();
		int pacSize = p1.size();

		for(int i = 0 ; i<fruSize ; i++) {
			for(int j = 0 ; j<pacSize ; j++) {
				for(int k = 0 ; k<f1.size() ; k++) {
					distance3 = myCoords.getInstance().distanceV2d((p1.get(j).getPoint()) , (f1.get(k).getPoint()));
					time = p1.get(j).getTime() + (distance3/p1.get(j).getSpeed());
					if (time < start) {
						start = time;
						counter = k;
						counter1 = j;
					}
				}
			}
			p1.get(counter1).addTime(start);
			p1.get(counter1).addRoete(f1.get(counter).getPoint());
			p1.get(counter1).move(f1.get(counter).getPoint());
			start = 10000000000.0;
			f1.remove(counter);
			counter = -1;
			counter1 = -1;
		}

		for(int i = 0 ; i<pacSize ; i++) {
			p1.get(i).move(p1.get(i).getRoute().get(0));
		}

		for(int i = 0 ; i<pacSize ; i++) {
			for (int j = 1 ; j<p1.get(i).getRoute().size() ; j++) {
				Point3D p = new Point3D(p1.get(i).getRoute().get(j).get_x() , p1.get(i).getRoute().get(j).get_y());
				fruit p11 = new fruit(p);	
				f1.add(p11);
			}
		}
	}
}


