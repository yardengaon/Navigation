package Geom;
/**
 * This class represents a 2D (open set) circle
 * @author ben-moshe
 *
 */
public class Circle implements Geom_element {
	private Point3D _cen;
	private double _radius;
	public Circle(Point3D cen, double rad) {
		this.set_cen(new Point3D(cen));
		this.set_radius(rad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double distance3D(Point3D p) {
		double d = p.distance3D(this.get_cen());
		double dr = d - this.get_radius();
		double ans = Math.max(0, dr);
		return ans;
	}

	@Override
	public double distance2D(Point3D p) {
		// TODO Auto-generated method stub
		return -1;
	}

	/**
	 * @return the Circle point
	 */
	public Point3D get_cen() {
		return _cen;
	}

	/**
	 * @param _cen set the Circle point
	 */
	private void set_cen(Point3D _cen) {
		this._cen = _cen;
	}

	/**
	 * @return the radius of eating
	 */
	public double get_radius() {
		return _radius;
	}

	/**
	 * @param _radius set the radios of eating
	 */
	private void set_radius(double _radius) {
		this._radius = _radius;
	}

}
