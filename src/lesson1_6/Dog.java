package lesson1_6;

import java.util.Random;

public class Dog extends Animal {
    private static int count = 0;

    public Dog() {
        super();
        Random random = new Random();

        maxRun = 500 + random.nextInt(-100, 100);
        maxSwim = 10 + random.nextInt(-5, 5);
        maxJump = 0.5 + random.nextDouble(-0.3, 0.3);
        count++;
    }

    public static int getCount() {
        return count;
    }
}
