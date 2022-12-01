package spaceObjects;

abstract class SpaceObject {
    private String name;
    private String Force="нормальная";

    public void setForce(String force) {
        Force = force;
    }

    public String getForce() {
        return Force;
    }

    public String getName() {
        return name;
    }

    public SpaceObject(String name){
        this.name=name;
    }

    public void pullToCentre(String name){
        System.out.println(getName() + "притягивает все с меньшей силой");
    };
    public void distortImage(String p){
        System.out.println ( p + " видится четко и поэтому кажется ближе");
    }
}
