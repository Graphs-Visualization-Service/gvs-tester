/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Mon Dec  5 22:00:14 CET 2016
 */

package gvs.ad_uebungen.ad2.uebung12;

public class TestDirectedDFS {

  public static void main(String[] args) {

    Vertex vertexA = new Vertex("A", null, 35, 10);
    Vertex vertexB = new Vertex("B", null, 50, 55);
    Vertex vertexC = new Vertex("C", null, 80, 90);
    Vertex vertexD = new Vertex("D", null, 40, 90);
    Vertex vertexE = new Vertex("E", null, 20, 55);
    
    Edge edgeAB = new Edge(null, null, vertexA, vertexB);
    Edge edgeAE = new Edge(null, null, vertexA, vertexE);
    Edge edgeAD = new Edge(null, null, vertexA, vertexD);
    Edge edgeBC = new Edge(null, null, vertexB, vertexC);
    Edge edgeBD = new Edge(null, null, vertexB, vertexD);
    Edge edgeCA = new Edge(null, null, vertexC, vertexA);
    Edge edgeDC = new Edge(null, null, vertexD, vertexC);
    Edge edgeED = new Edge(null, null, vertexE, vertexD);

    Graph graph = new Graph("Example Slide 5");
    graph.insertVertex(vertexA);
    graph.insertVertex(vertexB);
    graph.insertVertex(vertexC);
    graph.insertVertex(vertexD);
    graph.insertVertex(vertexE);
    graph.insertEdge(edgeAB);
    graph.insertEdge(edgeAD);
    graph.insertEdge(edgeAE);
    graph.insertEdge(edgeBC);
    graph.insertEdge(edgeBD);
    graph.insertEdge(edgeCA);
    graph.insertEdge(edgeDC);
    graph.insertEdge(edgeED);
    graph.displayOnGVS();

    graph.directedDFS();

    graph.disconnectFromGVS();
  }

}

/* Session-Log:
 
depthFirstSearch() : A
Testing            : A->B: DISCOVERY
depthFirstSearch() : B
Testing            : B->C: DISCOVERY
depthFirstSearch() : C
Testing            : C->A: BACK
Testing            : B->D: DISCOVERY
depthFirstSearch() : D
Testing            : D->C: CROSS
Testing            : A->D: FORWARD
Testing            : A->E: DISCOVERY
depthFirstSearch() : E
Testing            : E->D: CROSS

*/

