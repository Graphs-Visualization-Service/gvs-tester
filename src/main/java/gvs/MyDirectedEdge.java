package gvs;

import gvs.graph.GVSDefaultVertex;
import gvs.graph.GVSDirectedEdge;
import gvs.typ.edge.GVSEdgeTyp;

/*
 * Created on 17.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyDirectedEdge implements GVSDirectedEdge{
	private String label;
	GVSEdgeTyp typ;
	GVSDefaultVertex start;
	GVSDefaultVertex end;
		
	boolean isExplored;
	
	public MyDirectedEdge(String pLabel, GVSEdgeTyp pTyp, GVSDefaultVertex pStart, GVSDefaultVertex pEnd){
		label=pLabel;
		typ=pTyp;
		start=pStart;
		end=pEnd;
		isExplored=false;
		
	}
	
	public GVSDefaultVertex getGVSStartVertex() {
		// TODO Auto-generated method stub
		return start;
	}

	public GVSDefaultVertex getGVSEndVertex() {
		// TODO Auto-generated method stub
		return end;
	}

	public String getGVSEdgeLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	public GVSEdgeTyp getGVSEdgeTyp() {
		// TODO Auto-generated method stub
		return typ;
	}
	public boolean isExplored() {
		return isExplored;
	}

	public void setExplored(boolean isExplored) {
		this.isExplored = isExplored;
	}

	public void setTyp(GVSEdgeTyp typ) {
		this.typ = typ;
	}

	
}
