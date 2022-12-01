package places;

public enum PlacesTypes {

    PYRAMID("пирамида"),
    ROAD("дорога");
    private String name;
    PlacesTypes(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
