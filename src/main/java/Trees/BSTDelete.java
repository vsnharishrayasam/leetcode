package Trees;

public class BSTDelete {


    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(10);
        root.right.right = new BinaryTreeNode(14);

        System.out.println(LevelOrderTraversal.levelOrderTraversal(root));
    }

    static BinaryTreeNode predecessor(BinaryTreeNode root, BinaryTreeNode target) {
        return null;
    }




}
