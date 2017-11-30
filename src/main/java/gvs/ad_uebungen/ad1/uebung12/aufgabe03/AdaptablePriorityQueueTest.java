/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 21 19:17:17 CEST 2017
 */

package gvs.ad_uebungen.ad1.uebung12.aufgabe03;

import gvs.ad_uebungen.ad1.uebung12.aufgabe02.Entry;
import gvs.ad_uebungen.ad1.uebung12.aufgabe02.FullPriorityQueueException;

public class AdaptablePriorityQueueTest {

  public static void main(String[] args) throws FullPriorityQueueException,
      InvalidEntryException {

    AdaptablePriorityQueue<Integer, String> apq = 
        new AdaptablePriorityQueueGVS<>(5);
    
    System.out.println("\ninsert()'s:");
    Entry<Integer, String> e4 = apq.insert(4, "D");
    apq.print();
    Entry<Integer, String> e31 = apq.insert(3, "C-1");
    apq.print();
    Entry<Integer, String> e32 = apq.insert(3, "C-2");
    apq.print();
    Entry<Integer, String> e2 = apq.insert(2, "B");
    apq.print();
    Entry<Integer, String> e1 = apq.insert(1, "A");
    apq.print();
    System.out.println("\nreplaceKey()'s:");
    apq.replaceKey(e31, 1);
    apq.print();
    apq.replaceKey(e1, 3);
    apq.print();
    apq.replaceKey(e4, 1);
    apq.print();
    apq.replaceKey(e32, 1);
    apq.print();
    
    if (apq instanceof AdaptablePriorityQueueGVS) {
      ((AdaptablePriorityQueueGVS<Integer, String>)apq).gvsTree.disconnect();
    }

  }

}


/* Session-Log:

insert()'s:
[null, (4,D), null, null, null, null]
[null, (3,C-1), (4,D), null, null, null]
[null, (3,C-1), (4,D), (3,C-2), null, null]
[null, (2,B), (3,C-1), (3,C-2), (4,D), null]
[null, (1,A), (2,B), (3,C-2), (4,D), (3,C-1)]

replaceKey()'s:
[null, (1,A), (1,C-1), (3,C-2), (4,D), (2,B)]
[null, (1,C-1), (2,B), (3,C-2), (4,D), (3,A)]
[null, (1,C-1), (1,D), (3,C-2), (2,B), (3,A)]
[null, (1,C-1), (1,D), (1,C-2), (2,B), (3,A)]

*/
