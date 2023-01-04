package spaceObjects;

import things.Stufff;

public class Star extends SpaceObject {


    public Star(String name) {
        super(name);
    }

    @Override
    public void createConditions() {
        setWeather("испепеляет");
        System.out.println(getName() + " сильно припекает и создает жуткую духоту");
    }

    @Override
    public void influence(String stuff){
            System.out.println(getName() + " сильно нагревает " + stuff);
    }

    @Override
    public String toString() {
        return ("Имя:" + getName() + "; погода: " + getWeather());
    }

    @Override
    public int hashCode() {
        return super.hashCode() + getName().hashCode() + getForce().hashCode() + getWeather().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.getName() == ((Star) obj).getName() && this.getWeather() == ((Star) obj).getWeather() &&
                this.getForce() == ((Star) obj).getForce();
    }


}
