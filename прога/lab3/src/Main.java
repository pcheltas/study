import body.*;
import people.*;
import places.Place;
import places.PlacesTypes;
import spaceObjects.*;
import things.Stufff;

public class Main {
    public static void main(String[] args) {
        SpaceObject moon = new Satellite("Луна");
        SpaceObject sun = new Star("Солнце");
        Person neznaika = new Person("Незнайка", Bodykit.STURDY);
        Person ponchik = new Person("Пончик", Bodykit.FAT);
        Person neznaika2 = new Person("Незнайкаa", Bodykit.STURDY);
        moon.pullToCentre(moon.getName());
        Parts brain = new Parts(TypeOfParts.BRAIN);
        Parts vessels = new Parts(TypeOfParts.VESSELS);
        brain.isAPart();
        brain.feel();
        vessels.isAPart();
        vessels.feel();


        System.out.println();
        if ("сильная".equals(moon.getForce())) {
            neznaika.feel();
            ponchik.feel();
        }
        System.out.println();
        Place aim = new Place(PlacesTypes.PYRAMID);
        Place current = new Place(PlacesTypes.ROAD);

        current.takePlace();
        neznaika.moveTo();
        ponchik.moveTo();
        aim.takePlace();
        moon.distortImage(aim.getPlacetype().getName());


        Stufff umbrella = Stufff.UMBRELLA;
        Stufff suit = Stufff.SUIT;

        sun.createConditions();
        if ("испепеляет".equals(sun.getWeather())) {
            sun.influence(suit);
            neznaika.notToUse(umbrella);
            neznaika.suffer();
            ponchik.notToUse(umbrella);
            ponchik.suffer();

        }
    }
}