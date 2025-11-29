package Messenger;

public class Group {
    public String id;
    public String name;
    private User[] members;
    private Message[] messages;
    private int MAX_MEMBERS_CNT = 100;
    private int MAX_MESSAGES_CNT = 1000;
    private int currentMembersCnt;
    private int currentMessagesCnt;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        this.members = new User[MAX_MEMBERS_CNT];
        this.messages = new Message[MAX_MESSAGES_CNT];
        this.currentMembersCnt = 0;
        this.currentMessagesCnt = 0;
    }

    public void addMember(User user) {
        if (currentMembersCnt < MAX_MEMBERS_CNT) {
            members[currentMembersCnt] = user;
            currentMembersCnt++;
            user.joinGroup(this);
        } else {
            System.out.println("Достигнут лимит пользователей");
        }
    }

    public void addMessage(Message message) {
        if (currentMessagesCnt < MAX_MESSAGES_CNT) {
            messages[currentMessagesCnt] = message;
            currentMessagesCnt++;
        } else {
            System.out.println("Достигнут лимит сообщений");
        }
    }

    public void displayMembers() {
        System.out.println("Участники группы '" + name + "' (ID: " + id + "):");
        for (int i = 0; i < currentMembersCnt; i++) {
            System.out.println((i + 1) + ". " + members[i].userName + " - " + members[i].name);
        }
    }

    public void displayMessages() {
        System.out.println("Сообщения в группе '" + name + "' (ID: " + id + "):");
        for (int i = 0; i < currentMessagesCnt; i++) {
            System.out.println((i + 1) + ". " + messages[i].getText());
        }
    }

    public User[] getMembers() {
        User[] result = new User[currentMembersCnt];
        for (int i = 0; i < currentMembersCnt; i++) {
            result[i] = members[i];
        }
        return result;
    }

    public int getMembersCount() {
        return currentMembersCnt;
    }

    @Override
    public String toString() {
        return "Группа:" + name + " (ID: " + id + ", участников: " + currentMembersCnt + ")";
    }
}
