package lesson1_6;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        System.out.printf("%d %d %.2f\n",dog1.getMaxRun(), dog1.getMaxSwim(), dog1.getMaxJump());
        dog1.run(540);
        dog1.swim(12);
        dog1.jump(0.3);

        Dog dog2 = new Dog();
        System.out.println(Dog.getCount());


        Cat cat1 = new Cat();
        cat1.run(240);
        cat1.swim(12);
        cat1.jump(1);
    }
}
