/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package planesweepalgorithm;

public class point implements Comparable<point> {

    public point(int x, int y) {
        this.x = x;
        this.y = y;

    }
    int x, y;

public boolean equals(Object o)
		{
    
			point p = (point)o;
			return (this.x==p.x&&this.y==p.y);
		}
    public String toString() {
        return x + " " + y;
    }

    public int compareTo(point n) {
        if (x < n.x) {
            return -1;
        }
        if (x > n.x) {
            return 1;
        }
        // if equal, sort by y
        if (y < n.y) {
            return -1;
        }
        if (y > n.y) {
            return 1;
        }
        return 0;
    }
}
