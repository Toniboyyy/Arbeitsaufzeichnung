package at.ac.tuwien.sepm.groupphase.backend.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String error) {
        super(error);
    }
}
