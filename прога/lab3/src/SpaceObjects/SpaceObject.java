package spaceObjects;

import things.Stufff;

public abstract class SpaceObject {
    private String name;
    private String force = "нормальная";
    private String weather = "нормальная";

    public SpaceObject(String name) {
        this.name = name;
    }

    public String getForce() {
        return force;
    }

    public void setForce(String force) {
        this.force = force;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getName() {
        return name;
    }

    public abstract void createConditions();

    public abstract void influence(Stufff stuff);

    public void pullToCentre(String name) {
        System.out.println(this.name + "притягивает все с меньшей силой");
    }


    public void distortImage(String p) {
        System.out.println(p + " видится четко и поэтому кажется ближе");
    }

    @Override
    public String toString() {
        return ("Космический объект:" + this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.force.hashCode() + this.weather.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.name == ((SpaceObject) obj).name && this.force == ((SpaceObject) obj).force && this.weather ==
                ((SpaceObject) obj).weather;
    }
}
