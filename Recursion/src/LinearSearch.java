/**
 * @author luke
 * Class: CSS 143
 * HW: Recursion
 */

/**
 * A program to search through a string array linearly
 */

public class LinearSearch extends SearchAlgorithm {

    public LinearSearch()
    {
    }

    /**
     * Searches through the array iteratively
     * @param words
     * @param wordToFind
     * @return
     * @throws ItemNotFoundException
     */
    public int iterativeSearch(String[] words, String wordToFind) throws ItemNotFoundException
    {
        resetCount();
        for (int i = 0; i < words.length; i++)
        {
            incrementCount();
            if (wordToFind.equals(words[i]))
            {
                return i;
            }
        }
        throw new ItemNotFoundException();
    }

    /**
     * Searches through the array recursively.
     * This causes a StackOverFlowError, it has something to do with how far down in the list the target is.
     * for example this works for words that start with A, but around G it starts to overflow the Stack.
     * @param words
     * @param wordToFind
     * @return
     * @throws ItemNotFoundException
     */
    public int recursiveSearch(String[] words, String wordToFind) throws ItemNotFoundException
    {
        incrementCount();

        if (getCount() - 2 > words.length)
            throw new ItemNotFoundException();
        if (wordToFind.equals(words[getCount() - 1]))
        {
            return getCount() - 1;
        } else
            return recursiveSearch(words, wordToFind); //this line causes StackOverFlow error
    }
}
