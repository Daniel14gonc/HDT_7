import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Bienvenido al sistema de traduccion.");
        System.out.println("Estamos ordenando tus palabras...\n");

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
                        new String[] {palabras[0], palabras[1], palabras[2]});

                ComparableAssociation<String, String[]> es = new ComparableAssociation<String, String[]>(palabras[1],
                        new String[] {palabras[0], palabras[1], palabras[2]});

                ComparableAssociation<String, String[]> fr = new ComparableAssociation<String, String[]>(palabras[2],
                        new String[] {palabras[0], palabras[1], palabras[2]});

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
                order += "("+ temp.getKey() + ", " + tempWords[1] + ", " + tempWords[2] + ")";
            }
            System.out.println("El diccionario en ingles in-order es: \n" + order);

            Scanner scan = new Scanner(System.in);
            System.out.println("\nIngrese el nombre del archivo donde se encuentra la frase que desea traducir.");
            String nombre = scan.nextLine();

            myObj = new File(nombre + ".txt");
            myReader = new Scanner(myObj);
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
            }
            myReader.close();

            String[] frase = data.split("\\s");

            System.out.println("\nIngrese la opcion del idioma esta la frase que desea traducir");
            System.out.println("1. Ingles");
            System.out.println("2. Español");
            System.out.println("3. Frances");
            int origen = scan.nextInt()-1;

            System.out.println("\nIngrese en que idioma al que desea traducir la frase");
            System.out.println("1. Ingles");
            System.out.println("2. Español");
            System.out.println("3. Frances");
            int destino = scan.nextInt()-1;

            BinarySearchTree<ComparableAssociation<String, String[]>> dic = null;

            switch (origen){
                case 0:
                    dic = ingBst;
                    break;
                case 1:
                    dic = esBst;
                        break;
                case 2:
                    dic = frBst;
                    break;
                default:
                    System.out.println("El diccionario no soporta este lenguaje.");
                    break;
            }

            Search buscador = new Search();
            String acu = "";
            for(String palabra: frase){
                String temp = buscador.search(dic, palabra, destino);
                if(!temp.isEmpty())
                    acu += temp + " ";
                else{
                    acu += "*" + palabra + "* ";
                }
            }

            System.out.println("\nLa frase traducida es: " + acu);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }
}
