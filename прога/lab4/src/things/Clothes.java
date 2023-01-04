package things;


public enum Clothes {
    SUIT("скафандры"),

    BOOTS ("сапоги");

    private String name;


    Clothes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
