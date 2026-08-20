package com.jns.personalmanagementapp.enums;

public enum StatusOfGoal {

    PENDING(1),
    IN_PROGRESS(2),
    COMPLETED(3),
    CANCELLED(4);

    private final byte value;

    StatusOfGoal(int value) {
        this.value = (byte) value;
    }

    public byte getValue() {
        return value;
    }
}