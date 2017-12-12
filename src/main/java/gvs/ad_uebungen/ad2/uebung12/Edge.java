/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Mon Dec  5 22:00:14 CET 2016
 */

package gvs.ad_uebungen.ad2.uebung12;

import gvs.business.graph.GVSDefaultVertex;
import gvs.business.graph.GVSDirectedEdge;
import gvs.business.styles.GVSStyle;

public class Edge implements Comparable<Edge>, GVSDirectedEdge {

  private String label;
  private GVSStyle style;
  private Vertex startVertex;
  private Vertex endVertex;

  /**
   * The edge-constructor.
   * 
   * @param label
   *          The label to be shown on the edge. 'null' for an empty string.
   * @param style
   *          Defines the 'design' of the vertex (color, etc.). 'null' for
   *          defaults.
   * @param startVertex
   *          The start-vertex of this edge.
   * @param endVertex
   *          The end-vertex of this edge.
   */
  public Edge(String label, GVSStyle style, Vertex startVertex,
      Vertex endVertex) {
    this.label = label;
    this.style = style;
    this.startVertex = startVertex;
    this.endVertex = endVertex;
  }

  @Override
  public String getGVSEdgeLabel() {
    return label;
  }

  @Override
  public GVSStyle getStyle() {
    return style;
  }
  
  public GVSStyle setGVSEdgeTyp(GVSStyle style) {
    GVSStyle old = style;
    this.style = style;
    return old;
  }

  @Override
  public GVSDefaultVertex getGVSStartVertex() {
    return getStartVertex();
  }

  public Vertex getStartVertex() {
    return startVertex;
  }

  @Override
  public GVSDefaultVertex getGVSEndVertex() {
    return getEndVertex();
  }

  public Vertex getEndVertex() {
    return endVertex;
  }

  @Override
  public int compareTo(Edge other) {
    String thisEndVertexLabel = endVertex.getGVSVertexLabel();
    String otherEndVertexLabel = other.getEndVertex().getGVSVertexLabel();
    if (thisEndVertexLabel == otherEndVertexLabel) {
      return 0;
    } else if (thisEndVertexLabel == null) {
      return +1;
    } else if (otherEndVertexLabel == null) {
      return -1;
    } else {
      return thisEndVertexLabel.compareTo(otherEndVertexLabel);
    }
  }

  @Override
  public String toString() {
    return startVertex + "->" + endVertex;
  }
}
