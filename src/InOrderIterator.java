import java.util.Iterator;
import java.util.Stack;

public class InOrderIterator<E> implements Iterator<E> {

    protected BinaryTree<E> root;
    protected Stack<BinaryTree<E>> todo;

    public InOrderIterator(BinaryTree<E> root){
        this.root = root;
    }

    public void reset(){
        todo.clear();

        BinaryTree<E> current = root;
        while(!current.isEmpty()){
            todo.push(current);
            current = current.left();
        }
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    public E next(){
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
