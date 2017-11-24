package gvs;

import gvs.graph.GVSGraph;
import gvs.styles.GVSColor;
import gvs.styles.GVSIcon;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;

public class TestGraphMixed {

  GVSStyle unexploredEdge;
  GVSStyle discoveredEdge;
  GVSStyle backEdge;
  GVSStyle unexploredVertex;
  GVSStyle visitedVertex;
  GVSGraph g;

  public TestGraphMixed() {

    unexploredEdge = new GVSStyle(GVSColor.BLACK, GVSLineStyle.DOTTED,
        GVSLineThickness.SLIGHT, null, null);

    discoveredEdge = new GVSStyle(GVSColor.RED, GVSLineStyle.DOTTED,
        GVSLineThickness.SLIGHT, null, null);

    backEdge = new GVSStyle(GVSColor.GREEN, GVSLineStyle.DOTTED,
        GVSLineThickness.SLIGHT, null, null);

    unexploredVertex = new GVSStyle(GVSColor.BLACK, GVSLineStyle.THROUGH,
        GVSLineThickness.STANDARD, GVSColor.BLUE, null);

    visitedVertex = new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED,
        GVSLineThickness.FAT, null, GVSIcon.BELL);
  }

  public static void main(String[] args) {
    TestGraphMixed test = new TestGraphMixed();
    test.test();

    GVSGraph myGraph = new GVSGraph("Mein Graph");

    GVSStyle vertexStyle = new GVSStyle(GVSColor.BLACK, GVSLineStyle.THROUGH,
        GVSLineThickness.STANDARD, GVSColor.BLUE, null);
    MyDefaultVertex ver1 = new MyDefaultVertex("HiVertex", vertexStyle);

    ver1.getGVSVertexLabel();
    myGraph.display();
  }

  public void test() {
    MyDefaultVertex v1 = new MyDefaultVertex("Nummer1", unexploredVertex);
    MyDefaultVertex v2 = new MyDefaultVertex("Nummer2", unexploredVertex);
    MyDefaultVertex v3 = new MyDefaultVertex("Nummer3", unexploredVertex);
    MyDefaultVertex v4 = new MyDefaultVertex("Nummer4", unexploredVertex);
    MyDefaultVertex v5 = new MyDefaultVertex("Nummer5", unexploredVertex);
    MyDefaultVertex v6 = new MyDefaultVertex("Nummer6", unexploredVertex);
    MyDefaultVertex v7 = new MyDefaultVertex("Nummer7", unexploredVertex);

    MyDirectedEdge e1 = new MyDirectedEdge("e1", unexploredEdge, v1, v2);
    MyDirectedEdge e2 = new MyDirectedEdge("e2", unexploredEdge, v1, v3);
    MyDirectedEdge e3 = new MyDirectedEdge("e3", unexploredEdge, v2, v4);
    MyDirectedEdge e4 = new MyDirectedEdge("e4", unexploredEdge, v3, v5);
    MyDirectedEdge e5 = new MyDirectedEdge("e4", unexploredEdge, v1, v6);
    MyDirectedEdge e6 = new MyDirectedEdge("e4", unexploredEdge, v2, v7);
    MyDirectedEdge e7 = new MyDirectedEdge("e4", unexploredEdge, v6, v6);

    g = new GVSGraph("Adding");
    g.add(v1);
    g.add(v2);
    g.add(e1);
    g.add(v3);
    g.add(e2);
    g.display();
    g.add(v4);
    g.add(v5);
    // g.display();
    g.add(e3);
    g.add(e4);
    g.add(v6);
    g.add(v7);
    g.display();
    // g.add(v7);
    g.add(e5);
    g.add(e6);
    g.add(e7);

    g.display();

    g.disconnect();
  }

}
