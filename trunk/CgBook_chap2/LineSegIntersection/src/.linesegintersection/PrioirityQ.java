/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package linesegintersection;
import linesegintersection.InterSection.point;
/**
 *
 * @author mnm
 */
public class PrioirityQ {

  // array in sorted order, from max at 0 to min at size-1
  private int maxSize;

  private InterSection.point[] queArray;

  private int nItems;

  public PrioirityQ(int s) {
    maxSize = s;
    queArray = new InterSection.point[maxSize];
    nItems = 0;
  }

  public void insert(InterSection.point item) {
    int i;

    if (nItems == 0)
      queArray[nItems++] = item; // insert at 0
    else
    {
      for (i = nItems - 1; i >= 0; i--) // start at end,
      {
        if (item.y > queArray[i].y) // if new item larger,
          queArray[i + 1] = queArray[i]; // shift upward
        else
          // if smaller,
          break; // done shifting
      }
      queArray[i + 1] = item; // insert it
      nItems++;
    } // end else (nItems > 0)
  }

  public InterSection.point remove(){
    return queArray[--nItems];
  }

  public InterSection.point peekMin(){
    return queArray[nItems - 1];
  }

  public boolean isEmpty(){
    return (nItems == 0);
  }

  public boolean isFull(){
    return (nItems == maxSize);
  }
  public static void main(String[] args) {
    PrioirityQ thePQ = new PrioirityQ(5);

//    thePQ.insert();
//    thePQ.insert(50);
//    thePQ.insert(10);
//    thePQ.insert(40);
//    thePQ.insert(20);
//
//    while (!thePQ.isEmpty()) {
//      long item = thePQ.remove();
//      System.out.print(item + " "); // 10, 20, 30, 40, 50
//    }
//    System.out.println("");
  }
}