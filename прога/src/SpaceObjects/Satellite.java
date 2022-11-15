package SpaceObjects;

import Inters.ActSat;
import Places.*;

public class Satellite extends SpaceObject implements ActSat {


    private String Force;

    public String getForce() {
        return Force;
    }

    public Satellite(String name){
        super(name);
    }

    public void pullToCentre() {
        System.out.println(getName() + " притягивает все с меньшей силой");
        Force = "сильная";
    }

    public void distortImage(Place p){
        System.out.println ( p.getName() + " видится четко и поэтому кажется ближе");
    }
}
