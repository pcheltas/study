package spaceObjects;

import inters.ActSat;
import places.*;

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

    @Override
    public String toString(){
        return ("Имя:" + getName() + "; обладает силой: " + getForce());}
}
