package lesson1_7;

public class Bowl {
    private final int MAX_FOOD;
    private int food;

    public Bowl(int food) {
        this.MAX_FOOD = food;
    }

    public void fillBowl() {
        food = MAX_FOOD;
    }

    public int getFood() {
        return food;
    }

    public void spendFood(int food) {
        this.food -= food;
    }
}
