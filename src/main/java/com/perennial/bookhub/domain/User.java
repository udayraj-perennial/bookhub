package com.perennial.bookhub.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString

/**
 * This class is an anemic class to hold user information in the system
 * It does not have any business logic
 */
public class User {
    /**
     * This is used to display the username evrey where in the application
     */
    private final String displayName;
    /**
     * username should be a valid email
     */
    private final String username;
    /**
     * MD5 encrypted password for the user, excluded from the toString
     */
    @ToString.Exclude
    private final String passwordHash;
    /**
     * Indicate if the user is active in the system or not
     */
    private final UserStatus status;

    public User(String displayName, String username, String passwordHash) {
        this.displayName = displayName;
        this.username = username;
        this.passwordHash = passwordHash;
        this.status = UserStatus.ACTIVE;
    }
}
