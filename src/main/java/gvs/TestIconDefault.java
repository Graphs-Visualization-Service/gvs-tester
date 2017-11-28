package gvs;
/*
 * Created on 09.12.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import gvs.graph.GVSGraph;
import gvs.styles.GVSColor;
import gvs.styles.GVSIcon;
import gvs.styles.GVSLineStyle;
import gvs.styles.GVSLineThickness;
import gvs.styles.GVSStyle;

public class TestIconDefault {

  GVSStyle edgetyp;
  GVSStyle iconvertex;
  GVSGraph g;

  public TestIconDefault() {

    edgetyp = new GVSStyle(GVSColor.BLACK, GVSLineStyle.DOTTED,
        GVSLineThickness.SLIGHT);

    iconvertex = new GVSStyle(GVSColor.RED, GVSLineStyle.DASHED,
        GVSLineThickness.FAT, GVSColor.STANDARD, GVSIcon.COG);
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    TestIconDefault testicon = new TestIconDefault();
    testicon.test();

  }

  public void test() {
    MyDefaultVertex v1 = new MyDefaultVertex("Nummer1", iconvertex);
    MyDefaultVertex v2 = new MyDefaultVertex("Nummer2", iconvertex);
    MyDefaultVertex v3 = new MyDefaultVertex("Nummer3", iconvertex);
    MyDefaultVertex v4 = new MyDefaultVertex("Nummer4", iconvertex);
    MyDefaultVertex v5 = new MyDefaultVertex("Nummer5", iconvertex);

    MyDirectedEdge e1 = new MyDirectedEdge("e1", edgetyp, v1, v2);
    MyDirectedEdge e2 = new MyDirectedEdge("e2", edgetyp, v1, v3);
    MyDirectedEdge e3 = new MyDirectedEdge("e3", edgetyp, v2, v4);
    MyDirectedEdge e4 = new MyDirectedEdge("e4", edgetyp, v3, v5);

    g = new GVSGraph("Icons");
    g.add(v1);
    g.add(v2);
    g.add(e1);
    g.add(v3);
    g.add(e2);
    g.add(v4);
    g.add(v5);
    g.display();
    g.add(e3);
    g.add(e4);

    g.display();

    g.disconnect();
  }

}
