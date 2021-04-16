/*
    * Nombre: Jose Daniel Gonzalez
    * Carne: 20293
    * BinarySearchTree
    *
    * Descripcion:
    *   Test unitarios que permiten probar la localizacion de un elemento dentro de un arbol binario y
    *   tambien añadir un elemento.
 */


import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @org.junit.Test
    public void locate() {
        BinarySearchTree<ComparableAssociation<String,String>> t1 = new BinarySearchTree<ComparableAssociation<String,String>>();
        ComparableAssociation<String,String> a1 = new ComparableAssociation<String,String>("prueba", "insercion");
        t1.add(a1);
        BinaryTree<ComparableAssociation<String,String>> t2 = t1.locate(t1.getRoot(), a1);
        ComparableAssociation<String,String> comp = t2.value();

        assertEquals("No se completo la operacion de buscar", a1, comp);

    }

    @org.junit.Test
    public void add() {
        BinarySearchTree<ComparableAssociation<String,String>> t1 = new BinarySearchTree<ComparableAssociation<String,String>>();
        ComparableAssociation<String,String> a1 = new ComparableAssociation<String,String>("prueba", "insercion");

        t1.add(a1);

        boolean temp = t1.contains(a1);
        assertTrue("La operacion de añadir no fue realizada correctamente.", temp);
    }

}