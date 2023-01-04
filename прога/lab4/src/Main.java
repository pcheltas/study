import body.*;
import people.*;
import places.*;
import spaceObjects.*;
import things.*;

public class Main {
    public static void main(String[] args) {
        Satellite moon = new Satellite("Луна");
        SpaceObject sun = new Star("Солнце");
        Person neznaika = new Person("Незнайка", Bodykit.STURDY);
        Person ponchik = new Person("Пончик", Bodykit.FAT);

        Person.Clothes boots = neznaika.new Clothes(things.Clothes.BOOTS) {
            public void wear() {
                System.out.println(neznaika.getName() + " ощущет будто вот-вот выскользнет из сапог и потому туже натягивает их");
            }
        };

        Parts brain = new Parts(TypeOfParts.BRAIN);
        Parts vessels = new Parts(TypeOfParts.VESSELS);
        moon.pullToCentre(moon.getName());
        moon.beTurned();
        boots.wear();
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
        Place.Aim aim = new Place.Aim(PlacesTypes.PYRAMID);
        Place.Current current = new Place.Current(PlacesTypes.ROAD);

        current.takePlace();
        neznaika.moveTo();
        ponchik.moveTo();
        aim.takePlace();
        moon.distortImage(aim.getName());


        Stufff umbrella = Stufff.UMBRELLA;
        Person.Clothes neznikassuit = neznaika.new Clothes(things.Clothes.SUIT);
        Person.Clothes ponchikssuit = ponchik.new Clothes(things.Clothes.SUIT);

        sun.createConditions();
        try {
            if ("испепеляет".equals(sun.getWeather())) {
                sun.influence(neznikassuit.getElement().getName());
                sun.influence(ponchikssuit.getElement().getName());
                neznaika.notToUse(umbrella);
                neznaika.suffer();
                ponchik.notToUse(umbrella);
                ponchik.suffer();

            } else {
                throw new WrongPlanet("Солнце не греет");
            }
        } catch (WrongPlanet err){
            System.out.println("Либо Солнце исчезло либо все умерли");
        }
    }
}