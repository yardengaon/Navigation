package Coords;

import java.awt.Point;

import Geom.Point3D;

public class myCoords implements coords_converter  {
	
	private static myCoords obj1 = null;
	
	private Point3D TipPoint1;
	private Point3D TipPoint2;

	private myCoords() {
		this.TipPoint1 = new Point3D(35.20234, 32.10584);
		this.TipPoint2 = new Point3D(35.21237, 32.10193);
	}
	
	public static myCoords getInstance() {
		if(obj1 == null)
			obj1 = new myCoords();
		return obj1;
	}
	
	int r_earth = 6371000 ;

	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		Point3D newpoint3 = gpsToVector(gps);
		newpoint3.set_x(newpoint3.get_x() + local_vector_in_meter.get_x());
		newpoint3.set_y(newpoint3.get_y() + local_vector_in_meter.get_y());
		newpoint3.set_z(newpoint3.get_z() + local_vector_in_meter.get_z());

		return newpoint3;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
		double distance3d;
		double diff = gps0.get_y() - gps1.get_y();
		double diff1 = gps0.get_x() - gps1.get_x();
		double diff2 = gps0.get_z() - gps1.get_z();
		double diff_radian = (diff * Math.PI) / 180;
		double diff_radian1 = (diff1 * Math.PI) / 180;
		double meter = Math.sin(diff_radian) * gps1.get_y();
		double meter1 = Math.sin(diff_radian1) * gps1.get_y() * gps1.get_x();
		distance3d = Math.sqrt(Math.pow(meter, 2) + Math.pow(meter1, 2) + Math.pow(diff2, 2));

		return distance3d;
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		Point3D newGps0 = gpsToVector(gps0);
		Point3D newGps1 = gpsToVector(gps1);
		newGps0.set_x(newGps0.get_x() - newGps1.get_x());
		newGps0.set_y(newGps0.get_y() - newGps1.get_y());
		newGps0.set_z(newGps0.get_z() - newGps1.get_z());
		return newGps0;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub


		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		if(p.get_y() >= -90 && p.get_y() <= 90 && p.get_x() >= -180 && p.get_x() <= 180 && p.get_z() <= 10000 && p.get_z() >= -450 )
			return true;
		return false;
	}

	public double distance2d(Point3D gps0, Point3D gps1) {
		double distance3d;
		double diff = gps0.get_y() - gps1.get_y();
		double diff1 = gps0.get_x() - gps1.get_x();
		double diff_radian = (diff * Math.PI) / 180;
		double diff_radian1 = (diff1 * Math.PI) / 180;
		double meter = Math.sin(diff_radian) * gps1.get_y();
		double meter1 = Math.sin(diff_radian1) * gps1.get_y() * gps1.get_x();
		distance3d = Math.sqrt(Math.pow(meter, 2) + Math.pow(meter1, 2));

		return distance3d;
	}

	public Point3D gpsToVector(Point3D gps) {

		double r = 6371000 + gps.get_z();
		double x = r * Math.sin(Math.toRadians(gps.get_x()));
		double y = r * 0.847091174 * Math.sin(Math.toRadians(gps.get_y()));

		return new Point3D(x,y,gps.z());
	}

	public Point3D frameToGps(double frame_x, double frame_y) {
		
		double vecX = TipPoint1.get_x();
		double vecY = TipPoint1.get_y();
		vecX += (TipPoint2.get_x() - TipPoint1.get_x()) * (frame_x/1432.0);
		vecY += (TipPoint2.get_y() - TipPoint1.get_y()) * (frame_y/642.0);
		
		return new Point3D(vecX, vecY);
	}
	
	public Point3D VectorToframe(Point3D vec, double xFr, double yFr) {
		
		Point3D pStart = gpsToVector(this.TipPoint1);
		Point3D pEnd = gpsToVector(this.TipPoint2);
		double x = Math.abs(pStart.get_x() - pEnd.get_x());
		double y = Math.abs(pStart.get_y() - pEnd.get_y());
		double moveXMet = Math.abs(pStart.get_x() - vec.get_x());
		double moveYMet = Math.abs(pStart.get_y() - vec.get_y());
		double frameX = (xFr / x) * moveXMet;
		double frameY = (yFr / y) * moveYMet;

		return new Point3D(frameX, frameY);
	}
	
	public double distanceV2d(Point3D gps0, Point3D gps1) {
		double distance3d;
		double diff = gps0.get_y() - gps1.get_y();
		double diff1 = gps0.get_x() - gps1.get_x();
		distance3d = Math.sqrt(Math.pow(diff, 2) + Math.pow(diff1, 2));

		return distance3d;
	}
	
	public Point3D VectorToGps(Point3D gps) {

		double r = 6371000 + gps.get_z();
		double x = (gps.get_x()/r);
		x = Math.toDegrees(Math.asin(x));
		double y = (gps.get_y()/r/0.847091174);
		y = Math.toDegrees(Math.asin(y));

		return new Point3D(x,y,gps.z());
	}
	
}
