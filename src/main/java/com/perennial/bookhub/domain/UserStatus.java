package com.perennial.bookhub.domain;

public enum UserStatus {
    ACTIVE("Active"), INACTIVE("Inactive");

    public final String label;

    private UserStatus(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
