/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michal
 */
public class Main
{
    private static int[] v = new int[100];
    private static int n;
    private static int cnt;
    private static char []str;
    //private static String str;
    
    public static void main(String[] args)
    {
        str = "1234567".toCharArray();

        //n = strlen(str);
        n = str.length;
        bkt(1);

        System.out.printf("%d \n", --cnt);
    }

    static void init(int k)
    {
        v[k] = -1;
    }

    static boolean solutionReached( int k ) 
    {
        if (k == n + 1)
            return true;
        return false;
    }

    static void printSolution( int k ) 
    {
        for (int i = 1; i < k; i++)
        {
            System.out.printf("%c ", str[v[i]]);
        }

        System.out.printf("\n");

        cnt++;
    }

    static boolean hasSuccesor( int k ) 
    {
        if(v[k] < n - 1)
        {
            v[k]++;
            return true;
        }
        return false;
    }

    static boolean isValid( int k ) 
    {
        for (int i = 1; i < k; i++)
        {
            if (v[i] == v[k])
            {
                return false;
            }
        }

        if (k == n)
        {
            //char *cuv = (char *) malloc(n * sizeof(char));
            char []cuv = new char[n];

            for (int i = 0; i < n; i++)
                cuv[i] = str[v[i + 1]];

            if (cuv.toString().compareTo(str.toString())> 0)
            {
                return true;
            }
            else
                return false;
        }

        return true;
    }

    static void bkt(int k)
    {
        if(solutionReached(k))
            printSolution(k);
        else
        {
            init(k);
            while(hasSuccesor(k))
                if(isValid(k))
                    bkt(k + 1);
        }
    }
}
