package model;

/*Car rental */
abstract class Vehicle {
    enum type{
        CAR,
        SUV,
        VAN
    };
    String plateNum;
    int capacity;
    enum status{
        AVAIL,
        RESERVED,
        IN_SERVCICE,
        DEFAULT
    }
    String location;
    
    public boolean reserve();
    public boolean return();
}
