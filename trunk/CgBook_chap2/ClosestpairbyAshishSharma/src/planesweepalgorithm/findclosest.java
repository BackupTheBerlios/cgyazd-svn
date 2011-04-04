/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package planesweepalgorithm;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author mnm
 */
public class findclosest {

    

    public List<point> all=new ArrayList<point>();
    public List<point> findclosest(List<point> p,int n){
        if(n<=3)
        {
            return shortestpath(p);
        }
        else
        {
            List<point> hp1=new ArrayList<point>();
            List<point> hp2=new ArrayList<point>();
            for(int i=0;i<p.size()/2;i++)
                hp1.add(p.get(i));
            for(int i=p.size()/2;i<p.size();i++)
                hp2.add(p.get(i));
            System.out.println(hp1.size()+"::\t"+hp2.size());
            List<point> pleftmin=findclosest(hp1, hp1.size());
            List<point> prightmin=findclosest(hp2, hp2.size());
            System.out.println(prightmin.get(0).x+":\t"+pleftmin.get(0).x);
            List<point> pcloses=MERGEPLANES(pleftmin, prightmin);
            System.out.println(pcloses.size());
            return pcloses;
        }
        
    }
    public List<point> MERGEPLANES(List<point> p1,List<point> p2){
    List<point> res=new ArrayList<point>();
    List<point> del=minimum(p1,p2);
    double delta=ecluidance(del.get(0),del.get(1));
    System.out.println("delta"+delta);
    for(point pone:p1)
        for(point ptwo:p2)
        {

            if(pone.equals(ptwo))continue;
            if(pone.x<(ptwo.x+delta) && ((pone.y+delta)>ptwo.y && ptwo.y>(pone.y-delta)))
            {
                System.out.println(ecluidance(pone, ptwo)+"eclude\t"+delta);
                if(ecluidance(pone, ptwo)<delta){
                    res.add(pone);
                    res.add(ptwo);
                    return res;
                }

            }
        }

    return del;
    }
    public List<point> minimum(List<point> p1,List<point> p2){
        double delta=Double.MAX_VALUE,min;
        int i=0,j=0;
        List<point> res=new ArrayList<point>();
        for(point ss:p2)
            p1.add(ss);
        for(point l:p1){

            for(point s:p1)
            {
                if(s.equals(l))continue;
                min=ecluidance(l, s);
                if(min<delta)
                {
                    delta=min;
                    res=new ArrayList<point>();
                    res.add(l);
                    res.add(s);
                }
                j++;
            }
            i++;
        }
    return res;
    }
    public List<point> shortestpath(List<point> p){
        if(p.size()==2){
        return p;
        }
        Object pa[]=p.toArray();
        List<point> result=new ArrayList<point>();
        double min=0,min2=0,min3=0;

        if(p.size()==3){
        min=ecluidance((point)pa[0], (point)pa[1]);
        min2=ecluidance((point)pa[1], (point)pa[2]);
        min3=ecluidance((point)pa[0], (point)pa[2]);
        }
        
        if(min <= min2 &&  min <= min3)
        {
            result.add((point)pa[0]);
            result.add((point)pa[1]);
        }
        if(min2 <= min &&  min2 <= min3)
        {
            result.add((point)pa[1]);
            result.add((point)pa[2]);
        }
        if(min3 <= min2 &&  min3 <= min)
        {
            result.add((point)pa[0]);
            result.add((point)pa[2]);
        }
        return result;
    }
    public void showResult(List<point> result){
        System.out.println("----------------------------------");
        System.out.println("First Point:\t"+result.get(0).x+"\t"+result.get(0).y+"\n ");
        System.out.println("Secend Point:\t"+result.get(1).x+"\t"+result.get(1).y+"\n ");
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
                StringTokenizer tokens = new StringTokenizer(te, " ");
                j = 0;
                int tem[] = new int[2];
                while (tokens.hasMoreTokens()) {
                    tem[j++] = Integer.parseInt(tokens.nextToken());
                }
                point p = new point(tem[0], tem[1]);
                all.add(p);
                
            }
            System.out.println("Number of Node is:\t" + all.get(0).x);
            Collections.sort(all);
            System.out.println("Number of Node is:\t" + all.get(0).x);
            System.out.println("Number of Node is:\t" + all.size());
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
    public double ecluidance(point p1,point p2){
        double result=0;
        result=Math.sqrt(Math.pow((p1.x-p2.x),2.0)+Math.pow((p1.y-p2.y),2.0));
        return result;
    }
    public static void main(String a[]){
            findclosest fc=new findclosest();
            fc.openFile("point");
            
            fc.showResult(fc.findclosest(fc.all,4));
    }
}
