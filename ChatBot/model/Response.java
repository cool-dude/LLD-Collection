package chatbot.model;

/*Chatbot */
import java.time.Instant;

public class Response {
    String msg_id;
    String usr_id;
    Instant ts;
    String response_id;
    ENUM client_type;
}