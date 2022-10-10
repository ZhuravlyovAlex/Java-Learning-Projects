package tv;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV("Sony");
        Channel channel1 = new Channel("Первый");
        channel1.addProgram(new Program("Большая разница"));
        channel1.addProgram(new Program("Малахов+"));
        channel1.addProgram(new Program("Голос. Дети"));
        channel1.addProgram(new Program("КВН"));

        Channel channel2 = new Channel("Россия");
        channel2.addProgram(new Program("Сам себе режисёр"));
        channel2.addProgram(new Program("Когда все дома"));
        channel2.addProgram(new Program("Импровизация"));

        Controller controller = new Controller(tv);
        tv.addChannel(channel1);
        tv.addChannel(channel2);

        controller.on(2);
    }
}
