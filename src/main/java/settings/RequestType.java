package settings;

import settings.exceptions.InvalidRequestTypeException;

public enum RequestType {
    IMAGE("image"),
    VIDEO("video");

    private String settingRepresentation;

    RequestType(String settingRepresentation) {
        this.settingRepresentation = settingRepresentation;
    }

    public static RequestType createFromSettings(String request) throws InvalidRequestTypeException {
        switch (request) {

            case "image":
                return IMAGE;

            case "video":
                return VIDEO;

            default:
                throw new InvalidRequestTypeException(request);

        }
    }

}
