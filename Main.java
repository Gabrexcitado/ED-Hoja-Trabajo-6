import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Programa de simulacion de pokedex utilizando mapas
 * @author Gabriel Hidalgo 24939
 * Creado: 12-03-2025
 * Ultima edicion:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Pokemon> pokedex;
        boolean runProgram = true;
        TreeSet<Pokemon> myPokedex = new TreeSet<>();
        String pokemonSelected;
        String abilitySelected;
        int i;
        ArrayList<Pokemon> listToSort = new ArrayList<>(); 


        System.out.print("\n1. HashMap\n2. TreeMap\n3. LinkedHashMap\n\nEscoge la implementacion que deseas utilizar: ");
            switch(sc.nextLine()){
            case "1":
                pokedex = Converter.pokedexToMap("1");
                System.out.print("***Mapa creado con exito***\n\n");
            break;

            case "2":
                pokedex = Converter.pokedexToMap("2");
                System.out.print("***Mapa creado con exito***\n\n");
            break;

            case "3":
                pokedex = Converter.pokedexToMap("3");
                System.out.print("***Mapa creado con exito***\n\n");
            break;
            
            default:
                    System.out.println("Opcion no valida");
            break;
            }
                    


        while(runProgram){

            System.out.print(""+
            "/////////////////////---MENU---/////////////////////\n" + 
            "1. Agregar un Pokemon a tu Pokedex\n" +
            "2. Mostrar datos de un Pokemon\n" + 
            "3. Ver mis Pokemon\n" + 
            "4. Ver Pokemon existentes\n" +
            "5. Buscar Pokemon con habilidad especifica\n"+
            "0. Salir\n\n" +
            "¿Que deseas hacer?... ");

            switch(sc.nextLine()){
                case "1":
                    System.out.print("\nEscribe el nombre del Pokemon: ");
                    pokemonSelected = sc.nextLine().trim().toLowerCase();

                    if(pokedex.containsKey(pokemonSelected)){
                        Pokemon pokemonToAdd = pokedex.get(pokemonSelected);

                        if(myPokedex.add(pokemonToAdd)){
                            System.out.println("\n" + pokemonToAdd.getName().toUpperCase() + " agregado a tu pokedex\n\n");
                        }else{
                            System.out.println(">>>Ya tienes a este Pokemon...");
                        }
                    }else{
                        System.out.println("\n>>>Pokemon no registrado...\n\n");
                    }
                break;

                case "2":
                    System.out.print("\nEscribe el nombre del Pokemon: ");
                    pokemonSelected = sc.nextLine().trim().toLowerCase();

                    if(pokedex.containsKey(pokemonSelected)){
                        System.out.println(pokedex.get(pokemonSelected).toString());
                    }else{
                        System.out.println("\n>>>Pokemon no encontrado...\n\n");
                    }
                break;

                case "3":
                    i=0;
                    for(Pokemon pokemon : myPokedex){
                        System.out.println("\n" + i+1 + ". " + pokemon.getName().toUpperCase() + ", Tipo: "+ pokemon.getType1());
                        i++;
                    }
                break;

                case "4":
                //Guardar el map en una lista para ordenarla
                for(Map.Entry<String, Pokemon> entry : pokedex.entrySet()){
                    listToSort.add(entry.getValue());
                }   
                listToSort.sort((p1,p2)->  p1.getType1().compareTo(p2.getType1()));
                
                //Imprimir lista
                i=0;
                for(Pokemon pokemon:listToSort){
                    System.out.println((i+1) + ". " + pokemon.getName().toUpperCase() + ", Tipo: " + pokemon.getType1());
                    i++;
                }
                break;
            
                case "5":
                    System.out.print("\nEscriba la habilidad a buscar: ");
                    abilitySelected = sc.nextLine().trim().toLowerCase();

                    for(Map.Entry<String, Pokemon> entry : pokedex.entrySet()){
                        ArrayList<String> pokemonAbilities = entry.getValue().getAbilities();
                        for(String ability:pokemonAbilities){
                            if(ability == abilitySelected){
                                listToSort.add(entry.getValue());
                            }
                        }
                    } 
                    i=0;
                    for(Pokemon pokemon : listToSort){
                        System.out.println((i+1) + ". " + pokemon.getName().toUpperCase());
                        i++;
                    }
                break;

                case "0":
                    System.out.println("Cerrando Pokedex...");
                    runProgram = false;
                break;

                default: 
                    System.out.print("Opcion no valida\n");
                break;
            }
        }  
        sc.close();         
    }
}
