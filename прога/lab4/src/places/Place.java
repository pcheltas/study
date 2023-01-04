package places;

public class Place {

    private static PlacesTypes placetype;

    public Place(PlacesTypes name) {
        this.placetype = name;
    }



    @Override
    public String toString() {
        return "Локация: " + this.placetype.getName();
    }

    public static class Aim {
        private String name;

        public String getName() {
           return name;
        }

        public Aim(PlacesTypes placetype) {
            Place.placetype = placetype;
            name = Place.placetype.getName();
        }
        public void takePlace() {
            System.out.println("Цель пути " + placetype.getName());
        }
    }

    public static class Current {
        private String name;

        public String getName() {
            return name;
        }

        public Current(PlacesTypes placetype) {
            Place.placetype = placetype;
            name = Place.placetype.getName();
        }

        public void takePlace() {
            System.out.println("Текущее метоположение " + placetype.getName());
        }
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

