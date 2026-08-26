package com.jns.personalmanagementapp.enums;

public enum StatusOfRoutine {

    PENDING(1),
    ACTIVE(2),
    PAUSED(3),
    COMPLETED(4),
    CANCELLED(5);

    private final byte value;


    StatusOfRoutine(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return value;
    }

}