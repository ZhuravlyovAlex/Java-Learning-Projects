package tv;

import java.util.Random;

public class Controller {
    private TV tv;

    public Controller(TV tv) {
        this.tv = tv;
    }

    public void on(int numberOfChannel) {
        Channel channel = tv.getChannels(numberOfChannel);
        Random random = new Random();
        int numberOfProgram = random.nextInt(channel.getCountOfPrograms());
        System.out.printf("канал: %20s \n", channel.getName());
        System.out.printf("программа: %16s ", channel.getProgram(numberOfProgram).getName());
    }
}
