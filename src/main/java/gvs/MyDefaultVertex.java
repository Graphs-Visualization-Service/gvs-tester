package gvs;

import gvs.graph.GVSDefaultVertex;
import gvs.typ.vertex.GVSVertexTyp;



public class MyDefaultVertex implements GVSDefaultVertex{
	String label; 
	GVSVertexTyp typ;
	boolean isExplored;
	
	
	public MyDefaultVertex(String pLabel, GVSVertexTyp pTyp){
		label=pLabel;
		typ=pTyp;
		isExplored=false;
	}
	
	public String getGVSVertexLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	public GVSVertexTyp getGVSVertexTyp() {
		// TODO Auto-generated method stub
		return typ;
	}

	public void setLabel(String pLabel){
		this.label=pLabel;
	}

	
	public void setTyp(GVSVertexTyp typ) {
		this.typ = typ;
	}

	public boolean isExplored() {
		return isExplored;
	}

	public void setExplored(boolean isExplored) {
		this.isExplored = isExplored;
	}

	
}
