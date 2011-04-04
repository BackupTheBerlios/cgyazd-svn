/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author mnm
 */
public class balanceTree {

    List<line> tau=new ArrayList<line>();
    public line remove(){
        line temp=tau.get(tau.size());
        tau.remove(tau.size());
        return temp;
    }
    public void remove(line l){
        tau.remove(l);
    }
    public line getRight(point p){
        line resutl=new line(p, p);
        return resutl;
    }
    public line getLeft(point p){
        line resutl=null;
        for(line l:tau){
            if(l.first.x>p.x)
                return resutl;
            resutl=l;
        }
        return resutl;
    }
    public line getRight(line l){
        int result=tau.indexOf(l);
        return tau.get(result+1);
    }
    public line getLeft(line l){
        int result=tau.indexOf(l);
        return tau.get(result-1);
    }
    public line getLeftMost(Vector<line> l){
        Collections.sort(l);
        return l.get(0);
    }
    public line getRightMost(Vector<line> l){
        Collections.sort(l);
        return l.get(l.size()-1);
    }
    public Vector<line> getU(point p){
        Vector<line> res=new Vector<line>();
        for(line l:tau){
            if((l.first.U&&l.first.equals(p))||(l.secend.U&&l.secend.equals(p)))
                res.add(l);
        }
        return res;
    }
    public Vector<line> getL(point p){
        Vector<line> res=new Vector<line>();
        for(line l:tau){
            if((l.first.L&&l.first.equals(p))||(l.secend.L&&l.secend.equals(p)))
                res.add(l);
        }
        return res;
    }
    public Vector<line> getC(point p){
        Vector<line> res=new Vector<line>();
        for(line l:tau){
            if(testContent(l,p))
                res.add(l);
        }
        return res;
    }
    public boolean testContent(line l,point p){
    if((p.y-l.secend.y)/(p.x-l.secend.x)==(p.y-l.first.y)/(p.x-l.first.x))
        return true;
    else
        return false;
    }
    public void insert(line l){
        tau.add(l);
        Collections.sort(tau);

    }
}
