package body;

public enum TypeOfParts {
    BRAIN("мозг", true, false,  " испытывает давление из-за гравитации"),
    VESSELS("сосуды", true, false, "  испытывает давление из-за гравитации"),
    LEGS("ноги", false, false, " исптывает недостаток крови"),
    BLOOD("кровь", true, true," создает недостаток крови");
    private String name;
    private boolean internal;
    private boolean canMove;
    private String description;

    TypeOfParts(String name, boolean internal, boolean canMove, String description) {
        this.name = name;
        this.internal = internal;
        this.canMove = canMove;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isInternal() {
        return internal;
    }

    public boolean isCanMove() {
        return canMove;
    }
}
