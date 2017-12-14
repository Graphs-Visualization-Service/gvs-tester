/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Mon Nov 14 14:44:02 CET 2016
 */

package gvs.ad_uebungen.ad2.uebung08;

import java.util.Iterator;

public interface Multimap<K, V> {

  /**
   * Inserts a key/value pair into the multimap.
   */
  void insert(K key, V value);

  /**
   * Returns the first value for a given key.
   * If key is not found: null
   */
  V find(K key);

  /**
   * Returns all values for a given key.
   * @return Iterator over all values.
   *         If key is not found: Iterator without next.
   */
  Iterator<V> findAll(K key);

  /**
   * Removes all values for a given key.
   */
  void remove(K key);

  /**
   * Returns the number of values in the trie.
   */
  int size();

}
 
 
 
