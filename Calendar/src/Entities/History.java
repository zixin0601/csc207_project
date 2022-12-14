package Entities;
import java.time.*;
import java.io.*;

/** An entity class representing a single instance of a recorded action.
 */
public class History implements Serializable {
    private final String action;       // what is the action
    private final String username;     // who did the action
    private final LocalDateTime time;  // when did the action happen

    /** Constructor for History
     * @param action a description of the action performed
     * @param username the username of the user who performed the action.
     */
    public History(String username, String action) {
        this.username = username;
        this.action = action;
        this.time = LocalDateTime.now();
    }

    /** Get the History's action.
     * @return action
     */
    public String getAction() {
        return action;
    }

    /** Get the History's user.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /** Get the History's time.
     * @return time
     */
    public LocalDateTime getTime() {
        return time;
    }

    /** String representation of History.
     * @return History as a String
     */
    @Override
    public String toString() {
        return time + " | " + username + " | " + action;
    }
}
