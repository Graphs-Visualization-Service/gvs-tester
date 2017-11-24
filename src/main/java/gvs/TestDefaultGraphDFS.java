package gvs;

import java.util.Iterator;
import java.util.Vector;

import gvs.graph.GVSGraph;
import gvs.typ.GVSDefaultTyp.LineColor;
import gvs.typ.GVSDefaultTyp.LineStyle;
import gvs.typ.GVSDefaultTyp.LineThickness;
import gvs.typ.edge.GVSEdgeTyp;
import gvs.typ.graph.GVSGraphTyp;
import gvs.typ.graph.GVSGraphTyp.Background;
import gvs.typ.vertex.GVSEllipseVertexTyp;
import gvs.typ.vertex.GVSEllipseVertexTyp.FillColor;

public class TestDefaultGraphDFS {
  GVSEdgeTyp unexploredEdge;
  GVSEdgeTyp discoveredEdge;
  GVSEdgeTyp backEdge;
  GVSEllipseVertexTyp unexploredVertex;
  GVSEllipseVertexTyp visitedVertex;
  GVSGraph dfsGraph;
  Vector<MyDirectedEdge> edges = new Vector<MyDirectedEdge>();
  Vector<MyDefaultVertex> nodes = new Vector<MyDefaultVertex>();

  public TestDefaultGraphDFS() {
    unexploredEdge = new GVSEdgeTyp(LineColor.black, LineStyle.dotted,
        LineThickness.slight);

    discoveredEdge = new GVSEdgeTyp(LineColor.red, LineStyle.dotted,
        LineThickness.standard);

    backEdge = new GVSEdgeTyp(LineColor.green, LineStyle.dotted,
        LineThickness.standard);

    unexploredVertex = new GVSEllipseVertexTyp(LineColor.black,
        LineStyle.standard, LineThickness.standard, FillColor.blue);

    visitedVertex = new GVSEllipseVertexTyp(LineColor.red, LineStyle.dashed,
        LineThickness.fat, FillColor.red);

    // DFS oder so
    MyDefaultVertex v1 = new MyDefaultVertex("Vertex1", unexploredVertex);
    MyDefaultVertex v2 = new MyDefaultVertex("Vertex2", unexploredVertex);
    MyDefaultVertex v3 = new MyDefaultVertex("Vertex3", unexploredVertex);
    MyDefaultVertex v4 = new MyDefaultVertex("Vertex4", unexploredVertex);
    MyDefaultVertex v5 = new MyDefaultVertex("Vertex5", unexploredVertex);
    MyDefaultVertex v6 = new MyDefaultVertex("Vertex6", unexploredVertex);
    MyDefaultVertex v7 = new MyDefaultVertex("Vertex7", unexploredVertex);
    MyDefaultVertex v8 = new MyDefaultVertex("Veretx8", unexploredVertex);

    /*
     * MyDefaultVertex v10 = new MyDefaultVertex("Vertex10",unexploredVertex);
     * MyDefaultVertex v11 = new MyDefaultVertex("Vertex11",unexploredVertex);
     * MyDefaultVertex v12 = new MyDefaultVertex("Vertex12",unexploredVertex);
     * MyDefaultVertex v13 = new MyDefaultVertex("Vertex13",unexploredVertex);
     * MyDefaultVertex v14 = new MyDefaultVertex("Veretx14",unexploredVertex);
     * MyDefaultVertex v15 = new MyDefaultVertex("Vertex15",unexploredVertex);
     * MyDefaultVertex v16 = new MyDefaultVertex("Vertex16",unexploredVertex);
     * MyDefaultVertex v17 = new MyDefaultVertex("Vertex17",unexploredVertex);
     * MyDefaultVertex v18 = new MyDefaultVertex("Vertex18",unexploredVertex);
     * MyDefaultVertex v19 = new MyDefaultVertex("Veretx19",unexploredVertex);
     * MyDefaultVertex v20 = new MyDefaultVertex("Vertex20",unexploredVertex);
     * MyDefaultVertex v21 = new MyDefaultVertex("Vertex21",unexploredVertex);
     * MyDefaultVertex v22 = new MyDefaultVertex("Vertex22",unexploredVertex);
     * MyDefaultVertex v23 = new MyDefaultVertex("Vertex23",unexploredVertex);
     * MyDefaultVertex v24 = new MyDefaultVertex("Veretx24",unexploredVertex);
     */

    MyDirectedEdge e1 = new MyDirectedEdge("Edge1", unexploredEdge, v1, v2);
    MyDirectedEdge e2 = new MyDirectedEdge("Edge2", unexploredEdge, v1, v3);
    MyDirectedEdge e3 = new MyDirectedEdge("Edge3", unexploredEdge, v2, v4);
    MyDirectedEdge e4 = new MyDirectedEdge("Edge4", unexploredEdge, v4, v6);
    MyDirectedEdge e5 = new MyDirectedEdge("Edge5", unexploredEdge, v6, v5);
    MyDirectedEdge e6 = new MyDirectedEdge("Edge6", unexploredEdge, v7, v8);
    MyDirectedEdge e7 = new MyDirectedEdge("Edge7", unexploredEdge, v6, v2);
    MyDirectedEdge e8 = new MyDirectedEdge("Edge8", unexploredEdge, v6, v7);

    // MyDirectedEdge e9 = new MyDirectedEdge("Edge8",unexploredEdge,v10,v10);
    dfsGraph = new GVSGraph("DFS Mein erster Versuch",
        new GVSGraphTyp(Background.standard));
    // dfsGraph.setMaxLabelLength(40);

    /*
     * dfsGraph.add(v1); dfsGraph.add(v2); dfsGraph.add(e1); dfsGraph.display();
     * 
     * dfsGraph.add(v3);
     * 
     * 
     * dfsGraph.add(e2);
     * 
     * dfsGraph.display();
     * 
     * 
     * 
     * 
     * 
     * 
     * 
     * /*dfsGraph.add(v5); dfsGraph.add(v6);
     * 
     * dfsGraph.display(); dfsGraph.add(v7); dfsGraph.add(v8);
     * 
     * dfsGraph.display();
     */

    nodes.add(v1);
    nodes.add(v2);
    nodes.add(v3);
    nodes.add(v4);
    nodes.add(v5);
    nodes.add(v6);
    nodes.add(v7);
    nodes.add(v8);

    /*
     * dfsGraph.add(v1); dfsGraph.display(); dfsGraph.add(v2);
     * dfsGraph.display(); dfsGraph.add(v3); dfsGraph.display();
     * dfsGraph.add(v4); dfsGraph.display(); dfsGraph.add(v5);
     * dfsGraph.display(); dfsGraph.add(v6); dfsGraph.display();
     * dfsGraph.add(v7); dfsGraph.display(); dfsGraph.add(v8);
     * dfsGraph.display(); dfsGraph.disconnect();
     */

    /*
     * nodes.add(v10); nodes.add(v11); nodes.add(v12); nodes.add(v13);
     * nodes.add(v14); nodes.add(v15); nodes.add(v16); nodes.add(v17);
     * nodes.add(v18); nodes.add(v19); nodes.add(v20); nodes.add(v21);
     * nodes.add(v22); nodes.add(v23); nodes.add(v24);
     */

    edges.add(e1);
    edges.add(e2);
    edges.add(e3);
    edges.add(e4);
    edges.add(e5);
    edges.add(e6);
    edges.add(e7);
    edges.add(e8);

    dfsGraph.add(nodes);

    dfsGraph.add(edges);

    start();

  }

  public static void main(String[] args) {
    new TestDefaultGraphDFS();

    // new TestDefaultGraphDFS();

  }

  public void start() {
    dfsGraph.display();

    Iterator<MyDefaultVertex> it = nodes.iterator();
    while (it.hasNext()) {
      MyDefaultVertex df = (MyDefaultVertex) (it.next());
      if (df.isExplored() == false) {
        dfs(dfsGraph, df);
      }
    }

    dfsGraph.disconnect();
  }

  public void dfs(GVSGraph pGraph, MyDefaultVertex pVertex) {
    pVertex.setTyp(visitedVertex);
    pVertex.setExplored(true);
    pGraph.display();

    Iterator<MyDirectedEdge> edgeit = edges.iterator();
    while (edgeit.hasNext()) {
      MyDirectedEdge de = (MyDirectedEdge) (edgeit.next());
      if (de.getGVSStartVertex() == pVertex
          || de.getGVSEndVertex() == pVertex) {
        if (de.isExplored() == false) {
          MyDefaultVertex newStart = (MyDefaultVertex) de.getGVSEndVertex();
          if (newStart.isExplored() == false) {
            de.setTyp(discoveredEdge);
            de.setExplored(true);
            pGraph.display();
            dfs(pGraph, newStart);
          } else {
            de.setTyp(backEdge);
            pGraph.display();
            de.setExplored(true);

          }
        }
      }
    }
  }
}
