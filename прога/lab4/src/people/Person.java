package people;

import inters.ActionsBased;
import inters.FeelingsFromGravity;
import inters.FeelingsFromWeather;
import things.Stufff;

public class Person implements ActionsBased, FeelingsFromGravity, FeelingsFromWeather {
    private final String name;
    private final Bodykit body;

    public class Clothes {
        private things.Clothes element;

        public things.Clothes getElement() {
            return element;
        }

        public Clothes(things.Clothes name){
            this.element = name;
        }
        public void wear(){
            System.out.println("На " + Person.this.getName() + " надето: " + element.getName());
        }
    }

    public String getName() {
        return name;
    }

    public Person(String name, Bodykit body) {
        this.name = name;
        this.body = body;
    }

    public void notToUse(Stufff stuff) {
        System.out.println(name + " не использует " + stuff.getName());
    }

    @Override
    public void moveTo() {
        System.out.println(name + " идет");
    }

    @Override
    public void feel() {
        switch (body) {
            case FAT:
                System.out.println(this.name + ' ' + this.body.getName() + " и испытывает страх из-за чувства " +
                        "зависания вниз головой");
                break;
            case STURDY:
                System.out.println(this.name + ' ' + this.body.getName() + " и не испытывает дискомфорта");
                break;
        }
    }

    @Override
    public void suffer() {
        System.out.println(this.name + " изнывает от жары");
    }

    @Override
    public String toString() {
        return ("Имя:" + this.name + "; телосложение: " + body);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.body.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.name == ((Person) obj).name && this.body == ((Person) obj).body;
    }

}
