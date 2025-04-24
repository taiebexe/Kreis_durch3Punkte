/**
* Modul: Algorithmen und Datenstrukturen im SoSe 2025
* Gruppe 07
* Praktikum 1
* Datum: 24.04.2025
* Version <z.B. 0.1>
* Klasse "TestKreisP1" zur Konstruktion eines Kreises durch 3 Punkte.
 @author Taieb Bourbia ,11379890
 @author Osama Shahin ,
*/




/******************************
* Hauptptprogramm
******************************/
import java.util.Scanner;


class TestKreisP1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// 1. Punkte einlesen
		System.out.println("Geben Sie Punkt A (x y) ein:");
		Point A = new Point(scanner.nextDouble(), scanner.nextDouble());

		System.out.println("Geben Sie Punkt B (x y) ein:");
		Point B = new Point(scanner.nextDouble(), scanner.nextDouble());

		System.out.println("Geben Sie Punkt C (x y) ein:");
		Point C = new Point(scanner.nextDouble(), scanner.nextDouble());

		// 2. Abbruch, falls Punkte gleich sind
		if (A.equalTo(B) || A.equalTo(C) || B.equalTo(C)) {
			System.out.println("Fehler: Mindestens zwei Punkte sind gleich. Abbruch.");
			return;
		}

		// 3. Hilfskreise mit geeigneten Radien konstruieren
		double ab = A.distanceTo(B);
		double bc = B.distanceTo(C);
		double r1 = ab * 0.6;
		double r2 = ab * 0.6;
		double r3 = bc * 0.6;

		Circle K1 = new Circle(A, r1);
		Circle K2 = new Circle(B, r2);
		Circle K3 = new Circle(C, r3);

		// 4. Geraden aus Schnittpunkten der Hilfskreise bestimmen
		Line l1 = K1.intersects(K2);
		Line l2 = K2.intersects(K3);

		// 5. Abbruch bei parallelen Geraden
		if (l1 == null || l2 == null || Math.abs(l1.getA() * l2.getB() - l2.getA() * l1.getB()) < 1e-10) {
			System.out.println("Fehler: Geraden sind parallel oder keine Schnittpunkte vorhanden. Abbruch.");
			return;
		}

		// 6. Schnittpunkt der Geraden = Mittelpunkt des gesuchten Kreises
		Point mittelpunkt = l1.meets(l2);
		if (mittelpunkt == null) {
			System.out.println("Fehler: Kein Schnittpunkt der Geraden gefunden. Abbruch.");
			return;
		}

		// 7. Radius berechnen
		double radius = mittelpunkt.distanceTo(A);

		// 8. Ausgabe
		System.out.println("Mittelpunkt: " + mittelpunkt);
		System.out.println("Radius: " + radius);
	}
}
