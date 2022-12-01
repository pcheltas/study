package spaceObjects;

public class Satellite extends SpaceObject {
    private static int number=0;
    private int current;
    public Satellite (String name){
        super(name);
        number++;
        current=number;
    }

    @Override
    public void pullToCentre(String name) {
        System.out.println(getName() + " притягивает все с меньшей силой");
        setForce("сильная");
    }

    @Override
    public String toString(){
        return ("Имя:" + getName() + "; обладает силой: " + getForce());}

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
        return this.current == ((Satellite) obj).current;
    }
}
