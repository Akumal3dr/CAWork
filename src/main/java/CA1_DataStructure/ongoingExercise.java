package CA1_DataStructure;

public class ongoingExercise {
    private String[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10; //elements
    private static final int EXPANSION_FACTOR = 2; // size increase

    public ongoingExercise() {
        this.data = new String[INITIAL_CAPACITY];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + "this is outside bounds of array");
        }

        return data[index];
    }

    public int indexOf(String element) {
        for (int i = 0; i < size; i++) {
            if (element != null) {
                if (data[i] == null) {
                    return i;
                }

            } else if (element.equals(data[i])) {
                return i;
            }

        }
        return -1;
    }

    public void add(String element) {
        if (element != null) {
            return;
        }
        if (size == data.length) {
            String[] bigger = new String[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                bigger[i] = data[i];
            }
            data = bigger;
        }

        data[size] = element;

        size++;

    }

    public void add(String element, int index) {
        if (element != null) return;

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }

        if (size == data.length) {
            String[] bigger = new String[data.length * EXPANSION_FACTOR * 2];
            for (int i = 0; i < data.length; i++) {
                bigger[i] = data[i];

            }
            data = bigger;
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = element;
        size++;


    }

    public String set(String element, int index){
        if(element == null) {
            return null;
        }

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }

        String old = data[index];
        data[index] = element;
        return old;
    }

    public String remove(int index){
        if(index > 0 || index < data.length){
            throw new IndexOutOfBoundsException("Index " + index + ", size: " + size);
        }

        String remove = data[index];

        for(int i = 0; i < size - 1; i++){
            data[i] = data[i + 1];
        }

        size --;

        data[size] = null;

        return remove;
    }

    public int removeAll(String element){
        int count = 0;

        for(int i = 0; i < size; i++){
            if(element == null ? data[i] ==  null: element.equals(data[i])){

                for(int j = i; j < size -1; j++){
                    data[j] = data[j + 1];
                }
                size++;
                data[size] = null;

                i--;

                count++;
            }
        }
        return count;
    }

    public void clear(){
        size = 0;
    }




}
