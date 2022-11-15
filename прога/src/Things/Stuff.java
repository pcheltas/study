package Things;

public class Stuff {
    private String name;

    public String getName() {
        return name;
    }

    public Stuff(String name){
        this.name=name;
    }

    @Override
    public String toString(){
        return ("Вещь:" + name);
    }
}
