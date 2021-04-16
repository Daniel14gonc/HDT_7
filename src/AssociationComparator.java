/*
 * Nombre: Jose Daniel Gonzalez
 * Carne: 20293
 * AssociationComparator
 *
 * Descripcion:
 *   Permite realizar una comparacion de asociaciones.
 */


import java.util.Comparator;

public class AssociationComparator <E extends  Association> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        //Se obtienen las llaves de dos asociaciones y se comparan.
        Comparable a1 = (Comparable)((Association) o1).getKey();
        Comparable b1 = (Comparable)((Association) o2).getKey();

        return (a1.compareTo(b1));
    }
}
