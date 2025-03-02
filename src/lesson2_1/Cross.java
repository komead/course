package lesson2_1;

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
