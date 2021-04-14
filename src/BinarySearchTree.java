import javax.swing.*;
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

    public BinarySearchTree( Comparator<E> alternateOrder){
        root = EMPTY;
        count = 0;
        comparator = alternateOrder;
    }

    public boolean isEmpty(){
        return root == EMPTY;
    }

    public void clear(){
        root = new BinaryTree<E>();
        count = 0;
    }

    public int size(){
        return count;
    }

    public BinaryTree<E> locate(BinaryTree<E> root, E value){
        E rootValue = root.value();
        BinaryTree<E> child;

        if(rootValue.equals(value)) return root;

        System.out.println(comparator.compare(rootValue, value) + " resultado");

        if(comparator.compare(rootValue, value) < 0){
            child = root.right();
        }
        else {
            child = root.left();
        }

        if(child.isEmpty()){
            return  root;
        }
        else {
            return locate(child, value);
        }
    }

    protected BinaryTree<E> predecessor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.left();
        while (!result.right().isEmpty()) {
            result = result.right();
        }
        return result;
    }

    protected BinaryTree<E> successor(BinaryTree<E> root)
    {
        BinaryTree<E> result = root.right();
        while (!result.left().isEmpty()) {
            result = result.left();
        }
        return result;
    }

    public void add (E value){
        BinaryTree<E> newNode = new BinaryTree<E>(value, EMPTY, EMPTY);
        E val = newNode.value();

        if(root.isEmpty())
            root = newNode;
        else{

            BinaryTree<E> insertLocation = locate(root, value);
            E nodeValue = insertLocation.value();
            if(comparator.compare(val, value) < 0){
                insertLocation.setRight(newNode);

                predecessor(insertLocation).setRight(newNode);
            }
            else{
                insertLocation.setLeft(newNode);
            }
        }
        count++;
    }

    public Iterator<E> iterator(){
        return root.iterator();
    }

    public boolean contains(E value){
        return false;
    }

    public E get(E value){
        return null;
    }

    public E remove (E value){
        return null;
    }

}
