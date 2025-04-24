/**
* Modul: Algorithmen und Datenstrukturen im SoSe 2025
* Gruppe 07
* Praktikum 1
* Datum: 24.04.2025
* Version <z.B. 0.1>
* Klasse "Circle" zur Darstellung eines Kreises durch den Mittelpunkt (x|y) und den Radius r.
* @author Taieb Bourbia ,11379890
* @author Osama Shahin ,
*/


class Circle {
	private Point middle;
	private double radius;

	public Circle(Point middle, double radius) {
		this.middle = middle;
		this.radius = radius;
	}

	public double getRadius() { return radius; }//habe nicht benutzt
	public Point getMiddle() { return middle; } //habe nicht benutzt

	public Line intersects(Circle pc) {
		Point p0 = this.middle;
		Point p1 = pc.middle;
		double r0 = this.radius;
		double r1 = pc.radius;

		double dx = p1.getX() - p0.getX();
		double dy = p1.getY() - p0.getY();
		double d = Math.sqrt(dx * dx + dy * dy);

		if (d > r0 + r1 || d < Math.abs(r0 - r1) || d == 0) {
			return null; // No intersection
		}

		double a = (r0 * r0 - r1 * r1 + d * d) / (2 * d);
		double h = Math.sqrt(r0 * r0 - a * a);

		double xm = p0.getX() + a * dx / d;
		double ym = p0.getY() + a * dy / d;

		double rx = -dy * (h / d);
		double ry = dx * (h / d);

		Point p2 = new Point(xm + rx, ym + ry);
		Point p3 = new Point(xm - rx, ym - ry);

		return new Line(p2, p3);
	}

	public String toString() {
		return "Kreis(Mittelpunkt: " + middle + ", Radius: " + radius + ")";
	}
}
