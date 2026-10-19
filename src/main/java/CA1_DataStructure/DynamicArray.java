package CA1_DataStructure;

/**
 * An array-based implementation of a list that stores Strings.
 * Starts with capacity 10 and doubles when full.
 */
public class DynamicArray {
    private String[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10; //elements
    private static final int EXPANSION_FACTOR = 2; // size increase

    /**
     * Creates an empty DynamicArray with an initial capacity of 10 elements.
     */
    public DynamicArray() {
        this.data = new String[INITIAL_CAPACITY];
        this.size = 0;
    }

    /**
     * Returns the number of elements currently stored in the list.
     *
     * @return the current size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index the position to read from (0 to size-1)
     * @return the element stored at that index
     * @throws IndexOutOfBoundsException if index is less than 0 or greater than or equal to size
     */
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + "this is outside bounds of array");
        }

        return data[index];
    }

    /**
     * Returns the position of the first occurrence of the given element, or -1 if not found.
     *
     * @param element the value to search for
     * @return the index of the first match, or -1 if not present
     */
    public int indexOf(String element) {
        for (int i = 0; i < size; i++) {
            if (element == null) {
                if (data[i] == null) {
                    return i;
                }

            } else if (element.equals(data[i])) {
                return i;
            }

        }
        return -1;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the value to add
     */
    public void add(String element) {
        if (element == null) {
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
    /**
     * Inserts an element at the specified index, shifting later elements right.
     *
     * @param index   the position to insert at (0 to size)
     * @param element the value to insert
     * @throws IndexOutOfBoundsException if index is less than 0 or greater than size
     */
    public void add(int index, String element) {
        if (element == null) return;

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
// Shift elements right to make room at index
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = element;
        size++;


    }
    /**
     * Replaces the element at the specified index with the given element.
     *
     * @param index   the position to replace (0 to size-1)
     * @param element the new value
     * @return the element that was previously at that index
     * @throws IndexOutOfBoundsException if index is less than 0 or greater than or equal to size
     */
    public String set(int index, String element){
        if(element == null) {
            return null;
        }

        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
        }

        String old = data[index];
        data[index] = element;
        return old;
    }
    /**
     * Removes and returns the element at the specified index.
     *
     * @param index the position to remove from (0 to size-1)
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if index is less than 0 or greater than or equal to size
     */
    public String remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + ", size: " + size);
        }

        String removed = data[index];

        for(int i = index; i < size - 1; i++){
            data[i] = data[i + 1];
        }

        size --;
        data[size] = null;

        return removed;
    }
    /**
     * Removes all occurrences of the given element from the list.
     *
     * @param element the value to remove
     * @return the number of elements removed
     * @throws IllegalArgumentException if element is null
     */
    public int removeAll(String element){
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        int count = 0;

        for(int i = 0; i < size; i++){
            if(element.equals(data[i])){
                for(int j = i; j < size -1; j++){
                    data[j] = data[j + 1];
                }
                size--;
                data[size] = null;

                i--;

                count++;
            }
        }
        return count;
    }
    /**
     * Removes all elements from the list, resetting it to empty.
     */
    public void clear(){
        size = 0;
    }
    /**
     * Returns a new list containing only one instance of each element from this list.
     * The original list is unchanged.
     *
     * @return a new list with duplicates removed
     */
    public DynamicArray deduplicate(){
        DynamicArray newList = new DynamicArray();

        for(int i = 0; i < size; i++){
            if(newList.indexOf(data[i]) == -1){
                newList.add(data[i]);
            }

        }
        return newList;
    }
    /**
     * Adds all elements from the given list to the end of this list.
     *
     * @param otherList the list whose elements will be added
     * @throws IllegalArgumentException if otherList is null
     */
    public void join(DynamicArray otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        for (int i = 0; i < otherList.size(); i++) {
            this.add(otherList.get(i));
        }
    }


}
