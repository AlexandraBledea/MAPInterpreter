package exceptions;

public class InvalidIndexException extends Exception {

    public InvalidIndexException(){super("Invalid index!");}

    public InvalidIndexException(String message){super(message);}
}
