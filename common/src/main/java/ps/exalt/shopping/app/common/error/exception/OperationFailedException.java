package ps.exalt.shopping.app.common.error.exception;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class OperationFailedException extends ShoppingAppException {

    protected static final String DETAILED_ERROR_MESSAGE_CODE_SUFFIX = "_DETAIL";
    private String extendedMessage = "";

    public OperationFailedException(String Message) {
        super(Message);
    }

    public OperationFailedException(String Message, Throwable Cause) {
        super(Message, null, Cause);
    }


    public OperationFailedException(String Message, String Key) {
        super(Message, Key);
    }

    public OperationFailedException(String Message, String Key, Object... ErrorArguments) {
        super(Message, Key, ErrorArguments);
    }

    public OperationFailedException() {
        super("");

    }

    public static OperationFailedException createDetailedOperationFailedException(String Message, String ExtendedMessage) {
        return new OperationFailedException(null, Message, ExtendedMessage, null, new Object[0]);
    }

    public static OperationFailedException createOperationFailedException(ResourceBundle ResourceBundle, String ErrorCode, Object... ErrorArguments) {
        return createOperationFailedException(null, ResourceBundle, ErrorCode, ErrorArguments);
    }

    public static OperationFailedException createOperationFailedException(Throwable Cause, ResourceBundle ResourceBundle, String ErrorCode, Object... ErrorArguments) {
        OperationFailedException lReturnException = null;
        if (ResourceBundle != null) {
            // Format Error message
            MessageFormat lFormat = new MessageFormat(ResourceBundle.getString(ErrorCode));
            String lErrorMessage = lFormat.format(ErrorArguments);

            // Fetch Detailed Error message
            String lDetailedErrorMessage = "";
            try {
                lFormat.applyPattern(ResourceBundle.getString(ErrorCode + DETAILED_ERROR_MESSAGE_CODE_SUFFIX));
                lDetailedErrorMessage = lFormat.format(ErrorArguments);
            } catch (MissingResourceException ignored) {
                // Ignore - detail error not specified
            }
            // Create Exception
            lReturnException = new OperationFailedException(Cause, lErrorMessage, lDetailedErrorMessage, ErrorCode, ErrorArguments);
        }

        return lReturnException;
    }

    protected OperationFailedException(Throwable Throwable, String Message, String ExtendedUIMessage, String Key, Object... Args) {
        super(Message, ExtendedUIMessage, Key, Throwable, Args);

        // Sets the extended message as an attribute in the exception root cause
        extendedMessage = ExtendedUIMessage;
    }

    public String getExtendedMessage() {
        return extendedMessage;
    }

    public void setExtendedMessage(String ExtendedMessage) {
        extendedMessage = ExtendedMessage;
    }
}
