import java.util.ArrayList;

public class Pokemon {
    
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
}
