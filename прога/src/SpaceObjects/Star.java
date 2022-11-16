package spaceObjects;

import inters.ActStar;

public class Star extends SpaceObject implements ActStar {

    private String weather;

    public String getWeather() {
        return weather;
    }

    public Star(String name){
        super(name);
    }
    public void warm(String stuff){
        weather="испепеляет";
        System.out.println(getName() + " сильно припекает и нагревает " + stuff);
    }

    public void stealAir(){
        System.out.println(getName() + " создает жуткую духоту");
    }

    @Override
    public String toString() {
        return ("Имя:" + getName() + "; погода: " + getWeather());
    }
}
