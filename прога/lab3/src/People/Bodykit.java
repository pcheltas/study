package people;

public enum Bodykit {
    STURDY("крепенький"),
    FAT("толстый");
    private String name;

    Bodykit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
