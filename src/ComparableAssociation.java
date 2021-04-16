/*
 * Nombre: Jose Daniel Gonzalez
 * Carne: 20293
 * ComparableAssociation
 *
 * Descripcion:
 *   Permite crear una clase que almacena una asociacion, que ademas permite comparar
 *   con otras asociaciones.
 */


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
        //Post: Se comparan las llaves de la asociacion actual contra otra.
        return getKey().compareTo(a.getKey());
    }

    public boolean equals(ComparableAssociation other){
        //Post: Se determina si la asociacion es igual a otra o no.
        return this.equals(other);
    }

    public String toString(){
        return "[" + key + " , " + value+" ]";
    }
}

