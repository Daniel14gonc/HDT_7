/*
 * Nombre: Jose Daniel Gonzalez
 * Carne: 20293
 * Test InOrderIterator
 *
 * Descripcion:
 *   Iterador quee permite recorrero el árbol in order.
 */


import java.util.Iterator;
import java.util.Stack;

public class InOrderIterator<E> implements Iterator<E> {

    protected BinaryTree<E> root;
    protected Stack<BinaryTree<E>> todo;


    public InOrderIterator(BinaryTree<E> root){
        //Constructor
        //Post: Permite crear un nuevo stack donde se guardaran los nodos que recorra el iterador y se define la raíz.
        todo = new Stack<BinaryTree<E>>();
        this.root = root;
        reset();
    }

    public void reset(){
        //Post: Se hace un reset al stack y se almacena en este los hijos en la izquierda de cada nodo.
        todo.clear();

        BinaryTree<E> current = root;
        while(!current.isEmpty()){
            todo.push(current);
            current = current.left();
        }
    }

    @Override
    public boolean hasNext() {
        //Post: Se determina si el arbol aun tiene nodos en in order.
        return !todo.isEmpty();
    }

    public E get(){
        return todo.peek().value();
    }

    public E next(){
        //Post: Se obtiene el resultado del ultimo arbol ingresado en el stack. Se ingresan los hijos del hijo derecho
        //      del ultimo arbol ingresado al stack en el stack.
        BinaryTree<E> old = todo.pop();
        E result = old.value();
        if(!old.right().isEmpty()){
            BinaryTree<E> current = old.right();
            do {
                todo.push(current);
                current = current.left();
            } while (!current.isEmpty());
        }

        return result;
    }

}
