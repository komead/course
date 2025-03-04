package lesson2_1.obsracles.Impl;

import lesson2_1.obsracles.Obstacle;
import lesson2_1.participants.Participant;

public class Wall implements Obstacle {
    private final String TYPE = "wall";
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void doIt(Participant participant) {
        participant.jump(height);
    }

    public String getType() {
        return TYPE;
    }
}
