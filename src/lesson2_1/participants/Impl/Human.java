package lesson2_1.participants.Impl;

import lesson2_1.participants.Participant;

public class Human implements Participant {
    private String name;
    private final int MAX_JUMP;
    private final int MAX_RUN;
    private boolean fail;

    public Human(String name, int MAX_JUMP, int MAX_RUN) {
        this.name = name;
        this.MAX_JUMP = MAX_JUMP;
        this.MAX_RUN = MAX_RUN;
    }

    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println(name + " успешно пробежал дистанцию");
        } else {
            System.out.println(name + " не смог пробежать дистанцию");
            fail = true;
        }
    }

    public void jump(int height) {
        if (height <= MAX_JUMP) {
            System.out.println(name + " успешно перепрыгнул препятствие");
        } else {
            System.out.println(name + " не смог перепрыгнуть препятствие");
            fail = true;
        }
    }

    public boolean isFail() {
        return fail;
    }

    public String getName() {
        return name;
    }
}
