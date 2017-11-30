/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 1'
 * Version: Sun May 21 19:17:17 CEST 2017
 */

package gvs.ad_uebungen.ad1.uebung12.aufgabe03;


/**
 * Thrown when an entry is discovered to be invalid.
 */
public class InvalidEntryException extends Exception {
  
  private static final long serialVersionUID = 1L;

  public InvalidEntryException(String message) {
    super(message);
  }
}
