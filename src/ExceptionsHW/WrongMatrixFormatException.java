package ExceptionsHW;

import java.io.IOException;

public class WrongMatrixFormatException extends Exception {

    public WrongMatrixFormatException(String message) {
        super(message);
    }

}
