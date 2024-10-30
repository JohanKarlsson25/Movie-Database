package johkar2.kth.se.moviedatabase.model;

public class EList <T>{

    private T[] objects;
    private int numberOfElements;

    @SuppressWarnings("unchecked")
    public EList(){
        objects = (T[]) new Object[100];
        numberOfElements = 0;
    }

    public int size(){
        return numberOfElements;
    }

    public void add(T object){
        if (numberOfElements >= objects.length) resize();
        objects[numberOfElements++] = object;
    }

    //TODO look into if ControlZ should work, need to store copy
    public T remove(int index){
        if (index < 0 || index >= numberOfElements) throw new IndexOutOfBoundsException();
        T copy = objects[index];
        pack(index);
        return copy;
    }

    //TODO look into if ControlZ should work, need to store copy
    public boolean remove(T object){
        if (this.contains(object)){
            int index = getIndex(object);
            pack(index);
            return true;
        }
        return false;
    }

    public T get(int index){
        return objects[index];
    }

    public boolean contains(T object){
        for (T o : objects){
            if (o.equals(object)) return true;
        }
        return false;
    }

    private void pack(int index){
        for (int i = index; i < numberOfElements-index-1; i++){
            objects[i] = objects[i+1];
            numberOfElements--;
        }
    }

    private int getIndex(T object){
        for (int i = 0; i < numberOfElements; i++){
            if (object.equals(objects[i])) return i;
        }
        throw new IllegalArgumentException("Object is not contained within list");
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        T[] copy = (T[]) new Object[objects.length+10];
        for (int i = 0; i < numberOfElements; i++){
            copy[i] = objects[i];
        }
        objects = copy;
    }
}
