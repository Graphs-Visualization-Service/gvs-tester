package gvs;
/*
 * Created on 10.12.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import gvs.graph.GVSGraph;
import gvs.tree.GVSTreeWithRoot;

public class TypTester {

  /**
   * @param args
   */
  public static void main(String[] args) {
    TypTester tester = new TypTester();

    tester.graphTester();

    // tester.treeTester();
  }

  public void graphTester() {
    TypsGraph typ = new TypsGraph();

    GVSGraph g = new GVSGraph("Typ", null);

    MyDefaultVertex rv2 = new MyDefaultVertex("Rel6", typ.typ6);
    MyDefaultVertex rv3 = new MyDefaultVertex("Rel1", typ.typ2);
    MyDefaultVertex rv4 = new MyDefaultVertex("Rel2", typ.typ5);
    MyDefaultVertex rv5 = new MyDefaultVertex("Rel3", typ.typ9);
    MyDefaultVertex rv7 = new MyDefaultVertex("Rel4", typ.typ3);
    MyDefaultVertex rv6 = new MyDefaultVertex("Rel5", typ.typ8);

    MyUndirectedEdge ue1 = new MyUndirectedEdge("E1", typ.t1,
        new MyDefaultVertex[] { rv2, rv3 });
    MyUndirectedEdge ue2 = new MyUndirectedEdge("E2", typ.t2,
        new MyDefaultVertex[] { rv3, rv4 });
    MyUndirectedEdge ue3 = new MyUndirectedEdge("E3", typ.t3,
        new MyDefaultVertex[] { rv4, rv5 });

    MyDirectedEdge e1 = new MyDirectedEdge("E4", typ.t4, rv5, rv6);
    MyDirectedEdge e2 = new MyDirectedEdge("E5", typ.t5, rv6, rv7);
    MyDirectedEdge e3 = new MyDirectedEdge("E6", typ.t6, rv7, rv2);

    g.add(rv2);
    g.add(rv3);
    g.add(rv4);
    g.add(rv5);
    g.add(rv6);
    g.add(rv7);
    g.add(ue1);
    g.add(ue2);
    g.add(ue3);
    g.add(e1);
    g.add(e2);
    g.add(e3);
    g.display();

    MyDefaultVertex rv1 = new MyDefaultVertex("Def1", typ.typi1);
    g.add(rv1);
    g.display();

    rv1.setTyp(typ.typ2);
    g.display();

    rv1.setTyp(typ.typ3);
    g.display();

    rv1.setTyp(typ.typ4);
    g.display();
    rv1.setTyp(typ.typ5);
    g.display();

    rv1.setTyp(typ.typ6);
    g.display();

    rv1.setTyp(typ.typ7);
    g.display();

    rv1.setTyp(typ.typ8);
    g.display();

    rv1.setTyp(typ.typ9);
    g.display();

    rv1.setTyp(typ.typ10);
    g.display();

    rv1.setTyp(typ.typ11);
    g.display();

    rv1.setTyp(typ.typ12);
    g.display();

    rv1.setTyp(typ.typi1);
    g.display();

    rv1.setTyp(typ.typi2);
    g.display();
    rv1.setTyp(typ.typi3);
    g.display();

    rv1.setTyp(typ.typi4);
    g.display();

    rv1.setTyp(typ.typi5);
    g.display();

    rv1.setTyp(typ.typi6);
    g.display();

    rv1.setTyp(typ.typi7);
    g.display();

    rv1.setTyp(typ.typi8);
    g.display();

    rv1.setTyp(typ.typi9);
    g.display();

    rv1.setTyp(typ.typi10);
    g.display();

    g.disconnect();

  }

  public void treeTester() {
    TypTree typ = new TypTree();

    GVSTreeWithRoot g = new GVSTreeWithRoot("Typ");
    MyBinaryNode rv1 = new MyBinaryNode("Bin1", typ.typ1);
    g.setRoot(rv1);
    g.display();

    rv1.setTyp(typ.typ2);
    g.display();

    rv1.setTyp(typ.typ3);
    g.display();

    rv1.setTyp(typ.typ4);
    g.display();
    rv1.setTyp(typ.typ5);
    g.display();

    rv1.setTyp(typ.typ6);
    g.display();

    rv1.setTyp(typ.typ7);
    g.display();

    rv1.setTyp(typ.typ8);
    g.display();

    rv1.setTyp(typ.typ9);
    g.display();

    rv1.setTyp(typ.typ10);
    g.display();

    rv1.setTyp(typ.typ11);
    g.display();

    rv1.setTyp(typ.typ12);
    g.display();

    g.disconnect();
  }
}
