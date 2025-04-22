/****
* Modul: Algorithmen und Datenstrukturen im SoSe 2025
* Gruppe <NR>
* Praktikum 1
* Datum: <AbgabeDatum>
* Version <z.B. 0.1>
* Klasse "Line" zur Darstellung einer Gerade durch zwei Punkte (x1|y1) und (x2|y2).
* @author De Terminante, Beta, 11012345
* @author Bo, Harry, 11012346
*/

class Line {
	private double A, B, C;

	/**
	 * Konstruktor zur Erstellung einer Geraden durch zwei Punkte.
	 * @param p1 erster Punkt
	 * @param p2 zweiter Punkt
	 */
	public Line(Point p1, Point p2) {
		this.A = p2.getY() - p1.getY();
		this.B = p1.getX() - p2.getX();
		this.C = p2.getX() * p1.getY() - p1.getX() * p2.getY();
		normalize();
	}

	private void normalize() {
		double norm = Math.sqrt(A * A + B * B);
		if (norm != 0) {
			A /= norm;
			B /= norm;
			C /= norm;
		}
	}

	public double getA() { return A; }
	public double getB() { return B; }

	/**
	 * Berechnet den Schnittpunkt mit einer anderen Geraden.
	 * @param that die andere Gerade
	 * @return Schnittpunkt als Point oder null, wenn parallel
	 */
	public Point meets(Line that) {
		double det = this.A * that.B - that.A * this.B;
		if (Math.abs(det) < 1e-10) return null;
		double x = (this.B * that.C - that.B * this.C) / det;
		double y = (that.A * this.C - this.A * that.C) / det;
		return new Point(x, y);
	}

	@Override
	public String toString() {
		return "Line: " + A + " * x + " + B + " * y + " + C + " = 0";
	}
}
