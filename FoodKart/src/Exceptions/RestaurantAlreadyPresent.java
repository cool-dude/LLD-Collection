package Exceptions;
/*Foodkart */
public class RestaurantAlreadyPresent extends RuntimeException {
    public RestaurantAlreadyPresent(String message) {
        super(message);
    }
}
