/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package linesegintersection;

/**
 *
 * @author mnm
 */
import java.util.*;

/**
 * @author Kunuk Nykjaer
 */

public class ClosestPair {
	public static void main(String[] args) {
		P p1 = new P(2, 3,  "p1");
		P p2 = new P(1, 2, "p2");
		P p3 = new P(3, 6, "p3");
		P p4 = new P(1, 1, "p4");

		P[] points = new P[] { p1, p2, p3, p4 }; // load your own data for testing

		Arrays.sort(points, xComparator); // sort by x, then y
		P[] closest = findClosest(points);
		for (P p : closest)
			System.out.println(p);
	}

	/**
	 * Closest pair O(nlogn)
	 * Ashish Sharma
	 * Rengakrishnan Subramanian
	 * November 28, 2001
	 * http://www.cis.ksu.edu/~subbu/Papers/Closest%20pair.pdf
	 */
	static P[] findClosest(P[] px) {
		// px must be sorted in x, then y
		int n = px.length;

		if (n <= 3)
			return shortest(px);
		else {
			int left = n / 2;
			int right = n / 2 + n % 2;

			// sets
			P[] Pleft = new P[left];
			P[] Pright = new P[right];
			P[] Pleftmin, Prighttmin, Pclosest;

			for (int i = 0; i < left; i++)
				Pleft[i] = px[i];
			for (int i = 0; i < right; i++)
				Pright[i] = px[i + left];

			Pleftmin = findClosest(Pleft);
			Prighttmin = findClosest(Pright);
			Pclosest = mergePlanes(Pleftmin, Prighttmin);
			return Pclosest;
		}
	}

	static P[] mergePlanes(P[] p1, P[] p2) {
		P[] pAll = union(p1, p2);
		P[] closest = shortest(pAll);


		double D = closest[0].distance(closest[1]); // delta

                System.out.println(D);
		for (int i = 0; i < p1.length; i++) {
			for (int j = 0; j < p2.length; j++) {
				P pi = p1[i];
				P pj = p2[j];
				if (pi.equals(pj))
					continue;

				double xi = p1[i].getX();
				double xj = p2[j].getX();
				double yi = p1[i].getY();
				double yj = p2[j].getY();

				if (xi < xj + D && yi + D > yj && yj > yi - D) {
					if (pi.distance(pj) < D) {
						return new P[] { pi, pj };
					}
				}
			}
		}
		P[] pMin = new P[] { closest[0], closest[1] };
		return pMin;
	}

	// O(n^2) naive version of closest pair
	static P[] shortest(P[] ps) {
		P p1 = null;
		P p2 = null;

		double distance = Double.MAX_VALUE;
		for (int i = 0; i < ps.length; i++) {
			for (int j = 0; j < i; j++) {
				if (i == j)
					continue;
				P ptemp1 = ps[i];
				P ptemp2 = ps[j];
				if (ptemp1.equals(ptemp2))
					continue;

				double newDistince = distance(ptemp1, ptemp2);
				if (newDistince < distance) {
					// update
					distance = newDistince;
					p1 = ptemp1;
					p2 = ptemp2;
				}
			}
		}
		return new P[] { p1, p2 };
	}

	static P[] union(P[] ps1, P[] ps2) {
		P[] ps = new P[ps1.length + ps2.length];
		for (int i = 0; i < ps1.length; i++)
			ps[i] = ps1[i];
		for (int i = 0; i < ps2.length; i++)
			ps[i + ps1.length] = ps2[i];
		return ps;
	}

	static double distance(P p1, P p2) {
		return p1.distance(p2); // java api, Euclidean dist
	}

	static final Comparator<P> xComparator = new Comparator<P>() {
		@Override
		public int compare(P a, P b) {
			if (a.x < b.x) {
				return -1;
			}
			if (a.x > b.x) {
				return 1;
			}
			// if equal, sort by y
			if (a.y < b.y) {
				return -1;
			}
			if (a.y > b.y) {
				return 1;
			}
			return 0;
		}
	};
}
