package places;

public class Place {
    private static int number=0;
    private int current;
    private PlacesTypes name;

    public PlacesTypes getName() {
        return name;
    }

    public Place (PlacesTypes name){
        number++;
        current=number;
        this.name=name;
    }


    public void takePlace(){
        if (getName() == PlacesTypes.PYRAMID){
            System.out.println("Цель пути: " + PlacesTypes.PYRAMID.getName());
        }
        else{
            System.out.println("Текущее местоположение: " + PlacesTypes.ROAD.getName());
        }
    }

    @Override
    public String toString() {
        return "локация " + getName().getName();
    }

    @Override
    public int hashCode() {
        return name.hashCode() + current;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj){
            return true;
        }
        return this.current==((Place) obj).current;
    }
}

