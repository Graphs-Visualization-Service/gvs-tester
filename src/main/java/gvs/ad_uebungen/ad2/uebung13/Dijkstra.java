/*
 * HSR - Uebungen 'Algorithmen & Datenstrukturen 2'
 * Version: Sat Dec 10 19:28:20 CET 2016
 */

package gvs.ad_uebungen.ad2.uebung13;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import ch.hsr.prog2.dijkstragvs.AdjacencyListGraphGVS;
import ch.hsr.prog2.dijkstragvs.GvsSupport;
import ch.hsr.prog2.dijkstragvs.HeapAdaptablePriorityQueueGVS;
import ch.hsr.prog2.dijkstragvs.LinkedHashMapGVS;
import ch.hsr.prog2.dijkstragvs.Prog2Formatter;
import net.datastructures.AdaptablePriorityQueue;
import net.datastructures.AdjacencyListGraph;
import net.datastructures.Edge;
import net.datastructures.Entry;
import net.datastructures.Vertex;

@SuppressWarnings({"unchecked","rawtypes"})

public class Dijkstra<V, E> {
  
  /** Delay-Time in ms between Single-Steps in GVS-Server */
  static final int DELAY = 300; 
  
  AdjacencyListGraph<V, E> graph;

  static GvsSupport gvs;
  static final String WEIGHT = "WEIGHT";
  

  public static void main(String[] args) {
    Dijkstra<String, Integer> dijkstra = new Dijkstra<String, Integer>();
    Vertex<String> startVertex = dijkstra.initGraph();
    AdjacencyListGraph<String, Integer> graph = dijkstra.getGraph();
    dijkstra.distances(graph, startVertex);
    dijkstra.stop();
  }
  
  Dijkstra() {
    gvs = new GvsSupport<V, E>();
    String[] errText = { "Connection to GVS-Server failed!\n",
        "Start \"GVS_Server_v1.5.jar\" first.",
        "(located on Skripte-Server in \"7_Zusatzmaterial\")" };
    graph = new AdjacencyListGraphGVS<V, E>(gvs, errText);
  }
  
  
  protected Vertex<V> initGraph() {

    AdjacencyListGraphGVS<String, Integer> graphGVS = 
      (AdjacencyListGraphGVS<String, Integer>) graph;

    // Example from lecture-slides: 
    
    // Vertices:
    Vertex<String> vA = graphGVS.insertVertex("A", 50, 10);
    Vertex<String> vB = graphGVS.insertVertex("B", 10, 50);
    Vertex<String> vC = graphGVS.insertVertex("C", 50, 50);
    Vertex<String> vD = graphGVS.insertVertex("D", 90, 50);
    Vertex<String> vE = graphGVS.insertVertex("E", 30, 90);
    Vertex<String> vF = graphGVS.insertVertex("F", 70, 90);

    // Edges:
    graphGVS.insertEdge(vA, vD, 4);
    graphGVS.insertEdge(vA, vC, 2);
    graphGVS.insertEdge(vA, vB, 8);
    graphGVS.insertEdge(vC, vB, 7);
    graphGVS.insertEdge(vC, vD, 1);
    graphGVS.insertEdge(vC, vE, 3);
    graphGVS.insertEdge(vC, vF, 9);
    graphGVS.insertEdge(vE, vB, 2);
    graphGVS.insertEdge(vD, vF, 5);

    Vertex<String> startVertex = vA;

    graphGVS.display();
    return (Vertex<V>) startVertex;
  }

  public void distances(AdjacencyListGraph<V, E> graph, Vertex<V> s) {
    
    AdaptablePriorityQueue<Integer, Vertex<V>> apq = 
      new HeapAdaptablePriorityQueueGVS<Integer, Vertex<V>>();
    Map<Vertex<V>, Integer> distances = 
      new LinkedHashMapGVS<Vertex<V>, Integer>();
    Map<Vertex<V>, Entry<Integer, Vertex<V>>> locators = 
      new LinkedHashMap<Vertex<V>, Entry<Integer, Vertex<V>>>();
    Map<Vertex<V>, Edge<E>> parents = 
      new LinkedHashMapGVS<Vertex<V>, Edge<E>>();
    gvs.set(apq, distances, parents);
    
    for (Vertex<V> v : graph.vertices()) {
      if (v == s) {
        distances.put(v, 0);
        parents.put(v, null);
      } else {
        distances.put(v, Integer.MAX_VALUE);
      }
      Entry<Integer, Vertex<V>> l = apq.insert(distances.get(v), v);
      locators.put(v, l);
    }
    while (!apq.isEmpty()) {
      AdjacencyListGraph<V, E>.MyVertex<V> u = 
        (AdjacencyListGraph<V, E>.MyVertex<V>) (apq.removeMin().getValue());
      for (Edge<E> e : u.incidentEdges()) {
        Vertex<V> z = graph.opposite(u, e);
        int r = distances.get(u) + (Integer)(e.get(WEIGHT));
        if (r < distances.get(z)) {
          distances.put(z, r);
          parents.put(z, e);
          apq.replaceKey(locators.get(z), r);
        }
      }
    }
  }
  
  protected AdjacencyListGraph<V, E> getGraph() {
    return graph;
  }

  static {
    Logger rootLogger = Logger.getLogger("");
    Formatter formatter = new Prog2Formatter();
    Handler consoleHandler = rootLogger.getHandlers()[0];
    consoleHandler.setFormatter(formatter);
    consoleHandler.setLevel(Level.ALL);
    String delay =  System.getProperty("Prog2GvsDelay");
    if (delay != null) {
      GvsSupport.DELAY = Integer.valueOf(delay);
    } else {
      GvsSupport.DELAY = DELAY;
    }
    String logLevel =  System.getProperty("Prog2LogLevel");
    if (logLevel != null) {
      rootLogger.setLevel(Level.parse(logLevel));
    }
  }

  protected void stop() {
    ((AdjacencyListGraphGVS<String, String>)graph).disconnectServer();
  }

}

/* Session-Log:

LinkedHashMapGVS.put(): A -> 0
LinkedHashMapGVS.put(): A:0  -> null
LinkedHashMapGVS.put(): B -> 2147483647
LinkedHashMapGVS.put(): C -> 2147483647
LinkedHashMapGVS.put(): D -> 2147483647
LinkedHashMapGVS.put(): E -> 2147483647
LinkedHashMapGVS.put(): F -> 2147483647
GvsSupport.newVertexInCloud(): A:0 
GvsSupport.setTesting(): 8(B:# ,A:0 )
LinkedHashMapGVS.put(): B:#  -> 8
LinkedHashMapGVS.put(): B:8  -> 8(B:8 ,A:0 )
GvsSupport.newParentEdge(): 8(B:8 ,A:0 )
GvsSupport.setTesting(): 2(C:# ,A:0 )
LinkedHashMapGVS.put(): C:#  -> 2
LinkedHashMapGVS.put(): C:2  -> 2(C:2 ,A:0 )
GvsSupport.newParentEdge(): 2(C:2 ,A:0 )
GvsSupport.setTesting(): 4(D:# ,A:0 )
LinkedHashMapGVS.put(): D:#  -> 4
LinkedHashMapGVS.put(): D:4  -> 4(D:4 ,A:0 )
GvsSupport.newParentEdge(): 4(D:4 ,A:0 )
GvsSupport.newVertexInCloud(): C:2 
GvsSupport.setTesting(): 2(C:2 ,A:0 )
GvsSupport.setTesting(): 7(B:8 ,C:2 )
GvsSupport.setTesting(): 1(D:4 ,C:2 )
LinkedHashMapGVS.put(): D:4  -> 3
LinkedHashMapGVS.put(): D:3  -> 1(D:3 ,C:2 )
GvsSupport.newParentEdge(): 1(D:3 ,C:2 )
GvsSupport.setTesting(): 3(E:# ,C:2 )
LinkedHashMapGVS.put(): E:#  -> 5
LinkedHashMapGVS.put(): E:5  -> 3(E:5 ,C:2 )
GvsSupport.newParentEdge(): 3(E:5 ,C:2 )
GvsSupport.setTesting(): 9(F:# ,C:2 )
LinkedHashMapGVS.put(): F:#  -> 11
LinkedHashMapGVS.put(): F:11 -> 9(F:11,C:2 )
GvsSupport.newParentEdge(): 9(F:11,C:2 )
GvsSupport.newVertexInCloud(): D:3 
GvsSupport.setTesting(): 4(D:3 ,A:0 )
GvsSupport.setTesting(): 1(D:3 ,C:2 )
GvsSupport.setTesting(): 5(F:11,D:3 )
LinkedHashMapGVS.put(): F:11 -> 8
LinkedHashMapGVS.put(): F:8  -> 5(F:8 ,D:3 )
GvsSupport.newParentEdge(): 5(F:8 ,D:3 )
GvsSupport.newVertexInCloud(): E:5 
GvsSupport.setTesting(): 2(B:8 ,E:5 )
LinkedHashMapGVS.put(): B:8  -> 7
LinkedHashMapGVS.put(): B:7  -> 2(B:7 ,E:5 )
GvsSupport.newParentEdge(): 2(B:7 ,E:5 )
GvsSupport.setTesting(): 3(E:5 ,C:2 )
GvsSupport.newVertexInCloud(): B:7 
GvsSupport.setTesting(): 8(B:7 ,A:0 )
GvsSupport.setTesting(): 7(B:7 ,C:2 )
GvsSupport.setTesting(): 2(B:7 ,E:5 )
GvsSupport.newVertexInCloud(): F:8 
GvsSupport.setTesting(): 9(F:8 ,C:2 )
GvsSupport.setTesting(): 5(F:8 ,D:3 )

*/


