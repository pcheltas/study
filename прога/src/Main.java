import people.*;
import places.Place;
import places.PlacesTypes;
import spaceObjects.*;
import things.Stuff;

public class Main {
    public static void main(String[] args) {
        Satellite Moon = new Satellite("Луна");
        Star Sun = new Star("Солнце");
        Person Neznaika = new Person("Незнайка", Bodykit.STURDY);
        Person Ponchik = new Person("Пончик", Bodykit.FAT);
        Moon.pullToCentre();
        if (Moon.getForce().equals("сильная")){
            Neznaika.feel();
            Ponchik.feel();
        }
        Place aim = new Place(PlacesTypes.пирамида);
        Place current = new Place (PlacesTypes.дорога);

        current.takePlace();
        Neznaika.walk("час");
        Ponchik.walk("час");
        aim.takePlace();
        Moon.distortImage(aim);

        Stuff umbrella = new Stuff("космические зонтики");
        Stuff suit = new Stuff ("скафандры");
        Sun.warm(suit.getName());
        if ("испепеляет".equals(Sun.getWeather())){
            Sun.stealAir();
            Neznaika.notToUse(umbrella);
            Neznaika.suffer();
            Ponchik.notToUse(umbrella);
            Ponchik.suffer();

        }





    }
}