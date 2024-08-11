package org.carlosarriaga.leetcode.bfs;

import java.util.*;


public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }

        Map<TreeNode, Integer> map = new LinkedHashMap<>();
        map.put(root, 0);

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            int currentValue = map.get(current);

            if (currentValue < minIndex) {
                minIndex = currentValue;
            }

            if (currentValue > maxIndex) {
                maxIndex = currentValue;
            }

            if (current.left != null) {
                map.put(current.left, currentValue - 1);
                queue.add(current.left);
            }

            if (current.right != null) {
                map.put(current.right, currentValue + 1);
                queue.add(current.right);
            }

        }

        int range = maxIndex - minIndex + 1;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            result.add(new ArrayList<>());
        }

        for (Map.Entry<TreeNode, Integer> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                result.get(entry.getValue() - minIndex).add(entry.getKey().val);
            }
        }

        return result;
    }
}
