package lesson2_1;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(new Obstacle[] {new Wall(3), new Cross(200)});
        Team team = new Team("team1", new Participant[]{new Human("Victor", 5, 1000),
                                                                new Robot("R2D2", 1, 100),
                                                                new Cat("Мурзик", 3, 200)});

        course.doIt(team);
        team.showResults(); // результаты всей команды
        team.showWinners(); // вывод участников, которые прошли все испытания
    }
}
