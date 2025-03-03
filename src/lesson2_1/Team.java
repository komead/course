package lesson2_1;

public class Team {
    private String name;

    private Participant[] participants;
    private boolean[][] results;

    public Team(String name, Participant[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public void setResults(boolean[][] results) {
        this.results = results;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void showResults() {
        System.out.println("\nРезультаты команды " + name + ":");

        for (int i = 0; i < participants.length; i++) {
            System.out.print("Участник " + participants[i].getName() + ":");

            for (int j = 0; j < results[i].length; j++) {
                System.out.print(" " + results[i][j]);
            }
            System.out.println();
        }
    }

    public void showWinners() {
        System.out.println("\nВсе препятствия прошли участники команды " + name + ":");

        for (int i = 0; i < participants.length; i++) {
            // Если пройдено последнее препятствие, то все предыдущие были тоже пройдены
            if (results[i][results[i].length - 1]) {
                System.out.println("Участник " + participants[i].getName());
            }
        }
    }
}
