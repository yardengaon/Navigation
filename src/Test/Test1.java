package Test;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import Coords.myCoords;
import Geom.Point3D;

public class Test1 {

	public static void main(String[] args) throws IOException {
		BufferedImage br = ImageIO.read(new File("Ariel1.png"));
		Point3D p1 = new Point3D(35.20238, 32.105687, 0);
		Point3D p2 = new Point3D(35.21235, 32.10191, 0);
		myCoords m1 = new myCoords();
		p1 = m1.gpsToVector(p1);
		p2 = m1.gpsToVector(p2);
		
		System.out.println(p1);
		System.out.println(p2);

	}

}
