/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package linesegintersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author mnm
 */
public class Main {


    public static void main(String[] args) {
        Name nameArray[] = {
            new Name("John", "Lennon"),
            new Name("Karl", "Marx"),
            new Name("Groucho", "Marx"),
            new Name("Oscar", "Grouch")
        };
        List<Name> names = Arrays.asList(nameArray);
        List<Name> na=new ArrayList<Name>();
        for(Name m:nameArray)
            na.add(m);
        Name ms=na.remove(3);
        Collections.sort(names);
        System.out.println(names);
        
        System.out.println(names.size());
}





}
