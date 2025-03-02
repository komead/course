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
}
