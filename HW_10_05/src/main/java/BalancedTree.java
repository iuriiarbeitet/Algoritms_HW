/**
 * interface BalancedTree
 * -add(int data) void - добавить элемент в дерево
 * -search(int data) boolean - true/false если указанный элемент есть или его нет
 * -remove(int data) void - удаляет элемент из дерева
 * -getDepth() int - возвращает самый длинный путь от корня до самого дальнего листа (количество нод)
 * -getSize() int - возвращает количество нод
 * -traversalWidth() void - обход дерева в ширину, печатает в консоль
 * -traversalDepth() void - обход дерева в глубину, печатает в консоль
 */
public interface BalancedTree {
    void add(int data);
    boolean search(int data);
    void remove(int data);
    int getDepth(TreeNode node);
    int getSize();
    void traversalWidth();
    void traversalDepth(TreeNode node);
}
