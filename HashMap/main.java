package HashMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class main {
    public static void main(String[] args) {

        MapUsingHash myMap = new MapUsingHash();
        myMap.put("abc","xyz");
        myMap.put("def","pqr");
        myMap.put("ghi","stw");
        myMap.put("jkl","mno");
//        System.out.println(myMap.get("ghi"));

        HashMap<String,Integer> map = new HashMap<>();
        map.put("ishan", 23);
        map.put("code" , 12);

        HashSet<String> set = new HashSet<>();
        System.out.println(set.contains("sius"));
        String s= "ishan";


        System.out.println("String : " + s.substring(0,3));
//      System.out.println(map.get("ishan"));
//      System.out.println(map.size());
    
        //Hashset => no duplicates

        // Iteration on HashMap =>
            // 1] Using an entry set
            for (Map.Entry<String , Integer> e : map.entrySet()){
                System.out.println(e.getKey());
                System.out.println(e.getValue());
            }

            //2] Using a key set
            Set<String> keys = map.keySet();
            for (String key : keys ){
                System.out.println(key + " : " + map.get(key));
            }

    }
}
