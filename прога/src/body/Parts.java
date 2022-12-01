package body;


import inters.ActionsBased;
import inters.FeelingsFromGravity;
import inters.IsPart;

public class Parts implements IsPart, FeelingsFromGravity, ActionsBased {
    private static int number=0;
    private int current;
    private TypeOfParts name;

    public TypeOfParts getName() {
        return name;
    }

    public Parts(TypeOfParts name){
        number++;
        current=number;
        this.name=name;
    }
    @Override
    public void isPart(){
        if ((getName().equals(TypeOfParts.BRAIN)) || (getName().equals(TypeOfParts.VESSELS)) || (getName().equals(TypeOfParts.BLOOD))){
            System.out.println(getName().getName() + " является частью системы внутренних органов");
        }
        else if ((getName().equals(TypeOfParts.LEGS))){
            System.out.println(getName().getName() + " является внешним органом");
        }
    }
    @Override
    public void feel(){
        if ((getName().equals(TypeOfParts.BRAIN)) || (getName().equals(TypeOfParts.VESSELS))){
            System.out.println(getName().getName() + " испытывает давление из-за гравитации");
        } else if (getName().equals(TypeOfParts.LEGS)) {
            System.out.println(getName().getName() + " исптывает недостаток крови");
        }
    }
    @Override
    public void moveTo(){
        if (getName().equals(TypeOfParts.BLOOD)){
            System.out.println(getName().getName() + " приливается к верхней части тела");
        }
    }

    @Override
    public String toString() {
        return "часть тела: " + getName().getName();
    }

    @Override
    public int hashCode() {
        return name.hashCode()+current;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj){
            return true;
        }
        return this.current == ((Parts)obj).current;
    }
}
