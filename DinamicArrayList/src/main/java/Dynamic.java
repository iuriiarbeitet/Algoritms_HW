public interface Dynamic {

        void add(int index, int data);
        void addAt(int data);
        void remove(int data);
        void removeAt(int index);
        void growSize();
        void shrinkSize();
        void set(int index, int data);
        int get(int index);
        void clear();
        boolean contains(int data);
        boolean isEmpty();
}
