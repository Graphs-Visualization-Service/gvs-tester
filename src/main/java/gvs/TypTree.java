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
import gvs.typ.node.GVSNodeTyp;
import gvs.typ.vertex.GVSEllipseVertexTyp.FillColor;

public class TypTree {

  public GVSNodeTyp typ1 = null;
  public GVSNodeTyp typ2 = null;
  public GVSNodeTyp typ3 = null;
  public GVSNodeTyp typ4 = null;
  public GVSNodeTyp typ5 = null;
  public GVSNodeTyp typ6 = null;
  public GVSNodeTyp typ7 = null;
  public GVSNodeTyp typ8 = null;
  public GVSNodeTyp typ9 = null;
  public GVSNodeTyp typ10 = null;
  public GVSNodeTyp typ11 = null;
  public GVSNodeTyp typ12 = null;

  public TypTree() {
    typ1 = new GVSNodeTyp(LineColor.black, LineStyle.dashed, LineThickness.bold,
        FillColor.pink);
    typ2 = new GVSNodeTyp(LineColor.blue, LineStyle.through,
        LineThickness.slight, FillColor.red);
    typ3 = new GVSNodeTyp(LineColor.brown, LineStyle.standard,
        LineThickness.standard, FillColor.standard);
    typ4 = new GVSNodeTyp(LineColor.darkBlue, LineStyle.dotted,
        LineThickness.slight, FillColor.blue);
    typ5 = new GVSNodeTyp(LineColor.darkGreen, LineStyle.dashed,
        LineThickness.slight, FillColor.turqoise);
    typ6 = new GVSNodeTyp(LineColor.gray, LineStyle.dashed, LineThickness.fat,
        FillColor.yellow);
    typ7 = new GVSNodeTyp(LineColor.green, LineStyle.through,
        LineThickness.slight, FillColor.ligthBlue);
    typ8 = new GVSNodeTyp(LineColor.ligthBlue, LineStyle.dashed,
        LineThickness.slight, FillColor.brown);
    typ9 = new GVSNodeTyp(LineColor.ligthGray, LineStyle.dotted,
        LineThickness.bold, FillColor.pink);
    typ10 = new GVSNodeTyp(LineColor.ligthGreen, LineStyle.standard,
        LineThickness.slight, FillColor.violet);
    typ11 = new GVSNodeTyp(LineColor.ligthRed, LineStyle.dashed,
        LineThickness.slight, FillColor.green);
    typ12 = new GVSNodeTyp(LineColor.orange, LineStyle.dashed,
        LineThickness.slight, FillColor.blue);
  }

}
