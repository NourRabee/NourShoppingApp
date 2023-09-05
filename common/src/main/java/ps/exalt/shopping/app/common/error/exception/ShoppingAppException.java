package ps.exalt.shopping.app.common.error.exception;

public class ShoppingAppException extends Exception {

    private String sourceClass = null;
    private String sourceMethod = null;
    private String key = null;
    private Object[] arguments = null;

    public ShoppingAppException(String message) {
        super(message);
    }

    public ShoppingAppException(String Message, String Key) {
        this(Message);

        key = Key;
    }


    public ShoppingAppException(String Message, String Key, Object... Args) {
        this(Message, Key);
        arguments = Args;
    }


    public ShoppingAppException(String Message, String Key, Throwable Cause, Object... Args) {
        super(Message, Cause);

        arguments = Args;
        key = Key;
    }


    public final String getSourceMethodName() {
        if (sourceMethod == null) {
            sourceMethod = getStackTrace()[0].getMethodName();
        }
        return sourceMethod;
    }


    public String getKey() {
        return key;
    }

    public Object[] getArguments() {
        return arguments;
    }
}
