package gvs;

import gvs.tree.GVSDefaultTreeNode;
import gvs.typ.node.GVSNodeTyp;

/*
 * Created on 25.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyDefaultNode implements GVSDefaultTreeNode{
	private String label; 
	private GVSNodeTyp typ; 
	private GVSDefaultTreeNode childs[];
	
	public MyDefaultNode(String pLabel, GVSNodeTyp pTyp, GVSDefaultTreeNode pChilds[]){
		this.label=pLabel;
		this.typ=pTyp;
		this.childs=pChilds;
	}
	
	public MyDefaultNode(String pLabel, GVSNodeTyp pTyp){
		this(pLabel,pTyp,null);
	}
	public GVSDefaultTreeNode[] getGVSChildNodes() {
		
		return childs;
	}

	public String getNodeLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	public GVSNodeTyp getNodeTyp() {
		// TODO Auto-generated method stub
		return typ;
	}


	public void setChilds(GVSDefaultTreeNode[] childs) {
		this.childs = childs;
	}

	public void setLabel(String label) {
		this.label = label;
	}


	public void setTyp(GVSNodeTyp typ) {
		this.typ = typ;
	}
	
}
