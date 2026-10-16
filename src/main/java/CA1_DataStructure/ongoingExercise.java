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

    public int size(){
        return size;
    }

    public String get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index " + index + "this is outside bounds of array");
        }

        return data[index];
    }

    public int indexOf(String element){
            for(int i =0; i < size; i++){
                if(element != null){
                    if(data[i] == null){
                        return i;
                    }

                } else if (element.equals(data[i])) {
                    return i;
                }

        }
        return -1;
    }



}
