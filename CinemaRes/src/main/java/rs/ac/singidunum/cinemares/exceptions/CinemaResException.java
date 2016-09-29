package rs.ac.singidunum.cinemares.exceptions;

import java.util.Arrays;
import java.util.List;

public class CinemaResException extends Exception {

    private final List<String> errorMessages;

    public CinemaResException(List<String> errorMessages) {
        super();
        this.errorMessages = errorMessages;
    }

    public CinemaResException(String errorMessage) {
        super(errorMessage);
        this.errorMessages = Arrays.asList(errorMessage);
    }

    public CinemaResException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorMessages = Arrays.asList(errorMessage);
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
    
   

    
}
