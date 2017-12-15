/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 21 19:17:17 CEST 2017
 */

package gvs.ad_uebungen.ad1.uebung12.aufgabe03;

import gvs.ad_uebungen.ad1.uebung12.aufgabe02.Entry;
import gvs.ad_uebungen.ad1.uebung12.aufgabe02.PriorityQueue;

/**
 * A heap-based (array-implementation) Adaptable-Priority-Queue (APQ) with fixed
 * length.
 */
public class AdaptablePriorityQueue<K extends Comparable<? super K>, V>
    extends PriorityQueue<K, V> {

  public static class APQEntry<K extends Comparable<? super K>, V>
      extends PriorityQueue.PQEntry<K, V> {

    protected int index;

    protected APQEntry(K key, V value, int index) {
      super(key, value);
      this.index = index;
    }

    void setKey(K key) {
      super.key = key;
    }

    void setValue(V value) {
      super.value = value;
    }

  }

  AdaptablePriorityQueue(int maxSize) {
    super(maxSize);
  }

  /**
   * Replaces the key in the given entry and ensures the inner-order afterwards.
   * 
   * @param entry
   *          The entry where to replace the key.
   * @param newKey
   *          The new key.
   * @return The old key.
   * @throws InvalidEntryException
   *           In case of an entry which does not belong the the APQ or for
   *           null.
   */
  public K replaceKey(Entry<K, V> entry, K newKey)
      throws InvalidEntryException {
    APQEntry<K, V> apqEntry = verifyEntry(entry);
    K oldKey = apqEntry.getKey();
    apqEntry.setKey(newKey);
    adjustHeapOrder(apqEntry);
    return oldKey;
  }

  public V replaceValue(Entry<K, V> entry, V newValue)
      throws InvalidEntryException {
    APQEntry<K, V> apqEntry = verifyEntry(entry);
    V oldValue = apqEntry.getValue();
    apqEntry.setValue(newValue);
    return oldValue;
  }

  @Override
  public Entry<K, V> removeMin() {
    APQEntry<K, V> resultApqEntry = (APQEntry<K, V>) super.removeMin();
    if (resultApqEntry != null) {
      resultApqEntry.index = -1;
      if (heapArray[1] != null) {
        ((APQEntry<K, V>) heapArray[1]).index = 1;
      }
    }
    return resultApqEntry;
  }

  /**
   * Removes the given entry from this APQ.
   * 
   * @param entry
   *          The entry to remove.
   * @return The removed entry.
   * @throws InvalidEntryException
   *           In case of an entry which does not belong the the APQ or for
   *           null.
   */
  public Entry<K, V> remove(Entry<K, V> entry) throws InvalidEntryException {
    APQEntry<K, V> apqEntry = verifyEntry(entry);
    int index = apqEntry.index;
    heapArray[index] = heapArray[last];
    ((APQEntry<K, V>) heapArray[index]).index = index;
    heapArray[last] = null;
    last--;
    adjustHeapOrder(apqEntry);
    apqEntry.index = -1;
    return apqEntry;
  }

  private APQEntry<K, V> verifyEntry(Entry<K, V> entry)
      throws InvalidEntryException {
    if (!(entry instanceof APQEntry)) {
      throw new InvalidEntryException(
          "This is not AdaptablePriorityQueue-Entry!");
    }
    APQEntry<K, V> apqEntry = (APQEntry<K, V>) entry;
    if (apqEntry.index == -1) {
      throw new InvalidEntryException(
          "This Entry is not part of the Priority-Queue!");
    }
    return apqEntry;
  }

  private void adjustHeapOrder(APQEntry<K, V> apqEntry) {
    int index = apqEntry.index;
    int parentIndex = index / 2;
    if ((parentIndex > 0) && (heapArray[parentIndex].compareTo(apqEntry) > 0)) {
      upheap(index);
    } else {
      downheap(index);
    }
  }

  @Override
  protected void swap(int parent, int child) {
    super.swap(parent, child);
    // update the Back-References:
    ((APQEntry<K, V>) heapArray[parent]).index = parent;
    ((APQEntry<K, V>) heapArray[child]).index = child;
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
  @Override
  protected PQEntry<K, V> newEntry(K key, V value) {
    return new APQEntry<K, V>(key, value, last);
  }

  /**
   * If GVS is in use: The actual state will be shown on GVS.
   */
  public void displayOnGVS() {
  }

}
