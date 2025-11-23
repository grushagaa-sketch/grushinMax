package Messenger;

public class User {
    public String name; // просто имя (любое)
    public String userName; // на английском, начинается с @
    private Group[] groups; // группы, в которых состоит пользователь
    private Channel[] channels; // каналы, в которых состоит пользователь, там он ничего писать не может
    private Channel myChannel; // канал пользователя, в нем он может писать сообщения
    private Message[] messages; // список всех сообщений, которые пользователь отправлял и получал
    private int MAX_MESSAGES_CNT=1000;
    private int MAX_GROUPS_CNT=50;
    private int MAX_CHANNELS_CNT=50;
    private int currentMessagesCnt;
    private int currentGroupsCnt;
    private int currentChannelsCnt;

    public User(String name, String userName) {
        this.name=name;
        this.userName=userName;
    }

    public void joinGroup(Group group) {
        if (currentGroupsCnt<MAX_GROUPS_CNT) {
            groups[currentGroupsCnt] = group;
            currentGroupsCnt++;
        }
    }

    public void joinChannel(Channel channel) {
        if (currentChannelsCnt<MAX_CHANNELS_CNT) {
            channels[currentChannelsCnt] = channel;
            currentChannelsCnt++;
        }
    }

    public void leaveGroup(Group group) {
        boolean flag=false;
        for (int i=0; i<currentGroupsCnt;i++) {
            if (groups[i].id.equals(group.id)) {
                groups[i] = groups[currentGroupsCnt-1];
                flag=true;
                break;
            }
        }
        if (flag) {
            groups[currentGroupsCnt-1]=null;
            currentGroupsCnt--;
        }
    }

    public void leaveChannel(Channel channel) {
        boolean flag=false;
        for (int i=0; i<currentChannelsCnt;i++) {
            if (channels[i].id.equals(channel.id)) {
                channels[i] = channels[currentChannelsCnt-1];
                flag=true;
                break;
            }
        }
        if (flag) {
            channels[currentChannelsCnt-1]=null;
            currentChannelsCnt--;
        }
    }


}
