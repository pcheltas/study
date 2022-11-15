package SpaceObjects;

import Inters.ActStar;

public class Star extends SpaceObject implements ActStar {

    private String Weather;
    

    public void setWeather(String Weather) {
        this.Weather = Weather;
    }

    public String getWeather() {
        return Weather;
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
}
