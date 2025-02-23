package lesson1_6;

public class Animal {
    protected int maxRun;
    protected int maxSwim;
    protected double maxJump;

    public Animal() {
    }

    public void run(double length) {
        System.out.println("run: " + (length > maxRun)); //для остальных методов аналогично.
        // if (length > maxRun) {
        //     System.out.println("run: false");
        // } else {
        //     System.out.println("run: true");
        // }
    }

    public void swim(double length) {
        if (length > maxSwim) {
            System.out.println("swim: false");
        } else {
            System.out.println("swim: true");
        }
    }

    public void jump(double height) {
        if (height > maxJump) {
            System.out.println("jump: false");
        } else {
            System.out.println("jump: true");
        }
    }

    public int getMaxRun() {
        return maxRun;
    }

    public int getMaxSwim() {
        return maxSwim;
    }

    public double getMaxJump() {
        return maxJump;
    }
}
