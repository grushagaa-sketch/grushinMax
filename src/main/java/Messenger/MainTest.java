package Messenger;

public class Main {
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
            channel.addSubsriber(users[i]);
            users[i].joinChannel(channel);
        }
        Igor.leaveChannel(channel); //Даня, прости, это для теста

        Channel bomb = new Channel("9876543210", "scha udalu", Igor);
        Igor.addMyChannel(bomb); //тест создания и удаления канала
        Igor.delMyChannel(bomb);

        Message AnyaTestMessage = new Message("27.11.2025", Anya, "Hello world!");
        Message DanyaTestMessage = new Message("28.11.2025", Danya, "Hello world!");
        Message ElinaTestMessage = new Message("29.11.2025", Elina, "Hello world!");
        Message IgorTestMessage = new Message("30.11.2025", Igor, "Hello world!");

        Anya.sendMessage(AnyaTestMessage);
        Igor.sendMessage(IgorTestMessage); //добавление по сообщению кажджому, кто пишет в чат
        group.addMessage(AnyaTestMessage);
        group.addMessage(IgorTestMessage); //добавление сообщений в чат
        System.out.println("Участники группы: " + group.displayMembers());
        System.out.println("Всего участников: " + group.getMembersCount());
        System.out.println("Сообщения группы: " + group.displayMessages());

        Danya.sendMessage(DanyaTestMessage);
        channel.addMessage(ElinaTestMessage); //подписчик попробовал отправить сообщение
        channel.addMessage(DanyaTestMessage); //админ показал кто тут главный
        System.out.println("Подписчики канала: " + channel.displayMembers()); //осмотр подданных
        System.out.println("Всего подписчиков: " + channel.getMembersCount());
        System.out.println("Сообщения канала: " + channel.displayMessages());
    }
}