import java.util.Scanner;

abstract class Amazon_item {
    protected int item_id;
    protected String product_type;
    protected String item_name;
    protected int item_display_price;
    protected int item_net_price;

    public Amazon_item(int item_id, String product_type, String item_name, int item_display_price) {
        this.item_id = item_id;
        this.product_type = product_type;
        this.item_name = item_name;
        this.item_display_price = item_display_price;
    }

    public abstract void calculate_net_price();

    public abstract void display_price();
}

class cloth_item extends Amazon_item {
    private String texture_type;

    public cloth_item(int item_id, String product_type, String item_name, int item_display_price, String texture_type) {
        super(item_id, product_type, item_name, item_display_price);
        this.texture_type = texture_type;
    }

    @Override
    public void calculate_net_price() {
        if (item_display_price > 5000) {
            item_net_price = (int) (item_display_price - (item_display_price * 0.15));
        } else if (item_display_price > 4000) {
            item_net_price = (int) (item_display_price - (item_display_price * 0.10));
        } else if (item_display_price > 3000) {
            item_net_price = (int) (item_display_price - (item_display_price * 0.05));
        } else {
            item_net_price = item_display_price;
        }
    }

    @Override
    public void display_price() {
        System.out.println("Item ID: " + item_id);
        System.out.println("Product Type: " + product_type);
        System.out.println("Item Name: " + item_name);
        System.out.println("Item Display Price: " + item_display_price);
        System.out.println("Texture Type: " + texture_type);
        System.out.println("Item Net Price: " + item_net_price);
    }
}

public class main_application {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter details for Cloth Item 1:");
            System.out.print("Item ID: ");
            int item_id1 = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Product Type: ");
            String product_type1 = scanner.nextLine();

            System.out.print("Item Name: ");
            String item_name1 = scanner.nextLine();

            System.out.print("Item Display Price: ");
            int item_display_price1 = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Texture Type: ");
            String texture_type1 = scanner.nextLine();

            System.out.println("Enter details for Cloth Item 2:");
            System.out.print("Item ID: ");
            int item_id2 = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Product Type: ");
            String product_type2 = scanner.nextLine();

            System.out.print("Item Name: ");
            String item_name2 = scanner.nextLine();

            System.out.print("Item Display Price: ");
            int item_display_price2 = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Texture Type: ");
            String texture_type2 = scanner.nextLine();

            cloth_item cloth_item1 = new cloth_item(item_id1, product_type1, item_name1, item_display_price1,
                    texture_type1);
            cloth_item cloth_item2 = new cloth_item(item_id2, product_type2, item_name2, item_display_price2,
                    texture_type2);

            cloth_item1.calculate_net_price();
            cloth_item2.calculate_net_price();

            System.out.println("Details of Cloth Item 1:");
            cloth_item1.display_price();

            System.out.println("Details of Cloth Item 2:");
            cloth_item2.display_price();
        } catch (Exception e) {
            System.out.println("Error occurred while scanning data.");
            e.printStackTrace();
        }
    }
}