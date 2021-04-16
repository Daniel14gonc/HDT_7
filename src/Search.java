import java.util.Iterator;

public class Search {

    public Search() {

    }

    public String search(BinarySearchTree bst, String value, int idioma) {
        Iterator iterator = bst.iterator();
        String order = "";
        while (iterator.hasNext()) {
            ComparableAssociation<String, String[]> temp = (ComparableAssociation<String, String[]>) iterator.next();
            String[] tempWords = temp.getValue();
            //System.out.println(temp.getKey());
            if (value.equals(temp.getKey())) {
                return tempWords[idioma];
            }
        }
        return "";
    }
}
