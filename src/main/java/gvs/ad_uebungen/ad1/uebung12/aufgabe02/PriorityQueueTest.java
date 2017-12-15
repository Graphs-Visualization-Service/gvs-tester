/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 21 19:15:47 CEST 2017
 */

package gvs.ad_uebungen.ad1.uebung12.aufgabe02;

import java.util.Random;

public class PriorityQueueTest {

  private static void stressTest() throws FullPriorityQueueException {
    System.out.print("\nStress-Test: ... ");
    final int NUMBER_OF_TESTS = 1000000;
    final int LENGTH_RANGE = 10;
    final int DATA_RANGE = 10;
    Random random = new Random(1);
    for (int testNr = 0; testNr < NUMBER_OF_TESTS; testNr++) {
      int length = (int) (random.nextDouble() * LENGTH_RANGE + 1);
      int[] array = new int[length];
      for (int i = 0; i < length; i++) {
        int number = (int) (random.nextDouble() * DATA_RANGE + 1);
        array[i] = number;
      }
      PriorityQueue<Integer, String> ourPQ = new PriorityQueue<>(length);
      java.util.PriorityQueue<Integer> javaPQ = new java.util.PriorityQueue<>();
      for (int i : array) {
        ourPQ.insert(i, "Value_" + i);
        javaPQ.add(i);
      }
      for (int i = 0; i < array.length; i++) {
        if (ourPQ.size() != javaPQ.size()) {
          System.out.println("ERROR: wrong size!");
          System.exit(1);
        }
        if (ourPQ.removeMin().getKey() != javaPQ.poll()) {
          System.out.println("ERROR: wrong removeMin()!");
          System.exit(1);
        }
      }
      if (ourPQ.removeMin() != null) {
        System.out.println("ERROR: removeMin() != null");
        System.exit(1);
      }
    }
    System.out.println("o.k.");
  }

  public static void main(String[] args) throws FullPriorityQueueException {

    PriorityQueue<Integer, String> pq = new PriorityQueueGVS<>(5);
    System.out.println("insert()'s: ");
    pq.print();
    pq.insert(4, "D");
    pq.print();
    pq.insert(5, "E");
    pq.print();
    pq.insert(3, "C");
    pq.print();
    pq.insert(2, "B");
    pq.print();
    pq.insert(1, "A");
    pq.print();
    System.out.println("\nmin(): " + pq.min());
    while (pq.size() > 1) {
      System.out.println("removeMin(): " + pq.removeMin());
      pq.print();
    }

    if (pq instanceof PriorityQueueGVS) {
      ((PriorityQueueGVS<Integer, String>) pq).gvsTree.disconnect();
    }

    stressTest();

  }

}

/*
 * Session-Log:
 * 
 * insert()'s: [null, null, null, null, null, null] [null, (4,D), null, null,
 * null, null] [null, (4,D), (5,E), null, null, null] [null, (3,C), (5,E),
 * (4,D), null, null] [null, (2,B), (3,C), (4,D), (5,E), null] [null, (1,A),
 * (2,B), (4,D), (5,E), (3,C)]
 * 
 * min(): (1,A) removeMin(): (1,A) [null, (2,B), (3,C), (4,D), (5,E), null]
 * removeMin(): (2,B) [null, (3,C), (5,E), (4,D), null, null] removeMin(): (3,C)
 * [null, (4,D), (5,E), null, null, null] removeMin(): (4,D) [null, (5,E), null,
 * null, null, null]
 * 
 * Stress-Test: ... o.k.
 * 
 */
