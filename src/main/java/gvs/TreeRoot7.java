package gvs;


import gvs.tree.GVSTreeWithRoot;


public class TreeRoot7 {

  public static void main(String[] args) {
 
//        1
//    2       3
//  4   5   6   7

    TreeNode[] nodes = new TreeNode[8];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = new TreeNode(new Integer(i), null, null);
    }
    
     
    GVSTreeWithRoot tr = new GVSTreeWithRoot("GVSTreeWithRoot: Test 1");
    tr.display();
    
    tr.setRoot(nodes[1]);
    tr.display();
   
    nodes[1].setLeft(nodes[2]);
    tr.display();
    
    nodes[2].setLeft(nodes[4]);
    tr.display();

    nodes[1].setRigth(nodes[3]);
    tr.display();

    nodes[3].setRigth(nodes[7]);
    tr.display();

    nodes[2].setRigth(nodes[5]);
    tr.display();

    nodes[3].setLeft(nodes[6]);
    tr.display();
    
//    nodes[1].setRigth(null);
//    tr.display();
    

    tr.disconnect();
    
    

  }

}
