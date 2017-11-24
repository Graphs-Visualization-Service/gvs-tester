package gvs;

import gvs.graph.GVSGraph;
import gvs.typ.GVSDefaultTyp.LineColor;
import gvs.typ.GVSDefaultTyp.LineStyle;
import gvs.typ.GVSDefaultTyp.LineThickness;
import gvs.typ.edge.GVSEdgeTyp;
import gvs.typ.graph.GVSGraphTyp;
import gvs.typ.graph.GVSGraphTyp.Background;
import gvs.typ.vertex.GVSEllipseVertexTyp;
import gvs.typ.vertex.GVSEllipseVertexTyp.FillColor;
import gvs.typ.vertex.GVSIconVertexTyp;
import gvs.typ.vertex.GVSIconVertexTyp.Icon;



public class TestGraphMixed {

	GVSEdgeTyp unexploredEdge;
	GVSEdgeTyp discoveredEdge;
	GVSEdgeTyp backEdge;
	GVSEllipseVertexTyp unexploredVertex;
	GVSIconVertexTyp visitedVertex;
	GVSGraph g;
	
	public TestGraphMixed(){
	
		
	
		unexploredEdge = new GVSEdgeTyp(LineColor.black,
				LineStyle.dotted,
					LineThickness.slight);

		discoveredEdge = new GVSEdgeTyp(LineColor.red,
				LineStyle.dotted,
					LineThickness.slight);
		
		backEdge = new GVSEdgeTyp(LineColor.green,
				LineStyle.dotted,
					LineThickness.slight);
		
		
		unexploredVertex= new GVSEllipseVertexTyp(
				LineColor.black,LineStyle.standard,
					LineThickness.standard,FillColor.blue);
		
		visitedVertex= new GVSIconVertexTyp(
				LineColor.red,LineStyle.dashed,
					LineThickness.fat,Icon.BELL);
	}
		
	public static void main(String[] args) {
		TestGraphMixed test = new TestGraphMixed();
		test.test();
		
		
		GVSGraph myGraph = 
			new GVSGraph("Mein Graph",new GVSGraphTyp(Background.standard));
		
		
		MyDefaultVertex ver1 = 
			new MyDefaultVertex("HiVertex",new GVSEllipseVertexTyp(
									LineColor.black,LineStyle.standard,
										LineThickness.standard,FillColor.blue));
		
		
		
		ver1.getGVSVertexLabel();
		myGraph.display();
	}
	
	public void test(){
		MyDefaultVertex v1 = new MyDefaultVertex("Nummer1",unexploredVertex);
		MyDefaultVertex v2 = new MyDefaultVertex("Nummer2",unexploredVertex);
		MyDefaultVertex v3 = new MyDefaultVertex("Nummer3",unexploredVertex);
		MyDefaultVertex v4 = new MyDefaultVertex("Nummer4",unexploredVertex);
		MyDefaultVertex v5 = new MyDefaultVertex("Nummer5",unexploredVertex);
		MyDefaultVertex v6 = new MyDefaultVertex("Nummer6",unexploredVertex);
		MyDefaultVertex v7 = new MyDefaultVertex("Nummer7",unexploredVertex);
		
		MyDirectedEdge e1 = new MyDirectedEdge("e1",unexploredEdge,v1,v2);
		MyDirectedEdge e2 = new MyDirectedEdge("e2",unexploredEdge,v1,v3);
		MyDirectedEdge e3 = new MyDirectedEdge("e3",unexploredEdge,v2,v4);
		MyDirectedEdge e4 = new MyDirectedEdge("e4",unexploredEdge,v3,v5);
		MyDirectedEdge e5 = new MyDirectedEdge("e4",unexploredEdge,v1,v6);
		MyDirectedEdge e6 = new MyDirectedEdge("e4",unexploredEdge,v2,v7);
		MyDirectedEdge e7 = new MyDirectedEdge("e4",unexploredEdge,v6,v6);
		
		g= new GVSGraph("Adding",new GVSGraphTyp(Background.standard));
		g.setMaxLabelLength(8);
		g.add(v1);
		g.add(v2);
		g.add(e1);
		g.add(v3);
		g.add(e2);
		g.display();
		g.add(v4);
		g.add(v5);
		//g.display();
		g.add(e3);
		g.add(e4);
		g.add(v6);
		g.add(v7);
		g.display();
		//g.add(v7);
		g.add(e5);
		g.add(e6);
		g.add(e7);
		
		g.display();
		
		g.disconnect();
	}

}
