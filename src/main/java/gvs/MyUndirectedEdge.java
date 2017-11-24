package gvs;

import gvs.graph.GVSDefaultVertex;
import gvs.graph.GVSUndirectedEdge;
import gvs.typ.edge.GVSEdgeTyp;

/*
 * Created on 25.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyUndirectedEdge implements GVSUndirectedEdge{
	private String label;
	private GVSEdgeTyp typ;
	private GVSDefaultVertex[] vertizes;
	private int arrowPos=0;
	
	public MyUndirectedEdge(String pLabel, GVSEdgeTyp pTyp, GVSDefaultVertex pVertizes[]){
		this.label=pLabel;
		this.typ=pTyp;
		this.vertizes=pVertizes;
	}
	
	public MyUndirectedEdge(String pLabel, GVSEdgeTyp pTyp, 
			GVSDefaultVertex pVertizes[],int pArrowPos){
		this.label=pLabel;
		this.typ=pTyp;
		this.vertizes=pVertizes;
		this.arrowPos=pArrowPos;
	}
	
	public GVSDefaultVertex[] getGVSVertizes() {
		// TODO Auto-generated method stub
		return vertizes;
	}

	public String getGVSEdgeLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	public GVSEdgeTyp getGVSEdgeTyp() {
		// TODO Auto-generated method stub
		return typ;
	}


	public void setLabel(String label) {
		this.label = label;
	}


	public void setTyp(GVSEdgeTyp typ) {
		this.typ = typ;
	}


	public void setVertizes(GVSDefaultVertex[] vertizes) {
		this.vertizes = vertizes;
	}


	public int hasArrow() {
		
		return arrowPos;
	}
	
	public void setArrow(int pPosition){
		this.arrowPos=pPosition;
	}

}
