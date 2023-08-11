package org.example.datastructure.leetcode102;

import org.example.datastructure.LinkedListQueue;
import org.example.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;//空树
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1;//当前层的节点数
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int c2 = 0;//下一层的节点数
            for (int i = 0; i < c1; i++) {//遍历当前层的节点
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    c2++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
        }
        return result;
    }


    /**
     * 测试       1 (root)
     * / \
     * 2   3
     * / \  / \
     * 4  5  6  7
     * <p>
     * 二叉树层序遍历
     * 目标：1,2,3,4,5,6,7
     * <p>
     * 一层一层的把当前层的节点加入到队列
     */
    public static void main(String[] args) {
        //  构建二叉树
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7))
        );
        List<List<Integer>> lists = new LeetCode102().levelOrder(root);
        System.out.println(lists);


//        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
//        queue.offer(root);
//        int c1 = 1;//当前层的节点数
//        while (!queue.isEmpty()) {
//            int c2 = 0;//下一层的节点数
//            for (int i = 0; i < c1; i++) {//遍历当前层的节点
//                TreeNode node = queue.poll();
//                System.out.print(node.val + " ");
//                if (node.left != null) {
//                    queue.offer(node.left);
//                    c2++;
//                }
//                if (node.right != null) {
//                    queue.offer(node.right);
//                    c2++;
//                }
//            }
//            System.out.println();
//            c1 = c2;
//        }
    }

}
