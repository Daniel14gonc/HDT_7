/*
 * Nombre: Jose Daniel Gonzalez
 * Carne: 20293
 * BinarySearchTree
 *
 * Descripcion:
 *   Arbol binario que permite almacenar valores de forma ordenada.
 */


import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>> {

    private Comparator<E> comparator;
    private BinaryTree<E> root;
    private final BinaryTree<E> EMPTY = new BinaryTree<E>();
    private int count;

    public BinarySearchTree(){
        this(new NaturalComparator<E>());
    }

    /*Constructor que permite determinar el tipo de orden que tendrá el árbol.*/
    public BinarySearchTree( Comparator<E> alternateOrder){
        root = EMPTY;
        count = 0;
        comparator = alternateOrder;
    }


    public boolean isEmpty(){
        //Post: Retorna si el arbol está vacío o no.
        return root == EMPTY;
    }

    public void clear(){
        //Post: Elimina todos los elementos del árbol y lo reinicia.
        root = new BinaryTree<E>();
        count = 0;
    }

    public int size(){
        //Post: Retorna la cantidad de elementos del árbol.
        return count;
    }

    public BinaryTree<E> locate(BinaryTree<E> root, E value){
        //Pre: Determinar si el valor equivale a la raiz del arbol o
        //       si el valor ingresado es mayor o menor a al de la raiz.

        //Post: Se retorna la raiz o si el nodo no tiene hijos, se retorna el nodo actual.
        //      Si no, se hace una llamada recursiva hasta encontrar el nodo a retornar.
        E rootValue = root.value();
        BinaryTree<E> child;

        if(rootValue.equals(value)) return root;

        if(comparator.compare(rootValue, value) < 0){
            child = root.right();
        }
        else {
            child = root.left();
        }

        if(child.isEmpty()){
            return root;
        }
        else {
            return locate(child, value);
        }
    }

    protected BinaryTree<E> predecessor(BinaryTree<E> root)
    {
        //Post: Se obtiene el predecesor de un hijo.
        BinaryTree<E> result = root.left();
        while (!result.right().isEmpty()) {
            result = result.right();
        }
        return result;
    }

    public void add (E value){
        //Pre: Se determina si el arbol está vacío o no.
        //Post: Si el árbol no está vacío se determina el nodo donde se debe insertar.
        //      Luego se determina el lado (derecho o izquierdo), basado en una comparacion, en donde se debe
        //      insertar el nuevo valor. Finalmente se inserta y se aumenta el tamaño del árbol.

        BinaryTree<E> newNode = new BinaryTree<E>(value, EMPTY, EMPTY);

        if(root.isEmpty())
            root = newNode;
        else{
            BinaryTree<E> insertLocation = locate(root, value);
            E nodeValue = insertLocation.value();
            if(comparator.compare(nodeValue, value) < 0){
                insertLocation.setRight(newNode);
            }
            else{
                if(!insertLocation.left().isEmpty()){
                    predecessor(insertLocation).setRight(newNode);
                }
                else{
                    insertLocation.setLeft(newNode);
                }
            }
        }
        count++;
    }

    public Iterator<E> iterator(){
        //Post: Se obtiene el iterador del árbol.
        return root.iterator();
    }

    public boolean contains(E value){
        //Post: Se busca la locación del valor ingresado y se retorna si el valor ingresado es igual al del nodo encontrado.
        if (root.isEmpty()) return false;

        BinaryTree<E> possibleLocation = locate(root,value);
        return value.equals(possibleLocation.value());
    }


    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<BinarySearchTree:");
        if (!root.isEmpty()) {
            s.append(root);
        }
        s.append(">");
        return s.toString();
    }

    public E get(E value)
    {
        //Post: Se obtiene la locación del nodo que contiene el valor y si es igual, se devuelve este árbol.
        if (root.isEmpty()) return null;

        BinaryTree<E> possibleLocation = locate(root,value);
        if (value.equals(possibleLocation.value()))
            return possibleLocation.value();
        else
            return null;
    }

    public BinaryTree<E> getRoot(){
        //Post: Se devuelve la raíz del árbol.
        return root;
    }

}
