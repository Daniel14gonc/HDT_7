/*
 * Nombre: Jose Daniel Gonzalez
 * Carne: 20293
 * Association
 *
 * Descripcion:
 *   Clase que permite definir un objeto que almacena una llave y un valor.
 */


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
        //Post: Se devuelve la llave de la asociacion.
        return key;
    }

    public V getValue(){
        //Post: Se devuelve el valor de la asociacion.
        return  value;
    }
}
