/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mnm.algorithm;

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
import java.util.Vector;
import mnm.ds.PriorityQ;
import mnm.ds.balanceTree;
import mnm.ds.line;
import mnm.ds.point;

/**
 *
 * @author mnm
 */
public class LineIntersection {

    String filePath;
    Hashtable<line, Integer> allLine = new Hashtable<line, Integer>();
    Hashtable<point, Integer> Points = new Hashtable<point, Integer>();
    PriorityQ Q = new PriorityQ();
    balanceTree bTree = new balanceTree();

    public void FINDINTERSECTIONS() {
        openFile(filePath);
        addToTree();
        while(Q.hasMore()){
            point p=Q.remove();
            HandleEventPoint(p);
        }
    }

    public void HandleEventPoint(point p){
        Vector<line> U=bTree.getU(p);
        Vector<line> L=bTree.getL(p);
        Vector<line> C=bTree.getC(p);
        if(U.size()+L.size()+C.size()>1){
            showIntPoint(p);
        }


        for(line l:L)
            bTree.remove(l);
        for(line c:C)
            bTree.remove(c);
        for(line u:U)
            bTree.insert(u);
        for(line c:C)
            bTree.insert(c);

        if(U.size()+C.size()==0){
            line sleft=bTree.getLeft(p);
            line sright=bTree.getRight(p);
            FINDNEWEVENT(sleft,sright,p);
        }else{
            Vector<line> res=new Vector<line>();
            for(line l:U)
                res.add(l);
            for(line l:C)
                res.add(l);
            line leftMost=bTree.getLeftMost(res);
            line left=bTree.getLeft(leftMost);
            FINDNEWEVENT(leftMost, left, p);

            line rightMost=bTree.getRightMost(res);
            line right=bTree.getRight(leftMost);
            FINDNEWEVENT(rightMost, right, p);
        }
    }
    public void FINDNEWEVENT(line sleft ,line sright , point p){
        if(intersect(sleft,sright,p)&&true){
        }
    }
    public boolean intersect(line l,line r,point p){
        return true;
    }
    public void showIntPoint(point p){
        System.out.println(p.toString());
    }
    public void openFile(String path) {

        File file = new File(path);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            int i = 0, j = 0;
            while (dis.available() != 0) {
                String te = dis.readLine();
                StringTokenizer tokens = new StringTokenizer(te, ", ");
                j = 0;
                int tem[] = new int[4];

                while (tokens.hasMoreTokens()) {
                    tem[j++] = Integer.parseInt(tokens.nextToken());
                }

                point p1 = new point(tem[0], tem[1]);
                point p2 = new point(tem[2], tem[3]);
                if(tem[1]>tem[3]){
                p1.setU(true);p1.setL(false);
                p2.setU(false);p2.setL(true);
                }else{
                  p1.setU(false);p1.setL(true);
                p2.setU(true);p2.setL(false);
                }
                line l=new line(p1, p2);
                allLine.put(l, i++);
            }

            System.out.println("Number of Node is:\t" + Points.size());
            fis.close();
            bis.close();
            dis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToTree() {
        Iterator iter2 = allLine.entrySet().iterator();
        int i = 0;
        while (iter2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) iter2.next();
            line l = (line) entry2.getKey();
            bTree.insert(l);
        }
    }
}
