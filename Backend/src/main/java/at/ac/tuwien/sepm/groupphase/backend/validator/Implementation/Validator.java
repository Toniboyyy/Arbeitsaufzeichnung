package at.ac.tuwien.sepm.groupphase.backend.validator.Implementation;

public interface Validator<E> {
    /**
     * @param Object to be validated
     * @return if valid true is returned else ValidationException
     */
    boolean validate(E Object);
}
