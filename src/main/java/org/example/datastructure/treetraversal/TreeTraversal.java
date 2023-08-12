package org.example.datastructure.treetraversal;

/**
 * 递归方式遍历二叉树，前序、中序、后序
 */
public class TreeTraversal {
    public static void main(String[] args) {
        /**
         *         1
         *       /  \
         *      2    3
         *    /     /\
         *   4      5  6
         *
         */

        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(4), 2, null), 1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6)
                )
        );

        System.out.println("前序遍历：");
        preOrder(root);
        System.out.println("\n中序遍历：");
        inOrder(root);
        System.out.println("\n后序遍历：");
        postOrder(root);
    }

    /**
     * 前序遍历
     */
    public static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + "\t");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "\t");
    }

}
