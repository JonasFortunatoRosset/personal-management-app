package com.jns.personalmanagementapp.enums;

public enum WeekOfMonth {
    FIRST(1),
    SECOND(2),
    THIRD(4),
    FOURTH(8),
    FIFTH(16);

    private final byte value;

    WeekOfMonth(int value) {
        this.value = (byte) value;
    }

    public byte getValue(){
        return value;
    }
}