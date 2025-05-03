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
		System.out.println("Punkt A:");
		System.out.print("x = ");
		double ax = scanner.nextDouble();
		System.out.print("y = ");
		double ay = scanner.nextDouble();
		Point A = new Point(ax, ay);

		System.out.println("Punkt B:");
		System.out.print("x = ");
		double bx = scanner.nextDouble();
		System.out.print("y = ");
		double by = scanner.nextDouble();
		Point B = new Point(bx, by);

		System.out.println("Punkt C:");
		System.out.print("x = ");
		double cx = scanner.nextDouble();
		System.out.print("y = ");
		double cy = scanner.nextDouble();
		Point C = new Point(cx, cy);

		// 2. Abbruch, falls Punkte gleich sind
		if (A.equalTo(B) || A.equalTo(C) || B.equalTo(C)) {
			System.out.println("Fehler: Mindestens zwei Punkte sind gleich. Abbruch.");
			return;
		}

		// 3. Hilfskreise mit geeigneten Radien konstruieren
		double ab = A.distanceTo(B);
		double bc = B.distanceTo(C);
		double r1 = ab * 1.1;
		double r2 = ab * 1.1;
		double r3 = bc * 1.1;

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
