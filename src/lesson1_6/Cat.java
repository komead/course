package lesson1_6;

import java.util.Random;

public class Cat extends Animal {
    private static int count = 0;

    public Cat() {
        super();
        Random random = new Random();

        maxRun = 200 + random.nextInt(-100, 100);
        maxJump = 2 + random.nextDouble(-1, 1);

        count++;
    }

    @Override
    public void swim(double length) {
        System.out.println("Кот не умеет плавать");
    }

    public static int getCount() {
        return count;
    }
}
