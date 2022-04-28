import java.io.*;

public class test {

    public static void main(String[] args)
    {
//        String target = "ZYGOMORPHY";
//        String mid = "Hey";
//        System.out.println(target.compareTo(mid));

        String [] A = {"ABACTERIAL", "ABOLITIONISMS", "EXPECTORATING", "GROUNDWORK", "HANDKERCHIEF", "INFRASPECIFIC", "KERSEYMERES", "PATHOBIOLOGIES", "PERPLEXITIES"};
        String [] B = {"ABACTERIAL", "ABOLITIONISMS", "EXPECTORATING", "GROUNDWORK", "HANDKERCHIEF", "INFRASPECIFIC", "KERSEYMERES", "PATHOBIOLOGIES", "PERPLEXITIES", "ZEMLIN"};

        int start = 0;
        int aEnd = A.length - 1;
        int bEnd =  B.length - 1;
        int aMid = (start + aEnd) / 2;
        int bMid = (start + bEnd) / 2;

        String [] aTest = splitArray(A, start, aMid - 1);
        for (int i = 0; i < aTest.length; i++)
            System.out.println(aTest[i]);


//        String [] bTest = splitArray(B, start, mid - 1)
    }


    private static String[] splitArray(String [] words, int start, int end)
    {
        if(start == 0)
        {
            String [] bottom = new String[end + 1];
            for (int i = 0; i < bottom.length; i++)
            {
                bottom[i] = words[i];
            }
            return bottom;
        }else
        {
            String [] top = new String[(end - start) + 1];
            for (int i = 0; i < top.length; i++)
            {
                top[i] = words[start++];
            }
            return top;
        }
    }
}
