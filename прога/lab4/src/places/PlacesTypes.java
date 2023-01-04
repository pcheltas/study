package places;

public enum PlacesTypes {

    PYRAMID("Пирамида"),
    ROAD("Дорога");
    private String name;
    private String description;

    PlacesTypes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
