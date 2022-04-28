/**
 * @author luke
 * Class: CSS 143
 * HW: Recursion
 */

/**
 * A class to perform binary searches either iteratively or recursively
 */

public class BinarySearch extends SearchAlgorithm {


    /**
     * default no arg constructor
     */
    public BinarySearch()
    {
    }

    /**
     * Implements interactive binary search algorithm
     * @param words
     * @param wordToFind
     * @return
     * @throws ItemNotFoundException
     */
    public int iterativeSearch(String[] words, String wordToFind) throws ItemNotFoundException
    {
        resetCount();
        int start = 0;
        int end = words.length - 1;
        while (end >= start)
        {
            incrementCount();
            int mid = (start + end) / 2;
            if (wordToFind.equals(words[mid]))
            {
                return mid;
            }
            if (wordToFind.compareTo(words[mid]) < 0)
            {
                end = mid - 1;
            } else
            {
                start = mid + 1;
            }
        }
        throw new ItemNotFoundException();
    }


    /**
     * Inherited method, sets start point and end point, then calls recursive search method
     * @param words
     * @param wordToFind
     * @return
     * @throws ItemNotFoundException
     */
    public int recursiveSearch(String[] words, String wordToFind) throws ItemNotFoundException
    {
        int start = 0;
        int end = words.length - 1;

        resetCount();
        return Search(words, wordToFind, start, end);
    }

    /**
     * Implementing recursive binary search through String array
     * @param words
     * @param wordToFind
     * @param start
     * @param end
     * @return
     * @throws ItemNotFoundException
     */
    private int Search(String[] words, String wordToFind, int start, int end) throws ItemNotFoundException
    {
        int mid = (start + end) / 2;
        incrementCount();

        if (end < start) //item not found base case
            throw new ItemNotFoundException();
        if (wordToFind.equals(words[mid])) //base case
        {
            return mid;
        }
        if (wordToFind.compareTo(words[mid]) < 0) //if target is less than mid
        {
            return Search(words, wordToFind, start, mid - 1);
        }
        if (wordToFind.compareTo(words[mid]) > 0) //if target is greater than mid
        {
            return Search(words, wordToFind, mid + 1, end);
        }
        return -1; //just because I have to have a return statement to make compiler :)
    }


}
