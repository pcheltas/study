package spaceObjects;

import things.Stufff;

public class Star extends SpaceObject{
    private static int number=0;
    private int current;

    private String weather = "нормальная";

    public String getWeather() {
        return weather;
    }

    public Star(String name){
        super(name);
        number++;
        current=number;
    }

    public void warm(Stufff stuff){
        weather="испепеляет";
        System.out.println(getName() + " сильно припекает и нагревает " + stuff.getName());
    }

    public void stealAir(){
        System.out.println(getName() + " создает жуткую духоту");
    }

    @Override
    public String toString() {
        return ("Имя:" + getName() + "; погода: " + getWeather());
    }

    @Override
    public int hashCode() {
        return super.hashCode() + getName().hashCode() + current;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj){
            return true;
        }
        return this.current == ((Star) obj).current;
    }


}
