package colorscheme.data;

public enum ColorSchemeDataTypes {

    GREY_SCALE("grey_scale_data");

    private String identifier;

    ColorSchemeDataTypes(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

}
