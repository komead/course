package lesson2_1;

public interface Participant {
    void run(int distance);
    void jump(int height);
    boolean isFail();
    String getName();
}
