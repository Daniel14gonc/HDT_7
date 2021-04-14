public class ComparableAssociation<K extends Comparable<K>,V>
        extends Association<K,V>
        implements Comparable<ComparableAssociation<K,V>> {

    public ComparableAssociation(K key){
        this(key, null);
    }

    public ComparableAssociation(K key, V value){
        super(key, value);
    }

    @Override
    public int compareTo(ComparableAssociation<K, V> a) {
        return getKey().compareTo(a.getKey());
    }

    public boolean equals(ComparableAssociation other){
        return this.equals(other);
    }

    public String toString(){
        return "[" + key + " , " + value+" ]";
    }
}

