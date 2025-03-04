package lesson2_1;

import lesson2_1.obsracles.Course;
import lesson2_1.obsracles.Impl.Cross;
import lesson2_1.obsracles.Obstacle;
import lesson2_1.obsracles.Impl.Wall;
import lesson2_1.participants.*;
import lesson2_1.participants.Impl.Cat;
import lesson2_1.participants.Impl.Human;
import lesson2_1.participants.Impl.Robot;

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
