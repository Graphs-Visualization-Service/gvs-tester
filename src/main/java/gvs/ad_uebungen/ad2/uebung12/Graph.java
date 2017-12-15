/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Mon Dec  5 22:00:14 CET 2016
 */

package gvs.ad_uebungen.ad2.uebung12;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;

import gvs.business.graph.GVSGraph;
import gvs.business.styles.GVSColor;
import gvs.business.styles.GVSLineStyle;
import gvs.business.styles.GVSLineThickness;
import gvs.business.styles.GVSStyle;
import gvs.business.tree.GVSTreeWithCollection;

public class Graph {

  // Simply edge-list-structure.
  // Performance is irrelevant, so we would allow e.g. removeEdge(e) in O(m).
  private List<Vertex> vertices;
  private List<Edge> edges;

  enum VertexState {

    UNEXPLORED(GVSColor.STANDARD, GVSLineStyle.THROUGH,
        GVSLineThickness.STANDARD, GVSColor.STANDARD), VISITED(GVSColor.RED,
            GVSLineStyle.THROUGH, GVSLineThickness.STANDARD, GVSColor.STANDARD);

    private GVSStyle style;

    VertexState(GVSColor lineColor, GVSLineStyle lineStyle,
        GVSLineThickness thickness, GVSColor fillColor) {
      style = new GVSStyle(lineColor, lineStyle, thickness, fillColor);
    }

    public GVSStyle getGVSStyle() {
      return style;
    }

  }

  enum EdgeState {

    UNEXPLORED(GVSColor.STANDARD, GVSLineStyle.THROUGH,
        GVSLineThickness.STANDARD), DISCOVERY(GVSColor.RED,
            GVSLineStyle.THROUGH,
            GVSLineThickness.STANDARD), BACK(GVSColor.GREEN,
                GVSLineStyle.DASHED, GVSLineThickness.STANDARD), FORWARD(
                    GVSColor.GREEN, GVSLineStyle.DOTTED,
                    GVSLineThickness.STANDARD), CROSS(GVSColor.BLUE,
                        GVSLineStyle.DOTTED, GVSLineThickness.STANDARD);

    private GVSStyle style;

    EdgeState(GVSColor lineColor, GVSLineStyle lineStyle,
        GVSLineThickness thickness) {
      style = new GVSStyle(lineColor, lineStyle, thickness);
    }

    public GVSStyle getGVSEdgeTyp() {
      return style;
    }

  }

  // The maps for the labeling:
  private Map<Vertex, VertexState> vertexLabeling = new HashMap<>();
  private Map<Edge, EdgeState> edgeLabeling = new HashMap<>();

  private Deque<Vertex> actualPath = new LinkedList<>();
  private Map<Vertex, List<Vertex>> subtreeNodes = new HashMap<>();

  private GVSGraph gvsGraph;

  private final static int INDENT = 19;

  Graph(String graphTitle) {
    vertices = new LinkedList<>();
    edges = new LinkedList<>();
    initGVS(graphTitle);
  }

  public void insertVertex(Vertex vertex) {
    vertices.add(vertex);
    Collections.sort(vertices);
    if (gvsGraph != null) {
      gvsGraph.add(vertex);
    }
  }

  public void insertEdge(Edge edge) {
    edges.add(edge);
    Collections.sort(edges);
    if (gvsGraph != null) {
      gvsGraph.add(edge);
    }
  }

  public List<Edge> outgoingEdges(Vertex v) {
    List<Edge> outgoingEdges = edges.stream()
        .filter(e -> e.getStartVertex() == v).collect(Collectors.toList());
    return outgoingEdges;
  }

  public Vertex opposite(Vertex v, Edge e) {
    Optional<Edge> result = edges.stream().filter(edge -> edge == e).findAny();
    if (result.isPresent()) {
      if (result.get().getStartVertex() == v) {
        return result.get().getEndVertex();
      }
      if (result.get().getEndVertex() == v) {
        return result.get().getStartVertex();
      }
    }
    return null;
  }

  private void initGVS(String graphTitle) {
    GVSTreeWithCollection dummyTree = new GVSTreeWithCollection("");
    ;
    if ((System.getProperty("NoGVS") == null) && (!dummyTree.isConnected())) {
      String[] text = { "Connection to GVS-Server failed!\n",
          "Start \"GVS_Server_v1.5.jar\" first.",
          "(located in \"7_Zusatzmaterial/GVS)\"" };
      JOptionPane.showMessageDialog(null, text);
      System.exit(2);
    }
    if (dummyTree.isConnected()) {
      dummyTree.disconnect();
    }
    if (System.getProperty("NoGVS") == null) {
      gvsGraph = new GVSGraph(graphTitle);
    }
  }

  public void displayOnGVS() {
    if (gvsGraph != null) {
      gvsGraph.display();
    }
  }

  public void disconnectFromGVS() {
    if (gvsGraph != null) {
      gvsGraph.disconnect();
    }
  }

  public void directedDFS() {
    for (Vertex v : vertices) {
      vertexLabeling.put(v, VertexState.UNEXPLORED);
    }
    for (Edge e : edges) {
      edgeLabeling.put(e, EdgeState.UNEXPLORED);
    }
    for (Vertex v : vertices) {
      if (vertexLabeling.get(v) == VertexState.UNEXPLORED) {
        directedDFS(v);
      }
    }
  }

  private void directedDFS(Vertex v) {
    System.out.format("%-" + INDENT + "s: %s\n", "depthFirstSearch()", v);
    vertexLabeling.put(v, VertexState.VISITED);
    v.setGVSStyle(VertexState.VISITED.getGVSStyle());
    displayOnGVS();
    for (Vertex vertex : actualPath) {
      subtreeNodes.get(vertex).add(v);
    }
    subtreeNodes.put(v, new LinkedList<Vertex>());
    actualPath.push(v);
    for (Edge e : outgoingEdges(v)) {
      System.out.format("%-" + INDENT + "s: %s: ", "Testing", e);
      if (edgeLabeling.get(e) == EdgeState.UNEXPLORED) {
        Vertex w = opposite(v, e);
        if (vertexLabeling.get(w) == VertexState.UNEXPLORED) {
          edgeLabeling.put(e, EdgeState.DISCOVERY);
          e.setGVSEdgeTyp(EdgeState.DISCOVERY.getGVSEdgeTyp());
          displayOnGVS();
          System.out.println(EdgeState.DISCOVERY);
          directedDFS(w);
        } else {
          identifyKindOfEdge(v, e);
          displayOnGVS();
        }
      }
    }
    actualPath.pop();
  }

  private void identifyKindOfEdge(Vertex startVertex, Edge e) {
    Vertex endVertex = opposite(startVertex, e);
    if (actualPath.contains(endVertex)) {
      e.setGVSEdgeTyp(EdgeState.BACK.getGVSEdgeTyp());
      System.out.println(EdgeState.BACK);
    } else if (subtreeNodes.get(startVertex).contains(endVertex)) {
      e.setGVSEdgeTyp(EdgeState.FORWARD.getGVSEdgeTyp());
      System.out.println(EdgeState.FORWARD);
    } else {
      e.setGVSEdgeTyp(EdgeState.CROSS.getGVSEdgeTyp());
      System.out.println(EdgeState.CROSS);
    }
  }

}
