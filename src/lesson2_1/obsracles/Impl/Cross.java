package lesson2_1.obsracles.Impl;

import lesson2_1.obsracles.Obstacle;
import lesson2_1.participants.Participant;

public class Cross implements Obstacle {
    private final String TYPE = "cross";
    private int distance;

    public Cross(int distance) {
        this.distance = distance;
    }

    public void doIt(Participant participant) {
        participant.run(distance);
    }

    public String getType() {
        return TYPE;
    }
}
