package spaceObjects;

public enum WhatIsTurned {
    MOON("Луна"),
    MOUNTAINS("горы"),
    HIMSELF("он сам"),
    FRIEND("его товарищ"),
    MOONSURFACE("лунная поверность");


    private final String name;

    WhatIsTurned(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    }
