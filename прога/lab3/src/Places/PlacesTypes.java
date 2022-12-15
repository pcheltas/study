package places;

public enum PlacesTypes {

    PYRAMID("Пирамида", "Цель пути: "),
    ROAD("Дорога", "Текущее местоположение: ");
    private String name;
    private String description;

    PlacesTypes(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
