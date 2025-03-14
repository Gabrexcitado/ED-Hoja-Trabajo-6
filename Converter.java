import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
/**
 * Clase para la lectura del archivo csv
 */
public class Converter {

    /**
     * vuelve los datos del csv en un mapa del tipo elegido por el usuario
     * @param option tipo de map elegido por el usuario
     * @return mapa con todos los pokemon
     */
    public static Map<String,Pokemon> pokedexToMap(String option){
        Map <String,Pokemon> map = Factory.mapFactory(option); 
        ArrayList<Pokemon> listToSort = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("pokedex.csv"))){
            br.readLine(); //Saltar encabezado
            String line; 
            while((line = br.readLine()) != null){
                String []  data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                                            //expresion para que no se separen las comas dentro de las comillas

                try {
                    String name = data[0].trim().toLowerCase();
                    int number = Integer.parseInt(data[1].trim());
                    String type1 = data[2].trim();
                    String type2 = data[3].trim();
                    String classification = data[4].trim();
                    double height = Double.parseDouble(data[5].trim());
                    double weight = Double.parseDouble(data[6].trim());

                    //Separacion de habilidades para el ArrayList
                    String[] listedAbilities =  data[7].split(",;");
                    ArrayList<String> abilities = new ArrayList<>();
                    for (String ability:listedAbilities){
                        abilities.add(ability.trim());
                    }

                    int generation = Integer.parseInt(data[8].trim());
                    String isLegendary = data[9].trim();

                    Pokemon pokemon = new Pokemon(name, number, type1, type2, classification, height, weight, abilities, generation, isLegendary);
                    listToSort.add(pokemon);

                }catch (Exception e){
                System.out.println("Error procesando línea: " + line);
                e.printStackTrace(); 
                }
            }
            //Ordenar la lista por tipo para luego agregarla al mapa
            listToSort.sort((pokemon1, pokemon2) -> pokemon1.getType1().compareTo(pokemon2.getType1()));   

            for (Pokemon pokemon :listToSort){
                map.put(pokemon.getName(), pokemon);
            }             

        }catch(Exception e){
        System.out.println("No se logró leer el archivo");
        }
        return map;
    }
    
}
