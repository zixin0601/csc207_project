package Shell.Controller;

import Shell.Presenter.ShellPresenter;
import java.util.*;

/** A part of the Shell dedicated to one part of the menu.
 */
abstract public class ShellMenu {
    Map<String, Runnable> commands = new HashMap<>();
    // From https://stackoverflow.com/questions/4480334/how-to-call-a-method-stored-in-a-hashmap-java
    /* I used a map of commands (eg. "1", "2", "3") to an anonymous function to execute because:
    - It makes checking the user's input a lot easier than writing a bulky switch statement with repetitive code
    - It makes it easier to define what numbers are allowed to be called
    - Inheritance makes it easier to define common commands shared by menus (eg. User/AdminUser Menu) */
    private static MenuState menuState = MenuState.LOG_OUT;

    /** Set the MenuState.
     * @param menuState the new MenuState
     */
    protected void setMenuState(MenuState menuState) {
        ShellMenu.menuState = menuState;
    }

    /** Get the current MenuState.
     * @return the current MenuState
     */
    protected MenuState getMenuState() {
        return ShellMenu.menuState;
    }

    /** Helper function, checks the input - if correct, executes it, otherwise asks for input again.
     * @param p The presenter class
     * @param input The initial prompt string to display.
     */
    protected void handleInput(ShellPresenter p, String input) {
        do {
            if (commands.containsKey(input)) {
                commands.get(input).run();
            } else {
                p.displayResult("Unrecognized input. Please try again.");
                input = p.getInput();
                if (commands.containsKey(input))
                    commands.get(input).run();
            }
        } while (!commands.containsKey(input));
    }

    /** Run through the menu state once.
     * @param presenter The presenter class.
     */
    public abstract void run(ShellPresenter presenter);
}
