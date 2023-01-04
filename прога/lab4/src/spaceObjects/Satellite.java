package spaceObjects;



public class Satellite extends SpaceObject {

    public Satellite(String name) {
        super(name);
    }

    public void beTurned() {
        try {
            for (int i = 0; i < WhatIsTurned.values().length; i++) {
                if (i >= WhatIsTurned.values().length) {
                    throw new BadNumber("выход за массив");

                } else {
                    final int ii = i;

                    class ThingsTurned {
                        final WhatIsTurned thing = WhatIsTurned.values()[ii];

                        String print() {
                            return thing.getName();
                        }
                    }

                    System.out.println(new ThingsTurned().print() + " кажется повернутым вверх тормашками");
                }
            }
        } catch (BadNumber ex) {
            System.out.println("Проверьте размер массива и условия цикла");
        }

    }


    @Override
    public void createConditions() {
        System.out.println(getName() + " создает нормальные условия");
    }

    @Override
    public void influence(String stuff) {
        System.out.println(getName() + "не влияет на" + stuff);
    }

    @Override
    public void pullToCentre(String name) {
        System.out.println(getName() + " притягивает все с меньшей силой");
        setForce("сильная");
    }

    @Override
    public String toString() {
        return ("Имя:" + getName() + "; обладает силой: " + getForce());
    }

    @Override
    public int hashCode() {
        return super.hashCode() + getName().hashCode() + getForce().hashCode() + getWeather().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.getName() == ((Satellite) obj).getName() && this.getWeather() == ((Satellite) obj).getWeather()
                && this.getForce() == ((Satellite) obj).getForce();
    }
}
