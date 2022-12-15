package places;

public class Place {

    private PlacesTypes placetype;

    public PlacesTypes getPlacetype() {
        return placetype;
    }

    public Place(PlacesTypes name) {
        this.placetype = name;
    }


//    public void takePlace() {
//        if (getPlacetype() == PlacesTypes.PYRAMID) {
//            System.out.println("Цель пути: " + PlacesTypes.PYRAMID.getName());
//        } else {
//            System.out.println("Текущее местоположение: " + PlacesTypes.ROAD.getName());
//        }
//    }

//    public void takePlace() {
//        switch (placetype){
//            case ROAD:
//                System.out.println("Цель пути: " + PlacesTypes.PYRAMID.getName());
//            case PYRAMID:
//                System.out.println("Текущее местоположение: " + PlacesTypes.ROAD.getName());
//        }
//    }

    public void takePlace(){
        System.out.println(this.placetype.getDescription() + this.placetype.getName());

    }

    @Override
    public String toString() {
        return "Локация: " + this.placetype.getName();
    }

    @Override
    public int hashCode() {
        return this.placetype.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.placetype == ((Place) obj).placetype;
    }
}

