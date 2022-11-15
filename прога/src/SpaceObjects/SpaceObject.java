package SpaceObjects;

abstract class SpaceObject {
    private String name;

    public String getName() {
        return name;
    }

    public SpaceObject(String name){
        this.name=name;
    }
}
