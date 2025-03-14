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
        boolean runProgram = true;
        TreeSet<Pokemon> myPokedex = new TreeSet<>();


        System.out.print("\n1. HashMap\n2. TreeMap\n3. LinkedHashMap\n\nEscoge la implementacion que deseas utilizar: ");
            Map<String,Pokemon> pokedex = Converter.pokedexToMap(sc.nextLine());
            System.out.print("***Mapa creado con exito***\n\n");

        while(runProgram){

            System.out.print(""+
            "/////////////////////---MENU---/////////////////////\n" + 
            "1. Agregar un Pokemon a tu Pokedex\n" +
            "2. Mostrar datos de un Pokemon\n" + 
            "3. Ver mis Pokemon\n" + 
            "4. Ver Pokemon existentes\n" +
            "5. Buscar Pokemon con habilidad especifica\n\n"+
            "¿Que deseas hacer?... ");

            switch(sc.nextLine()){
                case "1":
                    System.out.print("\nEscribe el nombre del Pokemon: ");
                    String pokemonSelected = sc.nextLine().trim().toLowerCase();

                    if(pokedex.containsKey(pokemonSelected)){
                        Pokemon pokemonToAdd = pokedex.get(pokemonSelected);

                        if(myPokedex.add(pokemonToAdd)){
                            System.out.println("\n" + pokemonToAdd.getName().toUpperCase() + " agregado a tu pokedex\n\n");
                        }
                    }else{
                        System.out.println("\n>>>Pokemon no registrado...\n\n");
                    }
                break;

                case "2":

                default: 
                    System.out.print("Opcion no valida\n");
            }
        }  
        sc.close();         
    }
}
