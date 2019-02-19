package GUI;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;


public class Main 
{
	public static void main(String[] args) throws IOException
	{
		MainWindow window = new MainWindow();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
