import FileCharCounter.FileCharCounter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Creating object of FileCharCounter
        var charCounter = new FileCharCounter();
        //Start calculating
        charCounter.calculateCharsInFile();
    }
}