package gvs;

import gvs.styles.GVSStyle;
import gvs.tree.GVSDefaultTreeNode;

/*
 * Created on 25.11.2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

public class MyDefaultNode implements GVSDefaultTreeNode {
  private String label;
  private GVSStyle style;
  private GVSDefaultTreeNode childs[];

  public MyDefaultNode(String pLabel, GVSStyle style,
      GVSDefaultTreeNode pChilds[]) {
    this.label = pLabel;
    this.style = style;
    this.childs = pChilds;
  }

  public MyDefaultNode(String pLabel, GVSStyle style) {
    this(pLabel, style, null);
  }

  public GVSDefaultTreeNode[] getGVSChildNodes() {

    return childs;
  }

  public String getNodeLabel() {
    return label;
  }

  public GVSStyle getStyle() {
    return style;
  }
  
  public void setStyle(GVSStyle style) {
    this.style = style;
  }

  public void setChilds(GVSDefaultTreeNode[] childs) {
    this.childs = childs;
  }

  public void setLabel(String label) {
    this.label = label;
  }

}
