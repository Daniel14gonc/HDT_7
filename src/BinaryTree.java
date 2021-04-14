import java.util.Iterator;

public class BinaryTree<E> {

    protected E val;
    protected BinaryTree<E> parent;
    protected BinaryTree<E>left, right;

    public BinaryTree(){
        val = null;
        parent = null;
        left = right = this;
    }

    public BinaryTree(E value){
        val = value;
        right = left = new BinaryTree<E>();
        setRight(right);
        setLeft(left);

    }

    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right){
        val = value;
        if (left == null) { left = new BinaryTree<E>(); }
        setLeft(left);
        if (right == null) { right = new BinaryTree<E>(); }
        setRight(right);
    }

    public void setLeft(BinaryTree<E> newLeft){
        if(isEmpty()) return;
        if(left != null && left.parent() == this)
            left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    public void setRight(BinaryTree<E> newRight){
        if(isEmpty()) return;
        if(right != null && right.parent() == this)
            right.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    protected void setParent(BinaryTree<E> parent){
        if(!isEmpty())
            this.parent = parent;
    }

    public BinaryTree<E> left(){
        return left;
    }

    public BinaryTree<E> right(){
        return right;
    }

    public BinaryTree<E> parent(){
        return parent;
    }

    public E value(){
        return val;
    }

    public void setValue(E value){
        val = value;
    }

    public boolean isEmpty() {
        return val == null;
    }

    public Iterator<E> iterator(){
        return new InOrderIterator<E>(this);
    }
}
