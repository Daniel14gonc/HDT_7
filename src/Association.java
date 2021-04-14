public class Association<K extends Comparable<K>, V>{

    protected K key;
    protected V value;

    public Association(K key, V value){
        this.key = key;
        this.value = value;
    }

    public Association(){

    }

    public K getKey() {
        return key;
    }

    public V getValue(){
        return  value;
    }
}
