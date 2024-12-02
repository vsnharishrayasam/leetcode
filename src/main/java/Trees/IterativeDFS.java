package Trees;


import java.util.Stack;

public class IterativeDFS {
    static BinaryTreeNode kthSmallest(BinaryTreeNode root, int k) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        BinaryTreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            //preOrder code
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            //Inorder code
            curr = stack.pop(); //smallest
            k--;
            if (k == 0) {
                return curr;
            }
            curr = curr.right;
            //postOrder code
        }
        return null;
    }
}
