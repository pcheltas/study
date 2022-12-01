import body.*;
import people.*;
import places.Place;
import places.PlacesTypes;
import spaceObjects.*;
import things.Stufff;

public class Main {
    public static void main(String[] args) {
        Satellite Moon = new Satellite("Луна");
        Star Sun = new Star("Солнце");
        Person Neznaika = new Person("Незнайка", Bodykit.STURDY);
        Person Ponchik = new Person("Пончик", Bodykit.FAT);
        Moon.pullToCentre(Moon.getName());
        Parts brain = new Parts(TypeOfParts.BRAIN);
        Parts vessels = new Parts(TypeOfParts.VESSELS);
        Parts vessels2 = new Parts(TypeOfParts.VESSELS);
        brain.isPart();
        brain.feel();
        vessels.isPart();
        vessels.feel();


        System.out.println();
        if ("сильная".equals(Moon.getForce())){
            Neznaika.feel();
            Ponchik.feel();
        }
        System.out.println();
        Place aim = new Place(PlacesTypes.PYRAMID);
        Place current = new Place (PlacesTypes.ROAD);

        current.takePlace();
        Neznaika.moveTo();
        Ponchik.moveTo();
        aim.takePlace();
        Moon.distortImage(aim.toString());


        Stufff umbrella = Stufff.UMBRELLA;
        Stufff suit = Stufff.SUIT;

        Sun.warm(suit);
        if ("испепеляет".equals(Sun.getWeather())){
            Sun.stealAir();
            Neznaika.notToUse(umbrella);
            Neznaika.suffer();
            Ponchik.notToUse(umbrella);
            Ponchik.suffer();

        }


    }
}