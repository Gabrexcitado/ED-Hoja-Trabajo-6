import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class Factory{

    public static <K, V> Map<K, V> mapFactory(String option){
        switch(option){
            case "1":
                return new HashMap<K, V>();

            case "2":
                return new TreeMap<K,V>();

            case "3":
                return new LinkedHashMap<K, V>();

            default:
            throw new IllegalArgumentException("Opción no válida: " + option);
        }
    
    } 
}