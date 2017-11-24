package gvs;

import gvs.graph.GVSRelativeVertex;
import gvs.typ.vertex.GVSVertexTyp;

/*
 * Created on 25.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyRelativVertex implements GVSRelativeVertex{

	private double xPos;
	private double yPos;
	private String label;
	private GVSVertexTyp typ;
	
	public MyRelativVertex(String pLabel, GVSVertexTyp pTyp, double pXpos,double pYpos){
		this.label =pLabel;
		this.typ =pTyp;
		this.xPos=pXpos;
		this.yPos=pYpos	;
	}
	
	public double getX() {
		// TODO Auto-generated method stub
		return xPos;
	}

	public double getY() {
		// TODO Auto-generated method stub
		return yPos;
	}

	public String getGVSVertexLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	public GVSVertexTyp getGVSVertexTyp() {
		// TODO Auto-generated method stub
		return typ;
	}

	public void setTyp(GVSVertexTyp typ) {
		this.typ = typ;
	}
	
	
}
