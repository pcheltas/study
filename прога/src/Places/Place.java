package places;

public class Place {
    private PlacesTypes name;

    public PlacesTypes getName() {
        return name;
    }

    public Place (PlacesTypes name){
        this.name=name;
    }

    public void takePlace(){
        if (getName() == PlacesTypes.пирамида){
            System.out.println("Цель пути: пирамида");
        }
        else{
            System.out.println("Текущее местоположение: дорога");
        }
    }

    @Override
    public String toString() {
        return "локация " + getName();
    }





}

