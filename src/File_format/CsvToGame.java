package File_format;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Coords.myCoords;
import Geom.Game;
import Geom.Packman;
import Geom.Point3D;
import Geom.fruit;

/**
 * This class is responsible for create from a csv file a game
 */
public class CsvToGame {
	int i = 0;
	int j = 0;

	/**
	 * create from a csv file a game
	 * @param game the csv keeped as a game object  
	 * @param str1 the csv file
	 */
	public void Csv2Game(Game game, String str1) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(str1));
		String str = "start";
		while(str != null) {
			str = br.readLine();
			if(str != null) {
				switch(str.charAt(0)) {
				case 'P' :BuildPackman(game,str);
				break;
				case 'F' :BuilsFruit(game,str);
				break;
				}
			}
		}
		br.close();
	}

	/**
	 * calculate where to put the fruit
	 * @param game the csv keeped as a game object  
	 * @param str line from the csv file
	 */
	private  void BuilsFruit(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[3]),Double.parseDouble(data[2]),Double.parseDouble(data[4]));
		game.addFru(new fruit(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642))));
		System.out.println(game.getFru(i).getPoint());
		i++;
	}

	/**
	 * calculate where to put the packmans 
	 * @param game the csv keeped as a game object  
	 * @param str line from the csv file
	 */
	private  void BuildPackman(Game game, String str) {
		String[] data = str.split(",");
		Point3D p1 = new Point3D(Double.parseDouble(data[3]),Double.parseDouble(data[2]),Double.parseDouble(data[4]));
		game.addPac(new Packman(new Point3D(myCoords.getInstance().VectorToframe(new Point3D(myCoords.getInstance().gpsToVector(p1)) ,1433, 642)) ,Integer.parseInt(data[5])));
		System.out.println(game.getPac(j).getPoint());
		System.out.println();
		j++;
	}



}
