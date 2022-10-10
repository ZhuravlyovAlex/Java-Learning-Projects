package tv;

public class TV {
    private String name;
    private Channel[] channels;
    private int countOfChannels = 1;

    public TV(String name) {
        this.name = name;
        channels = new Channel[200];
    }

    public String getName() {
        return name;
    }

    public Channel getChannels(int numberOfChannel) {
        if(numberOfChannel < channels.length) {
            return channels[numberOfChannel];
        } else {
            return channels[numberOfChannel];
        }

    }

    public int getCountOfChannels() {
        return countOfChannels;
    }

    public void addChannel(Channel channel) {
        if (countOfChannels < channels.length) {
            channels[countOfChannels] = channel;
            countOfChannels++;
        } else {
            System.err.println("Не возможности добавить новый канал");
        }
    }
}
