package application;
public class Array1 {
    private int[] array;
    private int size;
    private int currentSize = 0;

    public Array1(int size) {
        this.size = size;
        array = new int[size];
    }

    public boolean insert1(int value) {
        if (currentSize >= size) {
            return false;
        }
        array[currentSize++] = value;
        return true;
    }

    public boolean delete1(int index) {
        if (index < 0 || index >= currentSize) {
            return false; 
        }
        for (int i = index; i < currentSize - 1; i++) {
            array[i] = array[i + 1];
        }
        array[currentSize - 1] = 0;
        currentSize--;
        return true;
    }
    
    public boolean replace1(int index,int value) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        array[index]=value;
        return true;
    }

    public int[] getArray() {
        return array;
    }

	public int getCurrentSize() {
		return currentSize;
	}
}
