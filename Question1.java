class Vehicle {
    private String name;
    private String manufacturer;

    public Vehicle(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public void startEngine() {
        System.out.println("Starting the engine of " + name);
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}

class Car extends Vehicle {
    private int numDoors;

    public Car(String name, String manufacturer, int numDoors) {
        super(name, manufacturer);
        this.numDoors = numDoors;
    }

    public void honkHorn() {
        System.out.println("Honking the horn of " + getName());
    }

    public int getNumDoors() {
        return numDoors;
    }
}

class SportsCar extends Car {
    private int topSpeed;

    public SportsCar(String name, String manufacturer, int numDoors, int topSpeed) {
        super(name, manufacturer, numDoors);
        this.topSpeed = topSpeed;
    }

    public void activateTurbo() {
        System.out.println("Activating turbo mode of " + getName());
    }

    public int getTopSpeed() {
        return topSpeed;
    }
}

public class Question1 {
    public static void main(String[] args) {
        System.out.println("\t\tName : Aakash Pavar Roll No: 3057");
        Vehicle vehicle = new Vehicle("Generic Vehicle", "Car Manufacturer");
        Car car = new Car("Maruti Van", "Maruti Suzuki", 4);
        SportsCar sportsCar = new SportsCar("Supra", "Toyota", 2, 400);

        // Starting the engines
        vehicle.startEngine();
        car.startEngine();
        sportsCar.startEngine();

        // Honking the horn (only applicable to cars)
        car.honkHorn();
        sportsCar.honkHorn();

        // Activating turbo (only applicable to sports cars)
        sportsCar.activateTurbo();

        // Displaying information
        System.out.println("Vehicle Information:");
        System.out.println("Name: " + vehicle.getName());
        System.out.println("Manufacturer: " + vehicle.getManufacturer());

        System.out.println("\nCar Information:");
        System.out.println("Name: " + car.getName());
        System.out.println("Manufacturer: " + car.getManufacturer());
        System.out.println("Number of Doors: " + car.getNumDoors());

        System.out.println("\nSports Car Information:");
        System.out.println("Name: " + sportsCar.getName());
        System.out.println("Manufacturer: " + sportsCar.getManufacturer());
        System.out.println("Number of Doors: " + sportsCar.getNumDoors());
        System.out.println("Top Speed: " + sportsCar.getTopSpeed() + " mph");
    }
}
