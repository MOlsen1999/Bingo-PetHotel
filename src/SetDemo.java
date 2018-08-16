import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();

        myList.add("Blah");
        myList.add("Blah");
        myList.add("De");
        myList.add("Da");

        System.out.println("List Contents -> " + myList);

        Set<String> mySet = new HashSet<>();

        mySet.add("Blah");
        mySet.add("Blah");
        mySet.add("Blah");
        mySet.add("Blah");
        mySet.add("Blah");
        mySet.add("De");
        mySet.add("Da");
        mySet.remove("Blah");
        System.out.println("Set Contents -> " + mySet);

    }
}

