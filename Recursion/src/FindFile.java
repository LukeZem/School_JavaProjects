import java.io.File;
import java.util.ArrayList;

/**
 * @author luke
 * Class: CSS 143
 * HW: Recursion
 */

/**
 * Class to search through a directory recursively for a file
 */

public class FindFile {

    private ArrayList<String> filePaths = new ArrayList<>();
    private int fileCount = 0;
    private String path = "";

    /**
     * default no arg constructor
     */
    public FindFile()
    {

    }

    /**
     * Method implements a recursive search through a directory for a given file name
     * @param target
     * @param dirName
     */
    public void directorySearch(String target, String dirName)
    {
        if(path.equals(""))
            path = dirName;
        File f = new File(dirName);
        if (!f.exists() || !f.isDirectory()) //testing to see if given path is valid
        {
            throw new IllegalArgumentException("Invalid argument");
        }
        String[] files = f.list();
        for (String file : files)
        {
            File temp = new File(path + "/" + file);
            if (temp.isDirectory())
            {
                directorySearch(target, path + "/" + file);
            }
            else if (!temp.isDirectory())
            {
                if (target.equals(file))
                {
                    filePaths.add(dirName + "/" + file);
                    fileCount++;
                }
            }
        }

    }


    /**
     * gets count
     * @return
     */
    public int getCount()
    {
        return fileCount;
    }

    /**
     * gets filePath ArrayList
     * @return
     */
    public ArrayList<String> getFiles()
    {
        return filePaths;
    }
}
