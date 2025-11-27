package Messenger;

public class Message {
    private String date;
    private User fromWho;
    private String text;
    private final int MAX_MESSAGE_SIZE = 5000;
    private int currentMessagesSize;
    private Group group = null;
    private Channel channel = null;
    private User userChat = null;
    private Boolean isRead = false;
    private int countRead = 0;

    public Message() {

    }

    public Message(String date, User fromWho, String text) {
        this.date = date;
        this.fromWho = fromWho;

        if (text.length() < MAX_MESSAGE_SIZE) {
            this.text = text;
        } else {
            this.text = text.substring(0, MAX_MESSAGE_SIZE);
        }

        this.currentMessagesSize = text.length();
    }

    public void setFromMessage(Group group) {
        this.group = group;
    }

    public void setFromMessage(Channel channel) {
        this.channel = channel;
    }

    public void setFromMessage(User userChat) {
        this.userChat = userChat;
    }

    public void updateMessage(String text) {
        if (text.length() < MAX_MESSAGE_SIZE) {
            this.text = text;
        } else {
            this.text = text.substring(0, MAX_MESSAGE_SIZE);
        }

        this.currentMessagesSize = text.length();
    }

    public void readMessage() {
        this.isRead = true;
        countRead++;
    }

    public String getDate() {
        return date;
    }

    public User getFromWho() {
        return fromWho;
    }

    public String getText() {
        return text;
    }

    public int getMAX_MESSAGE_SIZE() {
        return MAX_MESSAGE_SIZE;
    }

    public int getCurrentMessagesSize() {
        return currentMessagesSize;
    }

    public Group getGroup() {
        return group;
    }

    public Channel getChannel() {
        return channel;
    }

    public User getUserChat() {
        return userChat;
    }

    public Boolean getRead() {
        return isRead;
    }
}
