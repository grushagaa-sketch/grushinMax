package Messenger;

public class Channel {
    public String id;
    public String name;
    public User admin;
    private User[] subscribers;
    private Message[] messages;
    private int MAX_SUBSCRIBERS_CNT = 1000;
    private int MAX_MESSAGES_CNT = 5000;
    private int currentSubscribersCnt;
    private int currentMessagesCnt;

    public Channel(String id, String name, User admin) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.subscribers = new User[MAX_SUBSCRIBERS_CNT];
        this.messages = new Message[MAX_MESSAGES_CNT];
        this.currentSubscribersCnt = 0;
        this.currentMessagesCnt = 0;
        addSubscriber(admin); //Админ автоматически подписчик
        admin.addMyChannel(this); // присваеваем канал админу
    }

    public void addSubscriber(User user) {
        if (currentSubscribersCnt < MAX_SUBSCRIBERS_CNT) {
            subscribers[currentSubscribersCnt] = user;
            currentSubscribersCnt++;
            user.joinChannel(this);
        } else {
            System.out.println("Достигнут лимит пользователь");
        }
    }

    public void addMessage(Message message) {
        if (!message.userName.equals(admin.userName)) { // проверка, что только админ может писать
            System.out.println("Ошибка: только админ " + admin.userName + " может писать в канал");
            return;
        }
        if (currentMessagesCnt < MAX_MESSAGES_CNT) {
            messages[currentMessagesCnt] = message;
            currentMessagesCnt++;
        } else {
            System.out.println("Достигнут лимит сообщений");
        }
    }

    // вывод членов канала
    public void displaySubscribers() {
        System.out.println("Подписчики канала '" + name + "' (ID: " + id + "):");
        for (int i = 0; i < currentSubscribersCnt; i++) {
            System.out.println((i + 1) + ". " + subscribers[i].userName + " - " + subscribers[i].name);
        }
    }

    public void displayMessages() {
        System.out.println("Сообщения в канале '" + name + "' (ID: " + id + "):");
        for (int i = 0; i < currentMessagesCnt; i++) {
            System.out.println((i + 1) + ". " + messages[i]);
        }
    }

    public User[] getSubscribers() {
        User[] result = new User[currentSubscribersCnt];
        for (int i = 0; i < currentSubscribersCnt; i++) {
            result[i] = subscribers[i];
        }
        return result;
    }

    public int getSubscribersCount() {
        return currentSubscribersCnt;
    }

    @Override
    public String toString() {
        return "Канал:" + name + " (ID: " + id + ", админ: " + admin.userName + ", подписчиков: " + currentSubscribersCnt + ")";
    }
}
