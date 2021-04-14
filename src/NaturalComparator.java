import java.util.Comparator;

public class NaturalComparator<E extends  Comparable<E>> implements Comparator<E> {

    public int compare(E a, E b){
        return a.compareTo(b);
    }

    public boolean equals(Object b){
        return(b != null) && (b instanceof NaturalComparator);
    }
}
