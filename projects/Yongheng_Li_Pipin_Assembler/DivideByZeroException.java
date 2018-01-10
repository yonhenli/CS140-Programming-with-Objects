package project;

public class DivideByZeroException extends RuntimeException {
    /**
     * No-argument constructor
     */
    public DivideByZeroException() {
        super();
    }
    /**
     * Preferred constructor that sets the inherited message field
     * of the exception object
     * @param arg0 message passed by the exception that was thrown
     */
    public DivideByZeroException(String arg0) {
        super(arg0);
    }
}
