package tv;

public class Channel {
    private String name;
    private Program[] programs;
    private int countOfPrograms;

    public Channel(String name) {
        this.name = name;
        programs = new Program[50];
    }

    public String getName() {
        return name;
    }

    public Program getProgram(int program) {

        return programs[program];
    }

    public int getCountOfPrograms() {
        return countOfPrograms;
    }

    public void addProgram(Program program) {
        if(countOfPrograms == programs.length) {
            System.err.println("Нет возможности добавить новую программу\n Сетка канала заполненна");
        } else {
            programs[countOfPrograms] = program;
            countOfPrograms++;
        }
    }
}
