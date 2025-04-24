/**
* Modul: Algorithmen und Datenstrukturen im SoSe 2025
* Gruppe 07
* Praktikum 1
* Datum: 24.04.2025
* Version <z.B. 0.1>
* Klasse "Point" zur Darstellung von Punkten in der Form P (x|y).
* @author Taieb Bourbia ,11379890
 * @author Osama Shahin ,
*/



class Point {
	private double x;
	private double y;

	/**
	 * Konstruktor zur Initialisierung eines Punktes.
	 * @param x x-Koordinate
	 * @param y y-Koordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() { return x; }
	public double getY() { return y; }

	/**
	 * Prüft, ob zwei Punkte gleich sind.
	 * @param p der zu vergleichende Punkt
	 * @return true, wenn Koordinaten gleich sind
	 */
	public boolean equalTo(Point p) {
		return this.x == p.x && this.y == p.y;
	}

	/**
	 * Berechnet die Distanz zu einem anderen Punkt.
	 * @param p anderer Punkt
	 * @return Abstand als double
	 */
	public double distanceTo(Point p) {
		double dx = this.x - p.x;
		double dy = this.y - p.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}