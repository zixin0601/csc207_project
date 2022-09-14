package Gateway;
import java.io.*;

/** Interface for gateway saver.
 */
public interface InterfaceSaver {
    boolean changesMade();
    void makeChange();
    void saveAll();
    void save(Serializable saveable, String fileName) throws IOException;
    <T> T load(T item, String fileName) throws IOException, ClassNotFoundException;
}
