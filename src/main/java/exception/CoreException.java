package exception;

public class CoreException extends Exception {

    private String identifier;

    public CoreException(String message, String identifier) {

        super(message);

        this.identifier = identifier;

    }

    public String getIdentifier() {
        return identifier;
    }
}
