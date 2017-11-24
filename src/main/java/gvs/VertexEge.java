package gvs;

import gvs.graph.GVSDefaultVertex;
import gvs.graph.GVSRelativeVertex;
import gvs.graph.GVSUndirectedEdge;
import gvs.styles.GVSStyle;

public class VertexEge {

  public static void main(String[] args) {

  }
}

class Vertex implements GVSDefaultVertex {

  Object mObj;

  Vertex(Object pObj) {
    setObject(pObj);
  }

  void setObject(Object pObj) {
    mObj = pObj;
  }

  public String getGVSVertexLabel() {
    return mObj.toString();
  }

  @Override
  public GVSStyle getStyle() {
    return null;
  }
}

class VertexPos extends Vertex implements GVSRelativeVertex {
  double mXPos;
  double mYPos;

  VertexPos(Object pObj) {
    super(pObj);
  }

  VertexPos(Object pObj, double pXPos, double pYPos) {
    super(pObj);
    setPos(pXPos, pYPos);
  }

  VertexPos setPos(double pXPos, double pYPos) {
    mXPos = pXPos;
    mYPos = pYPos;
    return this;
  }

  public double getX() {
    return mXPos;
  }

  public double getY() {
    return mYPos;
  }
}

class Edge implements GVSUndirectedEdge {
  Vertex[] mVertizes = new Vertex[2];
  Object mObj;
  int mArrowPos;

  Edge(Object pObj) {
    setObject(pObj);
  }

  Edge(Vertex v1, Vertex v2, Object pObj) {
    Vertex[] vertizes = new Vertex[2];
    vertizes[0] = v1;
    vertizes[1] = v2;
    set(vertizes, pObj);
  }

  Edge(Vertex[] pVertizes, Object pObj) {
    set(pVertizes, pObj);
  }

  void set(Vertex[] pVertizes, Object pObj) {
    mVertizes = pVertizes;
    mObj = pObj;
  }

  void setVertizes(Vertex[] pVertizes) {
    mVertizes = pVertizes;
  }

  void setVertizes(Vertex v1, Vertex v2) {
    mVertizes[0] = v1;
    mVertizes[1] = v2;
  }

  Edge setVertizes(Vertex v1, Vertex v2, int pArrowPos) {
    mVertizes[0] = v1;
    mVertizes[1] = v2;
    mArrowPos = pArrowPos;
    return this;
  }

  void setObject(Object pObj) {
    mObj = pObj;
  }

  Vertex[] getVertizes() {
    return mVertizes;
  }

  public GVSDefaultVertex[] getGVSVertizes() {
    return getVertizes();
  }

  public int hasArrow() {
    return mArrowPos;
  }

  public String getGVSEdgeLabel() {
    return mObj.toString();
  }

  public GVSStyle getStyle() {
    return null;
  }
}
