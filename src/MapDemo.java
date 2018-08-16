import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapDemo
{
    public static void main(String[] args)
    {
        Set<Integer> mySet = new HashSet<>();

        int silentTId = 10;
        int ronnieId = 20;
        int louisId = 30;

        mySet.add(silentTId);
        mySet.add(ronnieId);
        mySet.add(louisId);

        System.out.println(mySet.contains(20));

        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(silentTId, "Silent T");
        myMap.put(ronnieId, "Ronnie");
        System.out.println(myMap.get(20));
        myMap.put(ronnieId, "Sabrina");
        myMap.put(louisId, "Louis");
        System.out.println(myMap.get(20));


        if (myMap.containsValue("Sabrina"))
        {
            System.out.println("Found Sabrina");
        }

        if (myMap.containsKey(20))
        {
            System.out.println("Found 20");
        }
    }
}
