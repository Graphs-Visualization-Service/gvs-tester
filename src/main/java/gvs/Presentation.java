package gvs;
/*
  * Created on 16.12.2005
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

public class Presentation {

  public static void main(String[] args) {

    GVSStyle image1 = new GVSStyle(GVSColor.STANDARD, GVSLineStyle.THROUGH,
        GVSLineThickness.STANDARD, GVSColor.STANDARD, GVSIcon.BELL);

    MyRelativVertex rel1 = new MyRelativVertex("1", image1, 10, 10);
    MyRelativVertex rel2 = new MyRelativVertex("", image1, 20, 20);
    MyRelativVertex rel3 = new MyRelativVertex("", image1, 30, 30);
    MyRelativVertex rel4 = new MyRelativVertex("", image1, 40, 40);
    MyRelativVertex rel5 = new MyRelativVertex("", image1, 50, 50);
    MyRelativVertex rel6 = new MyRelativVertex("", image1, 60, 60);
    MyRelativVertex rel7 = new MyRelativVertex("7", null, 70, 70);
    MyRelativVertex rel8 = new MyRelativVertex("8", null, 80, 80);
    MyRelativVertex rel9 = new MyRelativVertex("9", null, 90, 90);
    MyRelativVertex rel10 = new MyRelativVertex("10", null, 5, 10);
    MyRelativVertex rel11 = new MyRelativVertex("11", null, 20, 5);
    MyRelativVertex rel12 = new MyRelativVertex("12", null, 5, 30);
    MyRelativVertex rel13 = new MyRelativVertex("13", null, 40, 5);
    MyRelativVertex rel14 = new MyRelativVertex("14", null, 5, 50);
    MyRelativVertex rel15 = new MyRelativVertex("15", null, 60, 5);
    MyRelativVertex rel16 = new MyRelativVertex("16", null, 5, 70);
    MyRelativVertex rel17 = new MyRelativVertex("17", null, 80, 5);
    MyRelativVertex rel18 = new MyRelativVertex("18", null, 5, 90);

    // MyUndirectedEdge e1 = new MyUndirectedEdge();
    GVSGraph mygraph = new GVSGraph("Map");
    mygraph.add(rel1);
    mygraph.add(rel2);
    mygraph.add(rel3);
    mygraph.add(rel4);
    mygraph.add(rel5);
    mygraph.add(rel6);
    mygraph.add(rel7);
    mygraph.add(rel8);
    mygraph.add(rel9);
    mygraph.add(rel10);
    mygraph.add(rel11);
    mygraph.add(rel12);
    mygraph.add(rel13);
    mygraph.add(rel14);
    mygraph.add(rel15);
    mygraph.add(rel16);
    mygraph.add(rel17);
    mygraph.add(rel18);

    mygraph.display();
    mygraph.disconnect();

  }

}
