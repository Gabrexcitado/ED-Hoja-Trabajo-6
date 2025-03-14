import java.util.ArrayList;

public class Pokemon implements Comparable<Pokemon>{
    
    private String name;
    private int number;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private ArrayList<String> abilities;
    private int generation;
    private String isLegendary;

    public Pokemon(String name, int number, String type1, String type2, String classification, double height, double weight, ArrayList<String> abilities, int generation, String isLegendary){
        this.name = name;
        this.number = number;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities= abilities;
        this.generation = generation;
        this.isLegendary = isLegendary;
    }
    public String getName(){
        return name;
    }

    public String getType1(){
        return type1;
    }

    public ArrayList<String> getAbilities(){
        return abilities;
    }

    public String toString(){
        String legendaryMessage;
        String type2Message;

        if(isLegendary == "Yes"){
            legendaryMessage = "Este pokemon es legendario"; 
        }else{
            legendaryMessage = "Este pokemon no es legendario";
        }

        if(type2 != ""){
            type2Message = type2;
        }else{
            type2Message = "No cuenta con tipo secundario";
        }
    
        return "\nNombre: " + name.toUpperCase() +
        "\nNo. en Pokedex: " + number + 
        "\nTipo Primario: " + type1 + 
        "\nTipo Secundario: " + type2Message +
        "\nClasificacion: " + classification + 
        "\nAltura: " + height + " metros" + 
        "\nPeso: " + weight + " kilogramos"+ 
        "\nHabilidades: " + abilities + 
        "\nGeneracion: " + generation +
        "\n"+legendaryMessage + "\n";
    }
    /**
     * Implementacion CompareTo para la pokedex del usuario
     * @param thatPokemon pokemon a comparar
     * @return orden por comparacion entre type1
     */
    @Override
    public int compareTo(Pokemon thatPokemon){
        return this.type1.compareTo(thatPokemon.type1);
    }
}
