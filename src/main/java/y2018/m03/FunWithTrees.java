package y2018.m03;

public class FunWithTrees {
    static TreeNode arrayToTree(int[] array) {
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


