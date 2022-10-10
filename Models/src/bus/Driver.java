package bus;

public class Driver {
    private String name;
    private int experience;



    public Driver(String name, int experience) {
        this.name = name;
        if (experience < 0) {
            this.experience = 0;
        } else {
            this.experience = experience;
        }
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}
