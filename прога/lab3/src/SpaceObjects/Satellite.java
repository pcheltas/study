package spaceObjects;

import things.Stufff;

public class Satellite extends SpaceObject {

    public Satellite(String name) {
        super(name);
    }

    @Override
    public void createConditions() {
        System.out.println(getName() + " создает нормальные условия");
    }

    @Override
    public void influence(Stufff stuff){
        System.out.println(getName() + "не влияет на" + stuff.getName());
    }
    @Override
    public void pullToCentre(String name) {
        System.out.println(getName() + " притягивает все с меньшей силой");
        setForce("сильная");
    }

    @Override
    public String toString() {
        return ("Имя:" + getName() + "; обладает силой: " + getForce());
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
        return this.getName() == ((Satellite) obj).getName() && this.getWeather() == ((Satellite) obj).getWeather()
                && this.getForce() == ((Satellite) obj).getForce();
    }
}
