import People.*;
import Places.Place;
import Places.PlacesTypes;
import SpaceObjects.*;
import Things.Stuff;

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
        Sun.warm();
        if (Sun.getWeather().equals("испепеляет")){
            Sun.stealAir();
            Neznaika.notToUse(umbrella.getName());
            Neznaika.suffer();
            Ponchik.notToUse(umbrella.getName());
            Ponchik.suffer();

        }





    }
}