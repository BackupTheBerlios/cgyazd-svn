/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.ds;

/**
 *
 * @author mnm
 */
public class point implements Comparable<point> {

    public point(int x, int y) {
        this.x = x;
        this.y = y;

    }
    int x, y;
    boolean L, U, C;

    public boolean isC() {
        return C;
    }

    public void setC(boolean C) {
        this.C = C;
    }

    public boolean isL() {
        return L;
    }

    public void setL(boolean L) {
        this.L = L;
    }

    public boolean isU() {
        return U;
    }

    public void setU(boolean U) {
        this.U = U;
    }

    public line getpLine() {
        return pLine;
    }

    public void setpLine(line pLine) {
        this.pLine = pLine;
    }
    line pLine;

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
    @Override
    public boolean equals(Object o) {

        point n = (point) o;
        return n.x == this.x
                && n.y == this.y;
    }
    @Override
    public int compareTo(point n) {
        if (this.x < n.x || this.x < n.x) {
            return -1;
        }
        if (this.x > n.x || this.x > n.x) {
            return 1;
        }
        // if equal, sort by y
        if (this.y < n.y || this.y < n.y) {
            return -1;
        }
        if (this.y > n.y || this.y > n.y) {
            return 1;
        }
        return 0;
    }
}
