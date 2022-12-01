package body;

public enum  TypeOfParts {
    BRAIN("мозг"),
    VESSELS("сосуды"),
    LEGS("ноги"),
    BLOOD("кровь");
    private String name;
    TypeOfParts(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
