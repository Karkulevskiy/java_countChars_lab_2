package FileCharCounter;

/*
* Custom exception for cases,
*  when User wrote null or empty paths to file
* */
public class WrongPathException extends Exception{
    public WrongPathException(String message)
    {
        super(message);
    }
}
