import java.util.*;
import java.io.*;
import static java.lang.Integer.parseInt;

/**
 * class to read in fractions from a text file and determine how often they repeat through duplicates or equivalence.
 */
public class fractionsV1
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner readIn = null;
        //create 2d array to store fractions, row one is numerator and row two is denominator
        int[][] fractions = new int[2][1];
        
        try {
            readIn = new Scanner(new FileInputStream("fractions.txt"));
            while(readIn.hasNextLine()) {
                String[] holder = readIn.nextLine().split("/");
                int num = parseInt(holder[0]);
                int den = parseInt(holder[1]);

                //fill each array column with the fraction (row 0 is numerator, row 1 is the denominator)
                for(int i = 0; i < fractions[0].length; i++)
                {
                    if(fractions[0][i] == 0 && fractions[1][i] == 0) {
                        fractions[0][i] = num;
                        fractions[1][i] = den;
                    }
                }

                //grow the array as needed
                if(readIn.hasNextLine()) {
                    int[][] temp = new int[2][fractions[0].length + 1];
                    for (int i = 0; i < fractions[0].length; i++) {
                        temp[0][i] = fractions[0][i];
                        temp[1][i] = fractions[1][i];
                    }
                    fractions = temp;
                }
            }
        }
        catch (Exception e) {
            System.out.println("file not found");
            System.exit(0);
        }

        //use calculate method to scan through array of fractions to look for equivalent fractions and count them
        int count = 0;
        for(int i = 0; i < fractions[0].length; i++)
        {
            count = 0;
            for(int j = 0; j < fractions[0].length; j++)
            {
                if(calculate(fractions[0][i], fractions[1][i], fractions[0][j], fractions[1][j]))
                {
                    //make sure the fraction compared against itself is not counted.
                    if((fractions[0][i] == fractions[0][j]) && (fractions[1][i] == fractions[1][j]))
                    {

                    }
                    else
                    {
                        count++;
                    }
                }
            }
            System.out.println(fractions[0][i] + "/" + fractions[1][i] + " has a count of: " + count);
        }
    }

    /**method to calculate if the fractions are equivalent
     *
     * @param num1
     * @param den1
     * @param num2
     * @param den2
     * @return
     */
    public static boolean calculate(int num1, int den1, int num2, int den2)
    {
        if((num1 * den2) == (num2 * den1))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
