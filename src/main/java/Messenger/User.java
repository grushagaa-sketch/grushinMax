package Messenger;

public class User {
    public String name; // просто имя (любое)
    public String userName; // на английском, начинается с @
    private Group[] groups; // группы, в которых состоит пользователь
    private Channel[] channels; // каналы, в которых состоит пользователь, там он ничего писать не может
    private Channel[] myChannels; // каналы пользователя, в них он может писать сообщения
    private Message[] messages; // список всех сообщений, которые пользователь отправлял и получал

    public User(String name, String userName) {
        this.name=name;
        this.userName=userName;
    }


}
