package People;


import Inters.Actions;
import Inters.Feelings;

public class Person implements Actions, Feelings {
    private String name;
    private Bodykit body;
    public String getName() {
        return name;
    }



    public Person(String name, Bodykit body){
        this.name=name;
        this.body=body;
    }

    public void walk(String time) {
        System.out.println(getName() + " идет на протяжении времени: " + time );
    }

    public void feel() {
        if (body==Bodykit.FAT){
            System.out.println(getName() + " испытывает страх из-за чувства зависания вниз головой");
        }
        else{
            System.out.println(getName() + " не испытывает дискомфорта благодаря своей комплекции");
        }
    }

    public void notToUse (String stuff) {
            System.out.println(getName() + " не смог сообразить что можно использовать " + stuff);
    }

    public void suffer(){
        System.out.println(getName() + " изнывает от жары");
    }

    @Override
    public String toString(){
        return ("Имя:" + name + "; телосложение: " + body);
    }




}
