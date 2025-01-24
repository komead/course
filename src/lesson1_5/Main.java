package lesson1_5;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[5];

        employee[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employee[1] = new Employee("Aleksandrov Aleksandr", "Security", "sanya@mailbox.com", "1345692", 20000, 40);
        employee[2] = new Employee("Pavlovich Evgeniy", "Chillman", "geniy123@mailbox.com", "7562344", 10000, 44);
        employee[3] = new Employee("Marchuk Grigoriy", "Teacher", "magri77@mailbox.com", "1324689", 777777, 26);
        employee[4] = new Employee("Ivanov Alexey", "Programmer", "ivanov@mailbox.com", "9978452", 999999, 52);

        for (Employee emp : employee) {
            if (emp.getAge() > 40)
                emp.print();
        }
    }
}
