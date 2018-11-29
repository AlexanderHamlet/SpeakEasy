package hamlet.alexander.SpeakEasy;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * User model.
 * Stores user's username, password, and their role for permissions.
 * This class is used to both hold user information for the
 * current applications session as well as store user data
 * in the database.
 */
@Document(collection = "user")
public class User {

    @Id
    private ObjectId id;

    private String userName;
    private String password;
    private String role;

    /**
     * Constructor. Takes username, password, and role as parameters.
     *
     * NOTE: This application is a project testing my ability to create
     *       design patterns. THIS IS NOT OPTIMIZED FOR SECURITY. DO NOT
     *       USE THIS FOR PRODUCTION CODE.
     *
     * @param userName
     * @param password
     * @param role
     */
    public User(String userName, String password, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    /**
     * Grabs user's id.
     * @return
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Sets user's id.
     * @param id
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Grabs user's username.
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user's username.
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Grabs user's password.
     *
     * NOTE: This application is a project testing my ability to create
     *       design patterns. THIS IS NOT OPTIMIZED FOR SECURITY. DO NOT
     *       USE THIS FOR PRODUCTION CODE.
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets user's password.
     *
     * NOTE: This application is a project testing my ability to create
     *       design patterns. THIS IS NOT OPTIMIZED FOR SECURITY. DO NOT
     *       USE THIS FOR PRODUCTION CODE.
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Grabs user's role.
     *
     * NOTE: This application is a project testing my ability to create
     *       design patterns. THIS IS NOT OPTIMIZED FOR SECURITY. DO NOT
     *       USE THIS FOR PRODUCTION CODE.
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets user's role.
     *
     * NOTE: This application is a project testing my ability to create
     *       design patterns. THIS IS NOT OPTIMIZED FOR SECURITY. DO NOT
     *       USE THIS FOR PRODUCTION CODE.
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
    }
}
