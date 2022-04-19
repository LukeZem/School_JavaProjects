import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class test {

    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.addFirst("zero");


        System.out.println(list);

        ArrayList<Object> A_list = new ArrayList<>(list);

        System.out.println(A_list);
    }
}
