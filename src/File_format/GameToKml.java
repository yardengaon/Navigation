package File_format;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Coords.myCoords;
import Geom.Game;
import Geom.Packman;
import Geom.Packmans;
import Geom.Point3D;
import Geom.fruit;
import Geom.fruits;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.TimeSpan;

public class GameToKml {
	
	Kml kml = new Kml();
	Document doc = kml.createAndSetDocument();

	public void writeFileKM(Game a , int time) {

		for(int i=0 ; i<a.fruSize() ; i++) {
		Placemark p = doc.createAndAddPlacemark();
			Point3D k = myCoords.getInstance().frameToGps(a.getFru(i).getPoint().get_x(), a.getFru(i).getPoint().get_y());
			p.withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(k.get_x(),k.get_y());
			TimeSpan t = p.createAndSetTimeSpan();
			String time1 = CTime1(0 + time*1000);
			String time2 = CTime1(1000 + time*1000);
			t.setBegin(time1); // the time now 
			t.setEnd(time2); // end point 
		}
		for(int i=0 ; i<a.pacSize() ; i++) {
			Placemark p = doc.createAndAddPlacemark();
			Point3D k = myCoords.getInstance().frameToGps(a.getPac(i).getPoint().get_x(), a.getPac(i).getPoint().get_y());
			p.withOpen(Boolean.TRUE).createAndSetPoint().addToCoordinates(k.get_x(),k.get_y());
			TimeSpan t = p.createAndSetTimeSpan();
			String time1 = CTime1(0 + time*1000);
			String time2 = CTime1(1000 + time*1000);
			t.setBegin(time1); // the time now 
			t.setEnd(time2); // end point 
		}	
	}
	public void toFile() {
		try {
			kml.marshal(new File("Run.kml"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String CTime1(int a) {
		String time =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTimeInMillis()+a);
		time = time.replaceAll(" ", "T");
		time = time + "Z";
		return time;
	}
}

