package gvs.tester.graph;

import gvs.business.graph.GVSGraph;
import gvs.model.graph.TestDefaultVertex;
import gvs.model.graph.TestDirectedEdge;
import gvs.business.styles.GVSColor;
import gvs.business.styles.GVSIcon;
import gvs.business.styles.GVSLineStyle;
import gvs.business.styles.GVSLineThickness;
import gvs.business.styles.GVSStyle;

public class HelloWorld {

  public static void main(String[] args) {
    GVSGraph graph = new GVSGraph("Hello World Graph");
    TestDefaultVertex v1 = new TestDefaultVertex("Hello");
    TestDefaultVertex v2 = new TestDefaultVertex("World");
    TestDirectedEdge e = new TestDirectedEdge(v1, v2, "GVS");

    graph.add(v1);
    graph.add(v2);
    graph.add(e);

    graph.display();

    GVSStyle edgeStyle = new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED,
        GVSLineThickness.BOLD);
    GVSStyle vertexStyle = new GVSStyle(GVSColor.BLUE, GVSLineStyle.DOTTED,
        GVSLineThickness.SLIGHT, GVSColor.GREEN);

    v1.setStyle(vertexStyle);
    e.setStyle(edgeStyle);
    graph.display();

    GVSStyle iconStyle = new GVSStyle(GVSColor.STANDARD, GVSLineStyle.THROUGH,
        GVSLineThickness.STANDARD, GVSColor.STANDARD, GVSIcon.BICYCLE);
    v1.setStyle(iconStyle);
    graph.display();
    
    graph.disconnect();
  }
}
