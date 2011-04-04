/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package linesegintersection;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import mnm.ds.line;
import mnm.ds.point;

/**
 *
 * @author mnm
 */
public class InterSection {

    
    PriorityQueue<Integer> Queue=new PriorityQueue<Integer>();


    

    public void test(){

        
    }
   

    public void createAllline() {
        Iterator iter2 = Points.entrySet().iterator();
        int i = 0;
        while (iter2.hasNext()) {//lop on other point that not equal to p,q(line 4 of algorithm)!
            Map.Entry entry2 = (Map.Entry) iter2.next();
            point m = (point) entry2.getKey();
            Iterator iter3 = Points.entrySet().iterator();
            while (iter3.hasNext()) {//lop on other point that not equal to p,q(line 4 of algorithm)!
                Map.Entry entry3 = (Map.Entry) iter3.next();
                point m2 = (point) entry3.getKey();
                if (!m.equals(m2)) {
//                    if(!containsKeys(all,m2,m))
                    allLine.put(new line(m, m2), i++);
                }
            }
        }
        System.out.println("Number Of all line (from p to q and from q to p)! :\t" + allLine.size());
    }

    public boolean containsKeys(Object p, point a, point b) {
        boolean result = false;
        Hashtable<line, Integer> poin = (Hashtable<line, Integer>) p;
        Iterator it = poin.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {//lop on other point that not equal to p,q(line 4 of algorithm)!
            Map.Entry entry2 = (Map.Entry) it.next();
            line temp = (line) entry2.getKey();
            if (pointEqaul(temp.first, a) && pointEqaul(temp.secend, b)) {
                return true;
            }
        }

        return result;

    }

    public boolean pointEqaul(point a, point b) {
        if (a.x == b.x && a.y == b.y) {
            return true;
        } else {
            return false;
        }
    }
}
