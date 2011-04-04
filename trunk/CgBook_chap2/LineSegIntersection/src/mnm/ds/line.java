/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.ds;

/**
 *
 * @author mnm
 */
public class line implements Comparable<line> {

    public line(point p1, point p2) {
        if ((p1.y > p2.y) || (p1.y == p2.y && p1.x < p2.x)) {
            first = p1;
            secend = p2;
        } else {
            secend = p1;
            first = p2;
        }
    }
    point first, secend;

    public boolean equals(Object o) {
        if (!(o instanceof line)) {
            return false;
        }
        line n = (line) o;
        return n.first.equals(first)
                && n.secend.equals(secend);
    }

//    public int hashCode() {
//        return 31 * firstName.hashCode() + lastName.hashCode();
//    }

    public String toString() {
        return first + " " + secend;
    }

    public int compareTo(line n) {
         if (this.first.x < n.first.x || this.secend.x < n.secend.x) {
            return -1;
        }
        if (this.first.x > n.first.x || this.secend.x > n.secend.x) {
            return 1;
        }
        // if equal, sort by y
        if (this.first.y < n.first.y || this.secend.y < n.secend.y) {
            return -1;
        }
        if (this.first.y > n.first.y || this.secend.y > n.secend.y) {
            return 1;
        }
         return 0;
    }
}
