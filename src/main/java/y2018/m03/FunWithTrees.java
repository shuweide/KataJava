package y2018.m03;

/**
 * ### 2018/03/28
 *
 * You are given a non-null array of integers. Implement the method arrayToTree which creates a binary tree from its values in accordance to their order, while creating nodes by depth from left to right.
 *
 * For example, given the array [17, 0, -4, 3, 15] you should create the following tree:
 * ```java
 *     17
 *    /  \
 *   0   -4
 *  / \
 * 3   15
 * ```
 */
public class FunWithTrees {
    /**
     * ```java
     * public static TreeNode arrayToTree(int[] array) {
     *      TreeNode treeNode = null;
     *      if (array.length > 0) {
     *          treeNode = new TreeNode(array[0]);
     *          addRoot(treeNode, array, 0);
     *      }
     *      return treeNode;
     * }
     *
     * private static void addRoot(TreeNode treeNode, int[] array, int index) {
     *      int leftIndex = index * 2 + 1;
     *      int rightIndex = index * 2 + 2;
     *      if (leftIndex < array.length) {
     *          treeNode.left = new TreeNode(array[leftIndex]);
     *          addRoot(treeNode.left, array, leftIndex);
     *      }
     *      if (rightIndex < array.length) {
     *          treeNode.right = new TreeNode(array[rightIndex]);
     *          addRoot(treeNode.right, array, rightIndex);
     *      }
     * }
     * ```
     * @param array
     * @return
     */
    public static TreeNode arrayToTree(int[] array) {
        TreeNode treeNode = null;
        if (array.length > 0) {
            treeNode = new TreeNode(array[0]);
            addRoot(treeNode, array, 0);
        }
        return treeNode;
    }

    private static void addRoot(TreeNode treeNode, int[] array, int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        if (leftIndex < array.length) {
            treeNode.left = new TreeNode(array[leftIndex]);
            addRoot(treeNode.left, array, leftIndex);
        }
        if (rightIndex < array.length) {
            treeNode.right = new TreeNode(array[rightIndex]);
            addRoot(treeNode.right, array, rightIndex);
        }
    }

    /**
     * ```java
     * static TreeNode arrayToTreeBest(int[] array) {
     *      return arrayToTree(array, 0);
     * }
     * private static TreeNode arrayToTree(int[] array, int index) {
     *      return index < array.length ?
     *          new TreeNode(array[index], arrayToTree(array, index * 2 + 1), arrayToTree(array, index * 2 + 2)) :
     *          null;
     * }
     * ```
     * @param array
     * @return
     */
    public static TreeNode arrayToTreeBest(int[] array) {
        return arrayToTree(array, 0);
    }

    private static TreeNode arrayToTree(int[] array, int index) {
        return index < array.length ?
                new TreeNode(array[index], arrayToTree(array, index * 2 + 1), arrayToTree(array, index * 2 + 2)) :
                null;
    }
}

class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode(int value) {
        this(value, null, null);
    }

    @Override
    public boolean equals(Object other) {
        TreeNode root2 = (TreeNode) other;
        // Shortcut for reference equality; also handles equals(null, null)
        if (this == root2) {
            return true;
        }
        if (root2 == null) {
            return false;
        }
        return this.value == root2.value &&
                this.left != null ? this.left.equals(root2.left) : true &&
                this.right != null ? this.right.equals(root2.right) : true;
    }
}


