import java.util.Iterator;

public class Search {

    public Search(){

    }

    public String search(BinarySearchTree bst, String value, String idioma){
        Iterator iterator = bst.iterator();
        String order = "";
        while(iterator.hasNext()){
            ComparableAssociation<String, String[]> temp = (ComparableAssociation<String, String[]>) iterator.next();
            String[] tempWords = temp.getValue();
            order += "("+ temp.getKey() + ", " + tempWords[0] + ", " + tempWords[1] + ")";
        }
    }

}
