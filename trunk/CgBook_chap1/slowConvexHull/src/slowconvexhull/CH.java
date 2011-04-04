/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package slowconvexhull;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author mnm
 */
public class CH {

    class pair{

        public pair(point first, point secend) {
            this.first = first;
            this.secend = secend;
        }

    point first,secend;
    }
    class point{

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    int x,y;
    }
    Hashtable<pair, Integer> all=new Hashtable<CH.pair, Integer>();
    Hashtable<pair, Integer> CHs=new Hashtable<CH.pair, Integer>();
    Hashtable<point, Integer> Points=new Hashtable<CH.point, Integer>();
    public void algorithm(){
                    System.out.println("\n\n\tList of All Node in Convex Hull \n\n");
        Iterator iter = all.entrySet().iterator();
        boolean valid=false;
        while (iter.hasNext()) {//lop on all pair for first for loop(line 2 of algorithm)!
            Map.Entry entry1 = (Map.Entry) iter.next();
            valid = true;//line 3 of algorithm!
            Iterator iter2 = Points.entrySet().iterator();
            int count=1;
            while (iter2.hasNext()) {//lop on other point that not equal to p,q(line 4 of algorithm)!
                Map.Entry entry2 = (Map.Entry) iter2.next();
                pair m=(pair)entry1.getKey();
                
                
                if(!pointEqaul(m.first,(point)entry2.getKey())&&!pointEqaul(m.secend,(point)entry2.getKey())){
//                System.out.println(m.first.x);
                    if(isLeft(m.first,m.secend,(point)entry2.getKey())){
                    valid=false;//line six of algorithm!
//                    System.out.println(m.first.x+":"+m.first.y+m.secend.x+":"+m.secend.y);
                }//else
//                    System.out.println(count+++":"+m.first.x+":"+m.first.y+m.secend.x+":"+m.secend.y);

                }
            }
//            System.out.println(valid);
            if(valid){//line seven in algorithm for adding to CH!
                CHs.put((pair)entry1.getKey(),(Integer)entry1.getValue());
                pair t=(pair)entry1.getKey();
                System.out.println("("+t.first.x+","+t.first.y+")\t"+(Integer)entry1.getValue());

            }

        }
        System.out.println("Number of Node in Convex is:\t" + CHs.size());
    }
    public boolean isLeft(point p,point q,point r){
//        System.out.println(p.x+":"+p.y);
//        System.out.println(q.x+":"+q.y);
        int right = (q.x - p.x)*(r.y- p.y) - (q.y - p.y)*(r.x - p.x) ;
//System.out.println(right);
        if (right >= 0) {
            return true;
        } else {
            return false;
        }
    }
    public void openFile(String path){

        File file = new File(path);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(file);
            // Here BufferedInputStream is added for fast reading.
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            int i = 0, j = 0;
            while (dis.available() != 0) {
                String te = dis.readLine();
                StringTokenizer tokens = new StringTokenizer(te, ", ");
                j = 0;
                int tem[] = new int[2];

                while (tokens.hasMoreTokens()) {
                    tem[j++] = Integer.parseInt(tokens.nextToken());
                }

//                System.out.println("Node with x="+tem[0]+"\tY="+tem[1]+"\t is add!");
                point p = new point(tem[0], tem[1]);
                Points.put(p, i++);
            }

            System.out.println("Number of Node is:\t" + Points.size());
            // dispose all the resources after using them.
            fis.close();
            bis.close();
            dis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createAllPair(){
        Iterator iter2 = Points.entrySet().iterator();
        int i=0;
            while (iter2.hasNext()) {//lop on other point that not equal to p,q(line 4 of algorithm)!
                Map.Entry entry2 = (Map.Entry) iter2.next();
                point m=(point)entry2.getKey();
                Iterator iter3 = Points.entrySet().iterator();
            while (iter3.hasNext()) {//lop on other point that not equal to p,q(line 4 of algorithm)!
                Map.Entry entry3 = (Map.Entry) iter3.next();
                point m2=(point)entry3.getKey();
                if(!m.equals(m2)){
//                    if(!containsKeys(all,m2,m))
                    all.put(new pair(m,m2),i++ );
                }
            }
            }
        System.out.println("Number Of all pair (from p to q and from q to p)! :\t"+all.size());
    }
    public boolean containsKeys(Object p,point a,point b){
        boolean result=false;
        Hashtable<pair,Integer> poin=(Hashtable<pair, Integer>)p;
        Iterator it = poin.entrySet().iterator();
        int i=0;
            while (it.hasNext()) {//lop on other point that not equal to p,q(line 4 of algorithm)!
                Map.Entry entry2 = (Map.Entry) it.next();
                pair temp=(pair)entry2.getKey();
                if(pointEqaul(temp.first,a) && pointEqaul(temp.secend,b) )
                    return true;
            }

        return result;

    }
    public boolean pointEqaul(point a,point b){
        if(a.x==b.x && a.y==b.y)
            return true;
        else
            return false;
    }
    public void showResult(){

    }
    public static void main(String a[]){
        CH mnm=new CH();
        mnm.openFile("convex");
        mnm.createAllPair();
        mnm.algorithm();
    }
}
