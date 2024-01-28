package model;

/*Car rental */
import javax.xml.crypto.Data;

enum ReservationStatus {
    WAIT,
    PENDING,
    CONFIRMED,
    COMPLETE,
    DEFAULT
}

public class Reservation {
    String resvNum;
    Date created_date, start_date;
    ReservationStatus stat;
    Data end_date;
    String pickupLoc;
    String invoiceID;
    Vehicle reservedVehicle;

    public VehicleReservation fetchDetails();
}
