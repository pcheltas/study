package things;

public enum Stufff {
    UMBRELLA("космический зонтик"),
    SUIT("скафандры");
    private String name;

    Stufff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
