package fractal.settings.exceptions;

public class ValidationException extends Exception {

    private String identifier;

    public ValidationException(String identifier, String message) {

        super(message);

        this.identifier = identifier;

    }

    public String getIdentifier() {
        return identifier;
    }
}
