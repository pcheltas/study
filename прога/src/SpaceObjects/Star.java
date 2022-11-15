package SpaceObjects;

import Inters.ActStar;

public class Star extends SpaceObject implements ActStar {

    private String weather;
    

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeather() {
        return weather;
    }

    public Star(String name){
        super(name);
    }
    public void warm(){
        setWeather("испепеляет");
        System.out.println(getName() + " сильно припекает");
    }

    public void stealAir(){
        System.out.println(getName() + " создает жуткую духоту");
    }

    @Override
    public String toString() {
        return ("Имя:" + getName() + "; погода: " + weather);
    }
}
