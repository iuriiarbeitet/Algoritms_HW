import java.util.Arrays;

public class DynamicArray implements Dynamic {
    private int[] array;
    public int count;
    public int size;

    public DynamicArray() {
        this.array = new int[10];
        this.count = 0;
        this.size = 10;
    }

    public DynamicArray(int size) {
        this.array = new int[size];
        this.count = 0;
        this.size = size;
    }

    @Override
    public void add(int index, int data) {
        if (count >= size) {
            growSize();
        }
        if (index >= count) {
            array[count] = data;
            count++;
        } else {
            for (int i = count; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = data;
            count++;
        }
    }

    @Override
    public void addAt(int data) {
        add(count, data);
    }

    @Override
    public void remove(int data) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (array[i] == data) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1];
            }
            count--;
            if (size > count * 2) {
                shrinkSize();
            }
        }
    }

    @Override
    public void removeAt(int index) {
        if (index >= 0 && index < count) {
            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1];
            }
            count--;
            if (size > count * 2) {
                shrinkSize();
            }
        }

    }

    @Override
    public void growSize() {
        int[] newArray = new int[size * 2];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size *= 2;
    }

    @Override
    public void shrinkSize() {
        int[] newArray = new int[count];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        size = count;
    }

    @Override
    public void set(int index, int data) {
        if (index >= 0 && index < count) {
            array[index] = data;
        }
    }

    @Override
    public int get(int index) {
        if (index >= 0 && index < count) {
            return array[index];
        }
        return -1;
    }

    @Override
    public void clear() {
        array = new int[size];
        count = 0;
    }

    @Override
    public boolean contains(int data) {
        for (int i = 0; i < count; i++) {
            if (array[i] == data) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
