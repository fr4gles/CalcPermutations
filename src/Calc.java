
import java.util.List;

/**
 * Klasa obliczająca
 * @author Michal
 */
public class Calc
{
    /**
     * lista przechowująca ciąg permutacji
     */
    private List<Integer> permutacje;

    /**
     * konstruktor
     * @param permutacje permutacje
     */
    Calc(List<Integer> permutacje)
    {
        this.permutacje = permutacje;
    }
    
    /**
     * Funkcja obliczająca indeks permutacji
     * sprytny sposób liczenia w opraciu opermutację i silnię
     * źródło: http://stackoverflow.com/questions/12146910/finding-the-lexicographic-index-of-a-permutation-of-a-given-array
     * @return indeks
     */
    public int ObliczIndeks() 
    {
        // wykorzystanie systemu pozycyjnjnego do obliczenia wartości indeksu
        // wzor na index = x1*(n-1)!+x2*[n-2]!+....xi*[0]!
        // obliczenia wykonywane są od końca
        int indeks = 1;
        
        int pozycja = 2; // pozycja 1 zawsze  = 0
        
        int silnia = 1;
        for (int i = permutacje.size() - 2; i >= 0; --i) 
        {
            // dla elementów permutacji obliczam licznik następników (x1...xi)
            int nastepny = 0;
            for (int j = i + 1; j < permutacje.size(); ++j) 
                if (permutacje.get(i) > permutacje.get(j)) 
                    nastepny++;
            
            // obliczenie indeksu 
            indeks += (nastepny * silnia);
            silnia *= pozycja++;
        }
        return indeks;
    }
}
