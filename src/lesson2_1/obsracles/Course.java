package lesson2_1.obsracles;

import lesson2_1.participants.Participant;
import lesson2_1.participants.Team;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        Participant[] participants = team.getParticipants();
        boolean[][] results = new boolean[participants.length][obstacles.length];
        int i = 0;
        int j;

        for (Participant participant : participants) {
            j = 0;

            for (Obstacle obstacle : obstacles) {
                if (participant.isFail()) {
                    results[i][j] = false;
                    j++;
                    continue;
                }

                obstacle.doIt(participant);
                if (!participant.isFail()) {
                    results[i][j] = true;
                }
                j++;
            }
            i++;
        }

        team.setResults(results);
    }
}
