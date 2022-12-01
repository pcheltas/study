package people;



import body.Parts;
import inters.ActionsBased;
import inters.FeelingsFromGravity;
import inters.FeelingsFromWeather;
import things.Stufff;

public class Person implements  ActionsBased, FeelingsFromGravity, FeelingsFromWeather {
    private static int number=0;
    private int current;
    private String name;
    private Bodykit body;

    public String getName() {
        return name;
    }

    public Bodykit getBody() {
        return body;
    }

    public Person(String name, Bodykit body){
        number++;
        current=number;
        this.name=name;
        this.body=body;
    }

    public void notToUse (Stufff stuff) {
        System.out.println(getName() + " не использует " + stuff.getName());
    }

    @Override
    public void moveTo() {
        System.out.println(getName() + " идет");
    }
    @Override
    public void feel() {
        switch (body){
            case FAT:
                System.out.println(getName() + ' ' + Bodykit.FAT.getName() + " и испытывает страх из-за чувства зависания вниз головой");
                break;
            case STURDY:
                System.out.println(getName() + ' ' + Bodykit.STURDY.getName() + " и не испытывает дискомфорта");
                break;
            }
        }

    @Override
    public void suffer(){
        System.out.println(getName() + " изнывает от жары");
    }

    @Override
    public String toString(){
        return ("Имя:" + getName() + "; телосложение: " + getBody());
    }

    @Override
    public int hashCode() {
        return name.hashCode() + body.hashCode() + current;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj){
            return true;
        }
        return this.current == ((Person)obj).current;
    }

}
