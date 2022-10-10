package bus;

public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(23, "Нефаз", 10);
        Driver driver = new Driver("Михаил", 37);
        driver.go(bus);

        Passenger passenger1 = new Passenger("пассажир1");
        Passenger passenger2 = new Passenger("пассажир2");
        Passenger passenger3 = new Passenger("пассажир3");
        Passenger passenger4 = new Passenger("пассажир4");
        Passenger passenger5 = new Passenger("пассажир5");
        passenger1.go(bus);
        passenger2.go(bus);
        passenger3.go(bus);
        passenger4.go(bus);
        passenger5.go(bus);

        driver.drive();
    }
}