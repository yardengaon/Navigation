package GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import File_format.CsvToGame;
import File_format.GameToKml;
import Geom.Game;
import Geom.Packman;
import Geom.Packmans;
import Geom.Point3D;
import Geom.ShortestPathAlgo;
import Geom.fruit;
import Geom.fruits;

/**
 * This class is responsible on the gui
 */
public class MainWindow extends JFrame implements MouseListener, ActionListener
{
	/**
	 * Variable statements
	 */
	private static final long serialVersionUID = 1L;
	public BufferedImage myImage;
	public boolean flag = true;
	MyThread thread;
	static JLabel l;
	String s = null;
	boolean flag1 = true;
	boolean flag2 = true;
	boolean flag3 = false;
	boolean flag4 = false;
	double x = -1;
	double y = -1;
	Packmans pp = new Packmans();
	Packmans p5 = new Packmans();
	fruits ff = new fruits();
	Game g1 = new Game(ff, pp);
	BufferedImage image1;
	BufferedImage image2;
	GameToKml a1 = new GameToKml();

	/**
	 * MainWindow constructor
	 */
	public MainWindow() {
		try {
			initGUI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		this.addMouseListener(this); 
	}

	/**
	 * create a menu button in GUI
	 */
	private void initGUI() throws IOException 
	{
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu"); 
		MenuItem item1 = new MenuItem("Packman");
		MenuItem item2 = new MenuItem("fruit");
		MenuItem item3 = new MenuItem("Run");
		MenuItem item4 = new MenuItem("files");
		myImage = ImageIO.read(new File("Ariel1.png"));
		image1 = ImageIO.read(new File("PackmanF.png"));
		image2 = ImageIO.read(new File("FruitF.png"));
		menuBar.add(menu);
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		this.setMenuBar(menuBar);
		
		/**
		 * create (add packman) button
		 */
		item1.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = false;		
			}
		});

		/**
		 * create (add fruit) button
		 */
		item2.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				flag = true;		
			}
		});

		/**
		 * create (files) button
		 */
		item3.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				ShortestPathAlgo alg = new ShortestPathAlgo(g1);
				alg.route(g1);
				flag1 = false;
				flag2 = false;
				flag4 = true;
				MyThread thread1 = new MyThread();
				thread1.start();
			}
		});

		/**
		 * create (run) button
		 */
		item4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { 

				JPanel p = new JPanel(); 

				l = new JLabel("no file selected"); 

				// add panel to the frame 
				p.add(l); 

				// if the user presses the save button show the save dialog 
				String com = e.getActionCommand(); 

				if (com.equals("save")) { 
					// create an object of JFileChooser class 
					JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

					// invoke the showsSaveDialog function to show the save dialog 
					int r = j.showSaveDialog(null); 

					// if the user selects a file 
					if (r == JFileChooser.APPROVE_OPTION) 

					{ 
						// set the label to the path of the selected file 
						l.setText(j.getSelectedFile().getAbsolutePath()); 
					} 
					// if the user cancelled the operation 
					else
						l.setText("the user cancelled the operation"); 
				} 

				// if the user presses the open dialog show the open dialog 
				else { 
					// create an object of JFileChooser class 
					JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 

					// invoke the showsOpenDialog function to show the save dialog 
					int r = j.showOpenDialog(null); 

					// if the user selects a file 
					if (r == JFileChooser.APPROVE_OPTION) 

					{ 
						// set the label to the path of the selected file 
						l.setText(j.getSelectedFile().getAbsolutePath()); 
						s = (j.getSelectedFile().getAbsolutePath()); 
					} 
					// if the user cancelled the operation 
					else
						l.setText("the user cancelled the operation"); 
				} 

				if(s != null) {
					CsvToGame cs = new CsvToGame();
					try {
						cs.Csv2Game(g1, s);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					flag = false;
					repaint();
					flag = true;
					repaint();
				}

			}
		});

		try {
			myImage = ImageIO.read(new File("Ariel1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	/**
	 * Responsible for drawing the packmans and fruits to the screen 
	 * @param g the graphics
	 */
	public void paint(Graphics g)
	{
		BufferedImage bufferedImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.drawImage(myImage, 0,0, this.getWidth(), this.getHeight(), this);
		int pacSize = g1.pacSize();
		int fruSize = g1.fruSize();
		if(flag2 == true)
		{
			for(int i=0 ; i<pacSize; i++) {
				double j = (this.getWidth()/1432.0) * g1.getPac(i).getPoint().get_x();
				double k = (this.getHeight()/642.0) * g1.getPac(i).getPoint().get_y();
				g2d.drawImage(image1, (int)j-7, (int)k-7, rootPane);
			}
			for(int i=0 ; i<fruSize; i++) {
				double j = (this.getWidth()/1432.0) * g1.getFru(i).getPoint().get_x();
				double k = (this.getHeight()/642.0) * g1.getFru(i).getPoint().get_y();
				g2d.drawImage(image2, (int)j-7, (int)k-7, rootPane);
			}
		}

		if(flag4 == true) {
			if(flag3 == false) {
				for(int i = 0 ; i<g1.getPacs().size() ; i++) {
					p5.add(new Packman(g1.getPac(i)));
					for(int k = 1 ; k<g1.getPac(i).getRoute().size() ; k++) {
						p5.get(i).addRoete(g1.getPac(i).getRoute().get(k));
					}
				}
				flag3 = true;
			}

			for(int i=0 ; i<pacSize; i++) {
				double j = (this.getWidth()/1432.0) * (int) g1.getPac(i).getRoute().get(0).get_x();
				double k = (this.getHeight()/642.0) * (int) g1.getPac(i).getRoute().get(0).get_y();	
				g2d.drawImage(image1, (int)j-7, (int)k-7, rootPane);
			}

			for(int i=0 ; i<g1.getFrus().size(); i++) {
				double j = (this.getWidth()/1432.0) * g1.getFru(i).getPoint().get_x();
				double k = (this.getHeight()/642.0) * g1.getFru(i).getPoint().get_y();
				g2d.drawImage(image2, (int)j-7, (int)k-7, rootPane);
			}

			for (int j = 0 ; j<g1.getPacs().size() ; j++) {

				int size12345 = g1.getPac(j).getRoute().size();
				for (int i = 0 ; i<size12345-1 ; i++) {
					double j1 = (this.getWidth()/1432.0) * p5.get(j).getRoute().get(i).get_x();
					double k1 = (this.getHeight()/642.0) * p5.get(j).getRoute().get(i).get_y();
					double j2 = (this.getWidth()/1432.0) * p5.get(j).getRoute().get(i+1).get_x();
					double k2 = (this.getHeight()/642.0) * p5.get(j).getRoute().get(i+1).get_y();
					g2d.setStroke(new BasicStroke(3));
					g2d.setColor(new Color(10, 20, 30));
					g2d.drawLine((int)j1+7, (int)k1+7, (int)j2+7, (int)k2+7);
				}
			}

			double j = (this.getWidth()/1432.0) * (int) g1.getPac(0).getPoint().get_x();
			double k = (this.getHeight()/642.0) * (int) g1.getPac(0).getPoint().get_y();
			g2d.drawImage(image1, (int)j-7, (int)k-7, rootPane);
		}

		Graphics2D g2dComponent = (Graphics2D) g;
		g2dComponent.drawImage(bufferedImage, null, 0, 0); 

	}

	@Override
	public void mouseClicked(MouseEvent arg) {
		if (flag == false)
		{
			x = (arg.getX() * (1432.0/this.getWidth())) -5;
			y = (arg.getY() * (642.0/this.getHeight())) -5;
			Point3D p1 = new Point3D(x, y);
			g1.addPac(new Packman(p1));
			repaint();
		}
		else {
			x = (arg.getX() * (1432.0/this.getWidth())) -5;
			y = (arg.getY() * (642.0/this.getHeight())) -5;
			Point3D p2 = new Point3D(x, y);
			g1.addFru(new fruit(p2));
			repaint();
		}
	}

	/**
	 * a class that Responsible for calculating the location of the fruit and the pacmans painting in real time.
	 * and create the kml file.
	 */
	public class MyThread extends Thread{

		/**
		 * thread run method
		 */
		public void run() {
			for (int h = 0 ; h < 2000 ; h++) {
				for (int k = 0 ; k<g1.getFrus().size() ; k++) {
					for (int t = 0 ; t<g1.getPacs().size() ; t++) {
						if(g1.getFru(k).getPoint().close2equals(g1.getPac(t).getRoute().get(0), 20)){ 
							g1.getFrus().remove(k);
							break;
						}
					}
				}
				for(int d=0 ; d<g1.getPacs().size() ; d++)
					g1.getPacs().get(d).now(h);
				a1.writeFileKM(g1, h);
				try {
					Thread.sleep(8);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				repaint();
			}
			a1.toFile();
		}
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}


