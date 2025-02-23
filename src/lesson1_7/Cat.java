package lesson1_7;

public class Cat {
    private final int MAX_satiety;
    private boolean satiety;
    
    public Cat(int MAX_satiety) {
        this.MAX_satiety = MAX_satiety;
        this.satiety = false; //по 3 условию задачи
    }

    public int eat(int foodInBowl) {
        if (satiety || foodInBowl < MAX_satiety){
            return 0;
        }
        //this.satiety = !this.satiety; //если он поест второй раз, то будет не суперсыт, а голоден.
        this.satiety = true; 
        return MAX_satiety;
    }

    public void status() {
        System.out.println(satiety ? "Кот сыт" : "Кот голоден"); //идея вроде как сама такое тебе должна предложить из написанного ниже
        // if (satiety)
        //     System.out.println("Кот сыт");
        // else
        //     System.out.println("Кот голоден");
    }
}
