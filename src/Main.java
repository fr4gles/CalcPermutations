
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Główna klasa programu
 * @author Michal
 */
public class Main
{
    /**
     * zmienna obpowiadająca za wypis testowy
     */
    public static Boolean Test = Boolean.FALSE;
    
    /**
     * wczytywanie danych z pliku
     * @param fileToRead
     * @return 
     */
    private static List<Integer> WczytajPlik(String fileToRead)
    {
        List<Integer> permutacje = new ArrayList<>();
        File file = new File(fileToRead); // użycie pliku wejsciowego do odczytu danych
        try
        {
            Scanner sc = new Scanner(file).useDelimiter("\\D+"); // pobieranie tylko liczb ...
            while (sc.hasNext())
            {
                Integer p = sc.nextInt();

                permutacje.add(p);
                
                if(Main.Test)
                    System.out.println(p);
            }
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("BLAD Z PARSOWANIEM PLIKU WEJSCIOWEGO czy PLIK istnieje??? -> " + ex.getMessage());
        }
        catch (NoSuchElementException ex)
        {
            if (Main.Test)
            {
                System.err.println("BLAD ZLY FORMAT PERMUTACJI -> " + ex.getMessage());
            }
        }
        return permutacje;
    }
    
    /**
     * main
     * @param args argumenty
     */
    public static void main(String[] args)
    {
        if (args.length<1)
        {
            System.err.println("Podaj co najmniej 1 argument");
            return;
        }
            
        Calc calc = new Calc(WczytajPlik(args[0]));
        
        System.out.println("Indeks : "+calc.ObliczIndeks());
    }
    
}
