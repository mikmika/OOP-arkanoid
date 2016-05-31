

import java.io.IOException;

/**
 * Exception representing that something went wrong
 * during the serialization process
 */
public class SerializationException extends IOException {

    public SerializationException() {
    }

    public SerializationException(String message) {
        super(message);
    }

    public SerializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializationException(Throwable cause) {
        super(cause);
    }
}