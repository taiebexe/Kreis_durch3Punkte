/****
* Modul: Algorithmen und Datenstrukturen im SoSe 2025
* Gruppe 7
* Praktikum 1
* Datum: 22.04.2025
* Version
* Klasse "Line" zur Darstellung einer Gerade durch zwei Punkte (x1|y1) und (x2|y2).
* @author Taieb Bourbia ,11379890
 *@author Osama Shahin ,
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
	public double getC() { return C; }


	/**
	 * Berechnet den Schnittpunkt dieser Linie mit einer anderen Linie.
	 * Gibt den Schnittpunkt als {@code Point} zurück oder {@code null}, falls die Linien parallel sind.
	 *
	 * @param that Die zweite Linie, mit der der Schnittpunkt berechnet werden soll.
	 * @return Der Schnittpunkt beider Linien als {@code Point}, oder {@code null}, wenn sie parallel sind.
	 */
	public Point meets(Line that) {
		// Toleranzwert für numerische Stabilität
		double epsilon = 1e-10;

		// Berechne den Nenner der Determinante
		double nenner = that.getA() * this.getB() - this.getA() * that.getB();

		// Falls der Nenner (≈ Determinante) nahezu 0 ist, sind die Geraden parallel
		if (Math.abs(nenner) < epsilon) {
			System.out.println("Die Linien sind parallel – Es konnte kein Schnittpunkt berechnet werden.");
			return null;
		}

		// Berechne die x- und y-Koordinaten des Schnittpunkts
		double xS = (that.getB() * this.getC() - that.getC() * this.getB()) / nenner;
		double yS = (that.getC() * this.getA() - that.getA() * this.getC()) / nenner;

		// Gib den Schnittpunkt zurück
		return new Point(xS, yS);
	}

	@Override
	public String toString() {
		return "Line: " + A + " * x + " + B + " * y + " + C + " = 0";
	}
}
