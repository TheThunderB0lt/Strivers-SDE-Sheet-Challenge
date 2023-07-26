import java.util.* ;
import java.io.*; 
/***************************************************************************

  Class for graph node is as follows:

  class graphNode {
      public int data;
      public ArrayList<graphNode> neighbours;

      graphNode() {
          data = 0;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val) {
          data = val;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val, ArrayList<graphNode> neighbours) {
          data = val;
          this.neighbours = neighbours;
      }
    }

******************************************************************************/

public class Solution {
    public static graphNode cloneGraph(graphNode node) {
        if (node == null) {
            return null;
        }

        Map<graphNode, graphNode> visited = new HashMap<>();
        return cloneGraphHelper(node, visited);
    }

    private static graphNode cloneGraphHelper(graphNode node, Map<graphNode, graphNode> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        graphNode cloneNode = new graphNode(node.data);
        visited.put(node, cloneNode);

        for (graphNode neighbor : node.neighbours) {
            cloneNode.neighbours.add(cloneGraphHelper(neighbor, visited));
        }

        return cloneNode;
    }
}