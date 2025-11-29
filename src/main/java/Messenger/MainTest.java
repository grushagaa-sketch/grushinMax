package Messenger;

public class MainTest {
    public static void main(String[] args) {

        User Anya = new User("Anya", "@anya");  //легендарные создатели grushinMax
        User Elina = new User("Elina", "@elina");
        User Danya = new User("Danya", "@danya");
        User Igor = new User("Igor", "@igor");
        User[] users = {Anya, Elina, Danya, Igor};

        Group group = new Group("123456", "homework"); //группа, где Даня не выдержит давления
        for (int i = 0; i < 4; i++) {
            group.addMember(users[i]);
            users[i].joinGroup(group);
        }
        Danya.leaveGroup(group); //не выдержал

        Channel channel = new Channel("47714214", "Kri", Danya); //тестовый канал для Данечки
        Danya.addMyChannel(channel);
        for (int i = 0; i < 4; i++) {
            channel.addSubscriber(users[i]);
            users[i].joinChannel(channel);
        }
        Igor.leaveChannel(channel); //Даня, прости, это для теста

        Channel bomb = new Channel("9876543210", "scha udalu", Igor);
        Igor.addMyChannel(bomb); //тест создания и удаления канала
        Igor.delMyChannel();

        Message AnyaTestMessage = new Message("27.11.2025", Anya, "я хочу спать");
        Message DanyaTestMessage = new Message("28.11.2025", Danya, "я");
        Message ElinaTestMessage = new Message("29.11.2025", Elina, "я ничего не хочу");
        Message IgorTestMessage = new Message("30.11.2025", Igor, "я хочу кушать");

        Anya.sendMessageToChat(AnyaTestMessage);
        Igor.sendMessageToChat(IgorTestMessage); //добавление по сообщению кажджому, кто пишет в чат
        group.addMessage(AnyaTestMessage);
        group.addMessage(IgorTestMessage); //добавление сообщений в чат
        group.displayMembers();
        System.out.println("Всего участников: " + group.getMembersCount());
        group.displayMessages();

        Elina.sendMessageToChat(ElinaTestMessage);
        channel.addMessage(ElinaTestMessage); //подписчик попробовал отправить сообщение
        Danya.sendMessageToChat(DanyaTestMessage);
        channel.addMessage(DanyaTestMessage); //админ показал кто тут главный
        channel.displaySubscribers(); //осмотр подданных
        System.out.println("Всего подписчиков: " + channel.getSubscribersCount());
        channel.displayMessages();
    }
}