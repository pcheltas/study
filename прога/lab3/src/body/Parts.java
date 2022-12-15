package body;


import inters.ActionsBased;
import inters.FeelingsFromGravity;
import inters.IsPart;

public class Parts implements IsPart, FeelingsFromGravity, ActionsBased {

    private final TypeOfParts parttype;

    public Parts(TypeOfParts type) {
        this.parttype = type;
    }




//    @Override
//    public void isAPart() {
//        if ((parttype.equals(TypeOfParts.BRAIN)) || (parttype.equals(TypeOfParts.VESSELS)) ||
//                (parttype.equals(TypeOfParts.BLOOD))) {
//            System.out.println(parttype.getName() + " является частью системы внутренних органов");
//        } else if ((parttype.equals(TypeOfParts.LEGS))) {
//            System.out.println(parttype.getName() + " является внешним органом");
//        }
//    }

//    @Override
//    public void feel() {
//        if ((parttype.equals(TypeOfParts.BRAIN)) || (parttype.equals(TypeOfParts.VESSELS))) {
//            System.out.println(parttype.getName() + " испытывает давление из-за гравитации");
//        } else if (parttype.equals(TypeOfParts.LEGS)) {
//            System.out.println(parttype.getName() + " исптывает недостаток крови");
//        } else if (parttype.equals(TypeOfParts.BLOOD)) {
//            System.out.println(parttype.getName() + " создает недостаток крови");
//        }
//    }

//    @Override
//    public void moveTo() {
//        if (parttype.equals(TypeOfParts.BLOOD)) {
//            System.out.println(parttype.getName() + " приливается к верхней части тела");
//        } else if (parttype.equals(TypeOfParts.BRAIN) || parttype.equals(TypeOfParts.VESSELS) ||
//                parttype.equals(TypeOfParts.LEGS)) {
//            System.out.println(parttype.getName() + " не изменяет своего положения");

//        }
//    }





//    @Override
//    public void feel() {
//        switch (parttype) {
//            case LEGS:
//                System.out.println(parttype.getName() + " исптывает недостаток крови");
//            case BLOOD:
//                System.out.println(parttype.getName() + " создает недостаток крови");
//            case VESSELS:
//            case BRAIN:
//                System.out.println(parttype.getName() + " испытывает давление из-за гравитации");
//        }
//    }

    @Override
    public void feel(){
        System.out.println(this.parttype.getName() + this.parttype.getDescription());
    }

//  @Override
//  public void isAPart() {
//        switch (parttype){
//            case BRAIN:
//            case VESSELS:
//            case BLOOD:
//                System.out.println(parttype.getName() + " является частью системы внутренних органов");
//            case LEGS:
//                System.out.println(parttype.getName() + " является внешним органом");
//        }


    @Override
    public void isAPart() {
        if (this.parttype.isInternal()) {
            System.out.println(this.parttype.getName() + " является частью системы внутренних органов");
        } else {
            System.out.println(this.parttype.getName() + " является внешним органом");
        }
    }

//    @Override
//    public void moveTo() {
//        switch (parttype) {
//            case BLOOD:
//                System.out.println(parttype.getName() + " приливается к верхней части тела");
//            case LEGS:
//            case VESSELS:
//            case BRAIN:
//                System.out.println(parttype.getName() + " не изменяет своего положения");
//        }
//    }

    @Override
    public void moveTo() {
        if (this.parttype.isCanMove()) {
            System.out.println(this.parttype.getName() + " приливается к верхней части тела");
        } else {
            System.out.println(this.parttype.getName() + " не изменяет своего положения");
        }
    }

    @Override
    public String toString() {
        return "часть тела: " + this.parttype.getName();
    }

    @Override
    public int hashCode() {
        return this.parttype.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.parttype == ((Parts) obj).parttype;
    }
}
