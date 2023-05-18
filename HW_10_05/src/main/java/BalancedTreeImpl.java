import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BalancedTreeImpl implements BalancedTree {
    TreeNode root; // - корневой элемент
    int size; // - количество нод

    public BalancedTreeImpl() {
    }

    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.value) {
            current.leftNode = addRecursive(current.leftNode, value);
        } else if (value > current.value) {
            current.rightNode = addRecursive(current.rightNode, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    @Override
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private BalancedTreeImpl createBinaryTree() {
        BalancedTreeImpl bt = new BalancedTreeImpl();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        return bt;
    }

    private boolean containsNodeRecursive(TreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.leftNode, value)
                : containsNodeRecursive(current.rightNode, value);
    }

    @Override
    public boolean search(int value) {
        return containsNodeRecursive(root, value);
    }

    @Test
    public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
        BalancedTreeImpl bt = createBinaryTree();

        assertTrue(bt.search(6));
        assertTrue(bt.search(4));

        assertFalse(bt.search(1));
    }

    private TreeNode deleteRecursive(TreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            if (current.leftNode == null && current.rightNode == null) {
                return null;
            }
            if (current.rightNode == null) {
                return current.leftNode;
            }

            if (current.leftNode == null) {
                return current.rightNode;
            }

        }
        if (value < current.value) {
            current.leftNode = deleteRecursive(current.leftNode, value);
            return current;
        }
        if (value < current.value) {
            current.rightNode = deleteRecursive(current.rightNode, value);
            return current;
        }

        int smallestValue = findSmallestValue(current.rightNode);
        current.value = smallestValue;
        current.rightNode = deleteRecursive(current.rightNode, smallestValue);
        return current;
    }

    private int findSmallestValue(TreeNode root) {
        return root.leftNode == null ? root.value : findSmallestValue(root.leftNode);

    }

    @Override
    public void remove(int value) {
        root = deleteRecursive(root, value);
    }

    @Test
    public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
        BalancedTreeImpl bt = createBinaryTree();

        assertTrue(bt.search(9));
        bt.remove(9);
        assertFalse(bt.search(9));
    }

    @Override
    public int getDepth(TreeNode node) {
        int count = 0;
        if (node != null) {
            traversalDepth(node.leftNode);
            System.out.print(" " + node.value);
            traversalDepth(node.rightNode);
        }
        count++;
        return count;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void traversalWidth() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            System.out.print(" " + node.value);
            if (node.leftNode != null) {
                nodes.add(node.leftNode);
            }
            if (node.rightNode != null) {
                nodes.add(node.rightNode);
            }
        }
    }

    @Override
    public void traversalDepth(TreeNode node) {
        if (node != null) {
            traversalDepth(node.leftNode);
            System.out.print(" " + node.value);
            traversalDepth(node.rightNode);
        }
    }
}
