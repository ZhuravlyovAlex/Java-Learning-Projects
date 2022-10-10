package bus;

public class Bus {
    private int number;
    private String model;
    private int seats;
    private Driver driver;
    private Passenger[] passengers;
    private int countPassengers;
    private boolean inRoad;

    public Bus(int number, String model, int seats) {
        this.number = number;
        this.model = model;
        this.seats = seats;
        this.passengers = new Passenger[seats];
        this.countPassengers = 0;
    }

    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getSeats() {
        return seats;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void go() {
        inRoad = true;
        System.out.println("Автобус c номером [" + number + "] поехал под управлением водителя " + driver.getName());
        System.out.println("Наши пассажиры: ");
        if (countPassengers > 0) {
            for (int i = 0; i < countPassengers; i++) {
                System.out.println(passengers[i].getName());
            }
        } else {
            System.out.println("Автобус пуст");
        }
    }
    public void inCome(Passenger passenger) {
        String message = null;

        if (inRoad) {
            message = "Автобус в пути. Посадка не возможна";
        }

        if (countPassengers == passengers.length) {
            message = "Автобус переполнен!";
        }

        if (message != null) {
            System.err.println(message);
            return;
        }
        this.passengers[countPassengers] = passenger;
        countPassengers++;
    }
}
