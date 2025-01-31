package lesson1_7;

public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(30);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat(15);
        cats[1] = new Cat(9);
        cats[2] = new Cat(13);
        cats[3] = new Cat(10);

        feedTheCats(cats, bowl);
        bowl.fillBowl();
        System.out.println("..::Добавили еду в миску::..");
        feedTheCats(cats, bowl);
    }

    public static void feedTheCats(Cat[] cats, Bowl bowl) {
        for (int i = 0; i < cats.length; i++) {
            bowl.spendFood(cats[i].eat(bowl.getFood()));
            cats[i].status();
            System.out.println();
        }
    }
}
