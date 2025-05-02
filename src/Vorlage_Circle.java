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

	/**
	 * Berechnet die Gerade durch die zwei Schnittpunkte mit einem anderen Kreis.
	 * Gibt null zurück, wenn keine echten Schnittpunkte existieren.
	 */
	public Line intersects(Circle other) {
		// Mittelpunkt- und Radiusdaten
		Point m1 = this.middle;
		Point m2 = other.middle;
		double r1 = this.radius;
		double r2 = other.radius;

		// Abstand zwischen den Mittelpunkten
		double dx = m2.getX() - m1.getX();
		double dy = m2.getY() - m1.getY();
		double d = Math.hypot(dx, dy); // gleiche wie sqrt(dx*dx + dy*dy), aber stabiler

		// Prüfen, ob Schnitt möglich ist
		if (d > r1 + r2 || d < Math.abs(r1 - r2) || d == 0) {
			return null; // Kein Schnitt
		}

		// Punkt auf der Linie zwischen den Mittelpunkten, wo Schnittlinie kreuzt
		double a = (r1 * r1 - r2 * r2 + d * d) / (2 * d);
		double h = Math.sqrt(r1 * r1 - a * a);

		// Koordinaten des Schnittmittelpunkts (Basislinie)
		double xm = m1.getX() + a * dx / d;
		double ym = m1.getY() + a * dy / d;

		// Abstand senkrecht zur Verbindungslinie
		double rx = -dy * (h / d);
		double ry = dx * (h / d);

		// Zwei echte Schnittpunkte
		Point s1 = new Point(xm + rx, ym + ry);
		Point s2 = new Point(xm - rx, ym - ry);


		// Gerade durch beide Schnittpunkte
		return new Line(s1, s2);
	}
	public String toString() {
		return "Kreis(Mittelpunkt: " + middle + ", Radius: " + radius + ")";
	}
}
