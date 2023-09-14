import java.util.Random;
import java.util.HashMap;

interface PizzaOrderSystem {
    int placeOrder(String pizzaType, int qnty);

    String checkOrderStatus(int orderId);

    boolean iscancelledOrder(int orderId);

    double calcOrderCost(int orderId);

    void listAvailablePizzas();
}

class PizzaOrderProcessor implements PizzaOrderSystem {
    public HashMap<String, Double> map = new HashMap<String, Double>();

    public PizzaOrderProcessor() {
        map.put("Double Cheez", 250.0);
        map.put("Margherita", 350.0);
        map.put("Veg Classic", 200.0);
        map.put("Mashroom Toppings", 400.0);
        map.put("Corn Pizza", 350.0);
        map.put("Spicy King extra Cheez", 450.0);
    }
    public static boolean isReady = false;
    protected int orderId;
    protected String pizzaType;
    protected int quantity;
    protected double cost;

    public int placeOrder(String pizzaType, int qnty) {
        this.pizzaType = pizzaType;
        this.quantity = qnty;

        Random ran = new Random();
        orderId = ran.nextInt(1000);
        isReady = true;
        System.out.println("Your order has placed for " + quantity + " " + this.pizzaType + " Pizza Successfully :)");
        System.out.println("Your order ID is : " + orderId);
        return orderId;
    }

    public String checkOrderStatus(int orderId) {
        if (isReady) {
            return "Your order will be ready in Few minutes :)";
        } else {
            return "Sorry but your order is not ready :(";
        }
    }

    public boolean iscancelledOrder(int orderId) {
        isReady = false;
        System.out.println("Your order has been cancelled.");
        return true;
    }

    public double calcOrderCost(int orderId) {
        cost = map.get(pizzaType) * quantity;
        return cost;
    }

    public void listAvailablePizzas() {
        System.out.println("*******List of Available Pizzas *******");
        for (HashMap.Entry<String, Double> e : map.entrySet()) {
            System.out.println(e.getKey() + "----------------------" + e.getValue());
        }
    }
}

class PizzaOrderSystemExample extends PizzaOrderProcessor {
    public void displayBill() {
        System.out.println("*****Total Bill******");
        System.out.println("Pizza : " + pizzaType);
        System.out.println("Quantity : " + quantity);
        System.out.println("Total Cost of Pizzas (in Rs): " + cost);
        System.out.println("Thank You come again :)");
    }
}

public class Question3 {

    public static void main(String[] args) {
        PizzaOrderSystemExample pizzaShop = new PizzaOrderSystemExample();
        // Question3 pizzaShop = new Question3();
        pizzaShop.listAvailablePizzas();
        // pizzaShop.placeOrder("Double Cheez", 2);
        pizzaShop.placeOrder("Corn Pizza", 3);
        pizzaShop.calcOrderCost(pizzaShop.orderId);
        pizzaShop.checkOrderStatus(pizzaShop.orderId);
        pizzaShop.displayBill();
    }
}
