package exceptions;
/*PropertyHunt or property listing company */
public class PropertyNotAvailable extends RuntimeException {
    public PropertyNotAvailable(String message) {
        super(message);
    }
}
