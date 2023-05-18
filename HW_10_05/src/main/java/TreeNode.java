
class TreeNode {
   int value; // ключ узла
     TreeNode leftNode; // Левый узел потомок
     TreeNode rightNode; // Правый узел потомок

    public TreeNode(int value) {
        this.value = value;
        rightNode = null;
        leftNode = null;
    }


    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftNode +
                ", rightChild=" + rightNode +
                '}';
    }
}

