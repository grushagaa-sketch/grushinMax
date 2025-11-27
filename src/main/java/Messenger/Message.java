package Messenger;

public class Message {
    public String text;
    public String data;
    public User fromWho;
    public Group group;
    public Channel channel;
    public User userchat;
    private int MAX_MESSAGE_SIZE = 5000;
    private int currentMessagesSize;

    public Message(String text, String data, User fromWho) {
        this.text = text;
        this.data = data;
        this.fromWho = fromWho;

    }
}
