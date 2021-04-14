import java.util.Comparator;

public class AssociationComparator <E extends  Association> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        Comparable a1 = (Comparable)((Association) o1).getKey();
        Comparable b1 = (Comparable)((Association) o2).getKey();

        System.out.println(a1 + " sfsf");
        System.out.println(b1 + " sfsd");
        System.out.println(a1.compareTo(b1));
        return (a1.compareTo(b1));
    }
}
