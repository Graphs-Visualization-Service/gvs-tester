package gvs;
/*
 * Created on 10.12.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */


import gvs.typ.GVSDefaultTyp.LineColor;
import gvs.typ.GVSDefaultTyp.LineStyle;
import gvs.typ.GVSDefaultTyp.LineThickness;
import gvs.typ.edge.GVSEdgeTyp;
import gvs.typ.vertex.GVSEllipseVertexTyp;
import gvs.typ.vertex.GVSIconVertexTyp;
import gvs.typ.vertex.GVSEllipseVertexTyp.FillColor;
import gvs.typ.vertex.GVSIconVertexTyp.Icon;

public class TypsGraph {

	public GVSEllipseVertexTyp typ1=null;
	public GVSEllipseVertexTyp typ2=null;
	public GVSEllipseVertexTyp typ3=null;
	public GVSEllipseVertexTyp typ4=null;
	public GVSEllipseVertexTyp typ5=null;
	public GVSEllipseVertexTyp typ6=null;
	public GVSEllipseVertexTyp typ7=null;
	public GVSEllipseVertexTyp typ8=null;
	public GVSEllipseVertexTyp typ9=null;
	public GVSEllipseVertexTyp typ10=null;
	public GVSEllipseVertexTyp typ11=null;
	public GVSEllipseVertexTyp typ12=null;
	
	public GVSIconVertexTyp typi1=null;
	public GVSIconVertexTyp typi2=null;
	public GVSIconVertexTyp typi3=null;
	public GVSIconVertexTyp typi4=null;
	public GVSIconVertexTyp typi5=null;
	public GVSIconVertexTyp typi6=null;
	public GVSIconVertexTyp typi7=null;
	public GVSIconVertexTyp typi8=null;
	public GVSIconVertexTyp typi9=null;
	public GVSIconVertexTyp typi10=null;
	
	
	public GVSEdgeTyp t1=null;
	public GVSEdgeTyp t2=null;
	public GVSEdgeTyp t3=null;
	public GVSEdgeTyp t4=null;
	public GVSEdgeTyp t5=null;
	public GVSEdgeTyp t6=null;


	
	
	public TypsGraph(){
		typ1=new GVSEllipseVertexTyp(LineColor.black,LineStyle.dashed,
								LineThickness.bold,FillColor.pink);
		typ2=new GVSEllipseVertexTyp(LineColor.blue,LineStyle.through,
								LineThickness.slight,FillColor.red);
		typ3=new GVSEllipseVertexTyp(LineColor.brown,LineStyle.standard,
								LineThickness.standard,FillColor.standard);
		typ4=new GVSEllipseVertexTyp(LineColor.darkBlue,LineStyle.dotted,
								LineThickness.slight,FillColor.blue);
		typ5=new GVSEllipseVertexTyp(LineColor.darkGreen,LineStyle.through,
								LineThickness.fat,FillColor.orange);
		typ6=new GVSEllipseVertexTyp(LineColor.gray,LineStyle.dashed,
								LineThickness.fat,FillColor.yellow);
		typ7=new GVSEllipseVertexTyp(LineColor.green,LineStyle.through,
								LineThickness.slight,FillColor.ligthBlue);
		typ8=new GVSEllipseVertexTyp(LineColor.ligthBlue,LineStyle.dashed,
								LineThickness.slight,FillColor.brown);
		typ9=new GVSEllipseVertexTyp(LineColor.ligthGray,LineStyle.dotted,
								LineThickness.bold,FillColor.pink);
		typ10=new GVSEllipseVertexTyp(LineColor.ligthGreen,LineStyle.standard,
								LineThickness.slight,FillColor.violet);
		typ11=new GVSEllipseVertexTyp(LineColor.ligthRed,LineStyle.dashed,
								LineThickness.slight,FillColor.green);
		typ12=new GVSEllipseVertexTyp(LineColor.orange,LineStyle.dashed,
								LineThickness.slight,FillColor.blue);
		
		
		t1= new GVSEdgeTyp(LineColor.blue,LineStyle.through,
				LineThickness.slight);
		t2=new GVSEdgeTyp(LineColor.red,LineStyle.dotted,
				LineThickness.standard);
		 t3=new GVSEdgeTyp(LineColor.brown,LineStyle.dashed,
					LineThickness.fat);
		t4=new GVSEdgeTyp(LineColor.black,LineStyle.through,
				LineThickness.bold);
		t5=new GVSEdgeTyp(LineColor.brown,LineStyle.dotted,
				LineThickness.standard);
		t6=new GVSEdgeTyp(LineColor.orange,LineStyle.dashed,
				LineThickness.slight);
		
		
		typi1=new GVSIconVertexTyp(LineColor.black,LineStyle.dashed,
						LineThickness.fat,Icon.COG);
		typi2=new GVSIconVertexTyp(LineColor.blue,LineStyle.through,
						LineThickness.slight,Icon.PLAY);
		typi3=new GVSIconVertexTyp(LineColor.brown,LineStyle.standard,
						LineThickness.standard,Icon.GLOBE);
		typi4=new GVSIconVertexTyp(LineColor.darkBlue,LineStyle.dotted,
						LineThickness.slight,Icon.COG);
		typi5=new GVSIconVertexTyp(LineColor.darkGreen,LineStyle.dashed,
						LineThickness.slight,Icon.PLAY);
		typi6=new GVSIconVertexTyp(LineColor.gray,LineStyle.dashed,
						LineThickness.fat,Icon.GLOBE);
		typi7=new GVSIconVertexTyp(LineColor.green,LineStyle.through,
						LineThickness.slight,Icon.COG);
		typi8=new GVSIconVertexTyp(LineColor.ligthBlue,LineStyle.dashed,
						LineThickness.slight,Icon.PLAY);
		typi9=new GVSIconVertexTyp(LineColor.ligthGray,LineStyle.dotted,
						LineThickness.bold,Icon.GLOBE);
		typi10=new GVSIconVertexTyp(LineColor.ligthGreen,LineStyle.standard,
						LineThickness.slight,Icon.COG);
	
		
	}
	
}