/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.ds;

import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author mnm
 */
public class PriorityQ  {

    public Vector<point> Event=new Vector<point>();
    public boolean hasMore(){
        if(Event.size()>0)
            return true;
        else
            return false;
    }
    public void insert(point p){
    Event.add(p);
    Collections.sort(Event);
    }
    public point remove(){
       return Event.remove(Event.size());
    }
}
