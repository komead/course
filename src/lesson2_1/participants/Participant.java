package lesson2_1.participants;

public interface Participant {
    void run(int distance);
    void jump(int height);
    boolean isFail();
    String getName();
}
