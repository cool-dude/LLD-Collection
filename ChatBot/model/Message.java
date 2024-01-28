import chatbot.model;

/*Chatbot */
public interface Message {
    public Instant getTs() {
    }

    public int getData() {
    }

    public MessageStatus getMessageStatus(){
    }
}