abstract class Person {
    String name;
    double salary;

    public Person(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void hike_Salary(double percentage);

    public void display_data() {
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Employee extends Person {
    public Employee(String name, double salary) {
        super(name, salary);
    }

    public void hike_Salary(double percentage) {
        if (percentage < 0) {
            throw new IllegalArgumentException("Percentage cannot be negative");
        }
        salary += (salary * percentage) / 100;
    }
}

class Manager extends Employee {
    public Manager(String name, double salary) {
        super(name, salary);
    }

    public void hike_Salary(double percentage) {
        super.hike_Salary(percentage);
        salary += 5000;
    }
}

public class Main{
    public static void main(String[] args) {
        Person[] persons = new Person[2];
        persons[0] = new Employee("John", 50000);
        persons[1] = new Manager("Jane", 80000);

        try {
            for (Person person : persons) {
                person.hike_Salary(10);
                person.display_data();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}