/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Sat Dec 10 19:28:20 CET 2016
 */

package gvs.tester.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gvs.MyRelativVertex;
import gvs.MyUndirectedEdge;
import gvs.graph.GVSGraph;
import gvs.styles.GVSColor;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;

public class Dijkstra {

  private GVSStyle unexploredEdge;
  private GVSStyle discoveredEdge;
  private GVSStyle backEdge;
  private GVSStyle unexploredVertex;
  private GVSStyle visitedVertex;
  private GVSGraph graph;
  private List<MyUndirectedEdge> edges = new ArrayList<>();
  private List<MyRelativVertex> nodes = new ArrayList<>();

  public Dijkstra() {
    unexploredEdge = new GVSStyle(GVSColor.BLACK, GVSLineStyle.DOTTED,
        GVSLineThickness.SLIGHT);

    discoveredEdge = new GVSStyle(GVSColor.RED, GVSLineStyle.DOTTED,
        GVSLineThickness.STANDARD);

    backEdge = new GVSStyle(GVSColor.GREEN, GVSLineStyle.DOTTED,
        GVSLineThickness.STANDARD);

    unexploredVertex = new GVSStyle(GVSColor.BLACK, GVSLineStyle.THROUGH,
        GVSLineThickness.STANDARD, GVSColor.BLUE);

    visitedVertex = new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED,
        GVSLineThickness.FAT, GVSColor.RED);

    graph = new GVSGraph("Dijkstra");
  }

  private void buildGraph() {
    // Vertices:
    MyRelativVertex vA = insertVertex("A", 50, 10);
    MyRelativVertex vB = insertVertex("B", 10, 50);
    MyRelativVertex vC = insertVertex("C", 50, 50);
    MyRelativVertex vD = insertVertex("D", 90, 50);
    MyRelativVertex vE = insertVertex("E", 30, 90);
    MyRelativVertex vF = insertVertex("F", 70, 90);

    // Edges:
    insertEdge(vA, vD, 4);
    insertEdge(vA, vC, 2);
    insertEdge(vA, vB, 8);
    insertEdge(vC, vB, 7);
    insertEdge(vC, vD, 1);
    insertEdge(vC, vE, 3);
    insertEdge(vC, vF, 9);
    insertEdge(vE, vB, 2);
    insertEdge(vD, vF, 5);
    
    graph.display();
  }

  private void insertEdge(MyRelativVertex vA, MyRelativVertex vD, int i) {
    MyRelativVertex[] vertices = new MyRelativVertex[] { vA, vD };
    MyUndirectedEdge e = new MyUndirectedEdge(i+"", null, vertices);
    edges.add(e);
    graph.add(e);
  }

  private MyRelativVertex insertVertex(String string, int x, int y) {
    MyRelativVertex v = new MyRelativVertex(string, null, x, y);
    nodes.add(v);
    graph.add(v);
    return v;
  }
  
  public GVSGraph getGraph() {
    return graph;
  }
  
  public static void main(String[] args) {
    Dijkstra dijkstra = new Dijkstra();
    dijkstra.buildGraph();
    dijkstra.animate();
    dijkstra.getGraph().disconnect();
  }

  private void animate() {
    Random r = new Random();
    int nodeIndex = nodes.size()-1;
    int edgeIndex = edges.size()- 1;
    for (int i = 0 ; i < 10; i++) {
      nodes.get(r.nextInt(nodeIndex)).setStyle(visitedVertex);
      nodes.get(r.nextInt(nodeIndex)).setStyle(unexploredVertex);
      edges.get(r.nextInt(edgeIndex)).setStyle(discoveredEdge);
      edges.get(r.nextInt(edgeIndex)).setStyle(unexploredEdge);
      edges.get(r.nextInt(edgeIndex)).setArrow(1);
      graph.display();
    }
    
  }

}
