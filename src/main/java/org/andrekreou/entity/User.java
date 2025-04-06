package org.andrekreou.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.oidc.UserInfo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represents a {@link User} entity in the system.
 * <p>
 * This entity is mapped to the "user" table in the database and extends {@link PanacheEntityBase}
 * to leverage the active record pattern provided by Quarkus Panache.
 * </p>
 * <p>
 * The {@link PanacheEntityBase} class provides utility methods for common database operations
 * such as persisting, updating, deleting, and querying entities. By extending this class, the
 * {@link User} entity inherits these methods, simplifying the implementation of CRUD operations.
 * </p>
 * <p>
 * The {@link User} entity contains the following fields:
 * <ul>
 *     <li>{@code userId} - Unique call number of the {@link User} entity.</li>
 *     <li>{@code userName} - The username of the {@link User} provided upon registration.</li>
 *     <li>{@code firstName} - The first name of the {@link User} provided upon registration.</li>
 *     <li>{@code lastName} - The last name of the {@link User} provided upon registration.</li>
 *     <li>{@code email} - The email of the {@link User} provided upon registration.</li>
 * </ul>
 * </p>
 */
@Entity(name = "platform_user")
public class User extends PanacheEntityBase {

    /**
     * The user id of the {@link User}.
     * <p>
     * This ID is generated automatically using a UUID generation strategy to ensure uniqueness.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    public String userId;

    /**
     * The username of the {@link User}.
     * <p>
     * This field is marked as non-nullable to ensure that every user entity has associated username.
     * The username is persisted as-is.
     * </p>
     */
    @Column(name = "user_name", nullable = false)
    public String userName;

    /**
     * The first name of the {@link User}.
     * <p>
     * This field is marked as non-nullable to ensure that every user entity has associated first name.
     * The first name is persisted as-is.
     * </p>
     */
    @Column(name = "first_name", nullable = false)
    public String firstName;

    /**
     * The last name of the {@link User}.
     * <p>
     * This field is marked as non-nullable to ensure that every user entity has associated last name.
     * The last name is persisted as-is.
     * </p>
     */
    @Column(name = "last_name", nullable = false)
    public String lastName;

    /**
     * The email address of the {@link User}.
     * <p>
     * This field is marked as non-nullable to ensure that every user entity has associated email address.
     * The email address is persisted as-is.
     * </p>
     */
    @Column(name = "email", nullable = false)
    public String email;

    public User() {
    }

    /**
     * @return The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of userId
     *
     * @param userId The new value to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return The userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the value of userName
     *
     * @param userName The new value to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of firstName
     *
     * @param firstName The new value to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of lastName
     *
     * @param lastName The new value to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of email
     *
     * @param email The new value to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Creates a new Builder instance.
     *
     * @return the created Builder instance.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * A static Builder class used for building {@link User} instances.
     */
    public static class Builder {
        public String userId;
        public String userName;
        public String firstName;
        public String lastName;
        public String email;

        /**
         * Sets the user ID of this Builder instance.
         *
         * @param userId the user ID to be set.
         * @return this Builder instance.
         */
        public Builder withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        /**
         * Sets username of this Builder instance.
         *
         * @param userName the username to be set.
         * @return this Builder instance.
         */
        public Builder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        /**
         * Sets the first name of this Builder instance.
         *
         * @param firstName the first name to be set.
         * @return this Builder instance.
         */
        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        /**
         * Sets the last name of this Builder instance.
         *
         * @param lastName the last name to be set.
         * @return this Builder instance.
         */
        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        /**
         * Sets the email address of this Builder instance.
         *
         * @param email the email address to be set.
         * @return this Builder instance.
         */
        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        /**
         * Builds the {@link User} instance.
         *
         * @return the newly built {@link User} instance.
         */
        public User build() {
            User user = new User();
            user.setUserId(userId);
            user.setUserName(userName);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            return user;
        }
    }

    /**
     * Responsible for creating {@link User} objects based on the {@link UserInfo}
     *
     * @param userInfo the object used to create the {@link User} object
     * @return the created {@link User} object
     */
    public static User create(UserInfo userInfo) {
        return User.builder()
                .withUserName(userInfo.getPreferredUserName())
                .withFirstName(userInfo.getFirstName())
                .withLastName(userInfo.getFamilyName())
                .withEmail(userInfo.getEmail())
                .build();
    }
}