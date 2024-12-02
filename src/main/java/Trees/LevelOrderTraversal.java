package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static ArrayList<ArrayList<Integer>> levelOrderTraversal(BinaryTreeNode root) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        ArrayList<Integer> levelOutput = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.remove();
            if (current != null) {
                levelOutput.add(current.value);
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            } else {
                if (queue.peek() != null) {
                    queue.add(null);
                }
                output.add(levelOutput);
                levelOutput = new ArrayList<>();
            }

        }

        return output;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        System.out.println(preorder(root));
    }

    static ArrayList<Integer> preorder(BinaryTreeNode root) {
        // Write your code here.
        ArrayList<Integer> values = new ArrayList<Integer>();
        if (root == null) {
            return null;
        }

        preOrderHelper(root, values);
        return values;
    }

    static void preOrderHelper(BinaryTreeNode root, ArrayList<Integer> values) {
        //DLR
        if (root == null) {
            return;
        }

        values.add(root.value);
        preOrderHelper(root.left, values);
        preOrderHelper(root.right, values);
    }

    static void postOrderHelper(BinaryTreeNode root, ArrayList<Integer> values) {
        //DLR
        if (root == null) {
            return;
        }

        postOrderHelper(root.left, values);
        postOrderHelper(root.right, values);
        values.add(root.value);
    }
}
