package lesson1_5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String number;
    private int patch;
    private int age;

    public Employee(String fullName, String position, String email, String number, int patch, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.number = number;
        this.patch = patch;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void print() {
        System.out.println(
                "\nФИО: " + fullName +
                "\nДолжность: " + position +
                "\nПочта: " + email +
                "\nНомер телефона: " + number +
                "\nЗарплата: " + patch +
                "\nВозраст: " + age);
    }
}
