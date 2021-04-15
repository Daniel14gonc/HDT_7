import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bienvenido al sistema de traduccion.");
        System.out.println("Estamos ordenando tus palabras...");

        Comparator aComp = new AssociationComparator<Association<String, String[]>>();

        BinarySearchTree<ComparableAssociation<String, String[]>> esBst = new BinarySearchTree<ComparableAssociation<String, String[]>>(aComp);
        BinarySearchTree<ComparableAssociation<String, String[]>> ingBst = new BinarySearchTree<ComparableAssociation<String, String[]>>(aComp);
        BinarySearchTree<ComparableAssociation<String, String[]>> frBst = new BinarySearchTree<ComparableAssociation<String, String[]>>(aComp);

        try {
            File myObj = new File("palabras.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] palabras = data.split(",");
                ComparableAssociation<String, String[]> ing = new ComparableAssociation<String, String[]>(palabras[0],
                        new String[] {palabras[1], palabras[2]});

                ComparableAssociation<String, String[]> es = new ComparableAssociation<String, String[]>(palabras[1],
                        new String[] {palabras[0], palabras[2]});

                ComparableAssociation<String, String[]> fr = new ComparableAssociation<String, String[]>(palabras[2],
                        new String[] {palabras[0], palabras[1]});

                ingBst.add(ing);
                esBst.add(es);
                frBst.add(fr);
            }
            myReader.close();


            Iterator iterator = ingBst.iterator();
            String order = "";
            while(iterator.hasNext()){
                ComparableAssociation<String, String[]> temp = (ComparableAssociation<String, String[]>) iterator.next();
                String[] tempWords = temp.getValue();
                order += "("+ temp.getKey() + ", " + tempWords[0] + ", " + tempWords[1] + ")";
            }
            System.out.println("El diccionario en ingles in-order es: \n" + order);

            Scanner scan = new Scanner(System.in);
            System.out.println("Ingrese el nombre del archivo donde se encuentra la frase que desea traducir.");
            String nombre = scan.nextLine();

            myObj = new File(nombre + ".txt");
            myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
            }
            myReader.close();

            String[] frase = data.split("\\s");

            System.out.println("Ingrese en que idioma esta la frase que desea traducir");
            String origen = scan.nextLine();

            System.out.println("Ingrese en que idioma al que desea traducir la frase");
            String destino = scan.nextLine();

            BinarySearchTree<ComparableAssociation<String, String[]>> dic;

            switch (origen){
                case "español":
                    dic = esBst;
                    break;
                case "ingles":
                    dic = ingBst;
                        break;
                case "frances":
                    dic = frBst;
                    break;
                default:
                    System.out.println("El diccionario no soporta este lenguaje.");
                    break;
            }




        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
