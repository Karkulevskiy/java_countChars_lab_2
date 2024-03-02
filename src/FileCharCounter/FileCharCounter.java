package FileCharCounter;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

// Class for counting chars [a-z, A-Z] in file
public class FileCharCounter {
    //Filled dictionary with keys for counting
    private HashMap<Character, Long> _map
            = new HashMap<>()
    {
        {
            put('a', 0L);          put('A', 0L);          put('b', 0L);
            put('B', 0L);          put('c', 0L);          put('C', 0L);
            put('d', 0L);          put('D', 0L);          put('e', 0L);
            put('E', 0L);          put('f', 0L);          put('F', 0L);
            put('g', 0L);          put('G', 0L);          put('h', 0L);
            put('H', 0L);          put('i', 0L);          put('I', 0L);
            put('j', 0L);          put('J', 0L);          put('k', 0L);
            put('K', 0L);          put('l', 0L);          put('L', 0L);
            put('m', 0L);          put('M', 0L);          put('n', 0L);
            put('N', 0L);          put('o', 0L);          put('O', 0L);
            put('p', 0L);          put('P', 0L);          put('q', 0L);
            put('Q', 0L);          put('r', 0L);          put('R', 0L);
            put('s', 0L);          put('S', 0L);          put('t', 0L);
            put('T', 0L);          put('u', 0L);          put('U', 0L);
            put('v', 0L);          put('V', 0L);          put('w', 0L);
            put('W', 0L);          put('x', 0L);          put('X', 0L);
            put('y', 0L);          put('Y', 0L);          put('z', 0L);          put('Z', 0L);
        }
    };
    // Path to file for reading
    private String _pathToFileInput;
    // Path to file for writing
    private String _pathToFileOutput;

    // Method for asking user for paths to file
    private void askUserForPaths() throws WrongPathException
    {
        var scannerIn = new Scanner(System.in);
        System.out.println("Write path to file for reading: ");
        var pathToFileInput = scannerIn.nextLine();
        System.out.println("Write path to file for reading: ");
        var pathToFileOutput = scannerIn.nextLine();

        //Checking paths for null or empty
        if (pathToFileInput == null || pathToFileInput.trim().isEmpty()
            || pathToFileOutput == null || pathToFileOutput.trim().isEmpty())
        {
            //If file path is null or empty throw custom exception
            throw new WrongPathException("Path to file is null or empty");
        }

        //Set private fields with paths
        _pathToFileInput = pathToFileInput;
        _pathToFileOutput = pathToFileOutput;

    }
    public void calculateCharsInFile()
    {
        try{
            askUserForPaths();
            //Create reader using try-catch-resources
            try(var reader = new FileReader(_pathToFileInput))
            {
                int ch;
                //Reading while not EOF
                while((ch = reader.read()) != -1)
                {
                    //Checking every read char with boundaries
                    if ((ch >= 97 && ch <= 122) || (ch >= 65 && ch <= 90))
                        _map.replace((char)ch, _map.get((char)ch) + 1);
                }
            }
            // Create writer for writing
            try(var writer = new PrintWriter(_pathToFileOutput))
            {
                //Write in file calculated chars
                _map.forEach((key, value) -> writer.format("%c - %d\n", key, value));
            }
            System.out.println("Done successfully!");
        }
        //Catch exception if file not found
        catch (FileNotFoundException notFoundException)
        {
            System.out.println("File not found");
            System.out.println(notFoundException.getMessage());
        }
        //Catch exception if user write null or empty path or I/O exception
        catch (WrongPathException | IOException exception) {
            System.out.println(exception.getMessage());
        }
        finally {
            System.out.println("Try again?");
        }
    }
    //Basic constructor
    public FileCharCounter() { }
}
