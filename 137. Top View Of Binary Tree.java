import java.util.* ;

import java.io.*; 
/************************************************************

    Following is the TreeNode class structure:

    class BinaryTreeNode {
		int val;
		BinaryTreeNode left;
		BinaryTreeNode right;

		BinaryTreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

************************************************************/

/*
    Time Complexity : O(N)
    Space Complexity : O(N)

    Where 'N' is the number of nodes in the given binary tree.
*/

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

class Pair {
    BinaryTreeNode first;
    int second;

    Pair(BinaryTreeNode first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Solution {
    private static void getBreadth(BinaryTreeNode root, int hrDistance, int []minLeft, int []maxRight) {

        // If root is null then return.
        if (root == null) {
            return;
        }

        // Recur for the left subtree.
        getBreadth(root.left, hrDistance - 1, minLeft, maxRight);

        // Recur for the right subtree.
        getBreadth(root.right, hrDistance + 1, minLeft, maxRight);

        // Update the "minLeft" and "maxRight" with the horizontal distance of the current node.
        minLeft[0] = Math.min(minLeft[0], hrDistance);
        maxRight[0] = Math.max(maxRight[0], hrDistance);
    }

    public static ArrayList<Integer> getTopView(BinaryTreeNode root) {

        // For storing top view element.
        ArrayList<Integer> topView = new ArrayList<Integer>();
        // If root is null then return topview.
        if (root == null) {
            return topView;
        }

        // To store the minimum and maximum horizontal distance.
        int []minLeft = {0};
        int []maxRight = {0};

        // Get the minimum and maximum horizontal distance.
        getBreadth(root, 0, minLeft, maxRight);

        // To store the nodes.
        ArrayList<Integer> visited = new ArrayList<Integer>(maxRight[0] - minLeft[0] + 1);

        for (int i = 0 ; i < (maxRight[0] - minLeft[0] + 1); i++) {
            visited.add(-1);
        }

        // Offset value.
        int offset = Math.abs(minLeft[0]);

        // For iterating level by level.
        Queue<Pair> level = new LinkedList<>();

        // Append root to the level with 0 horizontal distance.
        level.add(new Pair(root, 0));

        // Iterate until level does not become empty.
        while (level.size() != 0) {

            // Get total number of node at current level.
            int levelSize = level.size();

            while (levelSize != 0) {

                // Get front of the queue.
                Pair curr = level.remove();

                // Get the horizontal distance of curr node.
                int hrDistance = curr.second;

                // Get current node.
                BinaryTreeNode currNode = curr.first;

                // Check whether hDistance is visited or not. If not visited then only it will be seen by the top of the tree.
                if (visited.get(hrDistance + offset) == -1) {

                    // Make it visited.
                    visited.set(hrDistance + offset, currNode.val);
                }

                // Append left child if it exist with horizontal distance one less than currNode.
                if (currNode.left != null) {
                    level.add(new Pair(currNode.left, hrDistance - 1));
                }

                // Append right child if it exist with horizontal distance one more than currNode.
                if (currNode.right != null) {
                    level.add(new Pair(currNode.right, hrDistance + 1));
                }

                levelSize = levelSize - 1;
            }
        }

        // Now visited have the element which can be the view from the top of the tree.
        for (int x : visited) {
            if (x != -1) {
                topView.add(x);
            }
        }
        
        // Return the answer sequence of nodes.
        return topView;
    }
}