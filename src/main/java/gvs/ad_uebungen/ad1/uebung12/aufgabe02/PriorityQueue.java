/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 21 19:15:47 CEST 2017
 */

package gvs.ad_uebungen.ad1.uebung12.aufgabe02;

/**
 * A heap-based (array-implementation) Priority-Queue with fixed length.
 */
public class PriorityQueue<K extends Comparable<? super K>, V> {

  protected PQEntry<K, V>[] heapArray;

  /** Points to the last element in the heap. */
  protected int last = 0;

  public static class PQEntry<K extends Comparable<? super K>, V>
      implements Entry<K, V>, Comparable<PQEntry<K, V>> {

    protected K key;
    protected V value;

    protected PQEntry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public K getKey() {
      return key;
    }

    @Override
    public V getValue() {
      return value;
    }

    @Override
    public int compareTo(PQEntry<K, V> other) {
      return this.key.compareTo(other.key);
    }

    @Override
    public String toString() {
      return "(" + key + "," + value + ")";
    }

  }

  @SuppressWarnings("unchecked")
  public PriorityQueue(int maxSize) {
    heapArray = new PQEntry[maxSize + 1];
  }

  public Entry<K, V> insert(K key, V value) throws FullPriorityQueueException {
    if (last == heapArray.length - 1) {
      throw new FullPriorityQueueException();
    }
    last++;
    PQEntry<K, V> e = newEntry(key, value);
    heapArray[last] = e;
    upheap(last);
    return e;
  }

  public Entry<K, V> min() {
    if (last == 0) {
      return null;
    } else
      return heapArray[1];
  }

  public Entry<K, V> removeMin() {
    if (last == 0) {
      return null;
    }
    PQEntry<K, V> result = heapArray[1];
    heapArray[1] = heapArray[last];
    heapArray[last] = null;
    last--;
    downheap(1);
    return result;
  }

  protected void upheap(int actualIndex) {
    if (actualIndex == 1) {
      return; // no further upheap-swaps possible
    }
    int parent = actualIndex / 2;
    if (heapArray[parent].compareTo(heapArray[actualIndex]) > 0) {
      swap(parent, actualIndex);
      upheap(parent);
    }
  }

  protected void downheap(int actualIndex) {
    int leftChildIndex = actualIndex * 2;
    int rightChildIndex = leftChildIndex + 1;
    boolean leftChildIsSmaller = checkForPotentialSwap(actualIndex,
        leftChildIndex);
    boolean rightChildIsSmaller = checkForPotentialSwap(actualIndex,
        rightChildIndex);
    if (leftChildIsSmaller && rightChildIsSmaller) {
      if (heapArray[leftChildIndex]
          .compareTo(heapArray[rightChildIndex]) <= 0) {
        swapAndDownheap(actualIndex, leftChildIndex);
      } else {
        swapAndDownheap(actualIndex, rightChildIndex);
      }
    } else if (leftChildIsSmaller) {
      swapAndDownheap(actualIndex, leftChildIndex);
    } else if (rightChildIsSmaller) {
      swapAndDownheap(actualIndex, rightChildIndex);
    }
  }

  protected boolean checkForPotentialSwap(int parent, int child) {
    return (child <= last) && (heapArray[child] != null)
        && (heapArray[parent].compareTo(heapArray[child]) > 0);
  }

  protected void swapAndDownheap(int parent, int child) {
    swap(parent, child);
    downheap(child);
  }

  protected void swap(int parent, int child) {
    PQEntry<K, V> tmp = heapArray[parent];
    heapArray[parent] = heapArray[child];
    heapArray[child] = tmp;
  }

  /**
   * Factory-Method for new entries.
   * 
   * @param key
   *          The key of the new entry.
   * @param value
   *          The value of the new entry.
   * @return The new created Entry.
   */
  protected PQEntry<K, V> newEntry(K key, V value) {
    return new PQEntry<K, V>(key, value);
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return last;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < heapArray.length; i++) {
      PQEntry<K, V> e = heapArray[i];
      if (e != null) {
        sb.append(e);
      } else {
        sb.append("null");
      }
      if (i < heapArray.length - 1) {
        sb.append(", ");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  public void print() {
    System.out.println(toString());
  }

  /**
   * If GVS is in use: The actual state will be shown on GVS.
   */
  public void displayOnGVS() {
  }

}
