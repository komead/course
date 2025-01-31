package lesson1_7;

public class Cat {
    private final int MAX_satiety;
    private boolean satiety;

    public Cat(int MAX_satiety) {
        this.MAX_satiety = MAX_satiety;
    }

    public int eat(int foodInBowl) {
        if (satiety || foodInBowl < MAX_satiety){
            return 0;
        }
        this.satiety = !this.satiety;
        return MAX_satiety;
    }

    public void status() {
        if (satiety)
            System.out.println("Кот сыт");
        else
            System.out.println("Кот голоден");
    }
}
