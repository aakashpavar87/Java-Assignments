abstract class Thali{
    protected double totalPrice;
    public Thali() {
        this.totalPrice = 0.0;
    }
    abstract public void addSabji(double price);
    abstract public void addDal(double price);
    abstract public void addRice(double price);
    abstract public void addRoti(double price);
    public void makeThali() {
        System.out.println("Veg Thali will be ready in 30 minutes.!!!");
        System.out.println("*********************");
    }
    abstract public double getPrice(); 
    abstract protected void setPrice();
}
class GujaratiThali extends Thali{
    public double sevTomato;
    public double sweetDal;
    public double basmatiRice;
    public double fulkaRoti;

    public void addSabji(double sevT) {
        System.out.println("Added Sev Tomato Subji Rs: "+sevT);
        sevTomato = sevT;
    }
    public void addDal(double dal) {
        System.out.println("Added Sweet Dal Rs: "+dal);
        sweetDal = dal;
    }
    public void addRice(double rice) {
        System.out.println("Added Rice Rs: "+rice);
        basmatiRice = rice;
    }
    public void addRoti(double roti) {
        System.out.println("Added Rotis Rs: "+roti);
        fulkaRoti = roti;
    }
    public void setPrice() {
        totalPrice = sevTomato+sweetDal+basmatiRice+fulkaRoti;
    }
    public double getPrice() {
        return totalPrice;
    }
    public void displayBill() {
        System.out.println("********Total Gujarati Bill************");
        System.out.println("Sabji Sev Tomato : "+ sevTomato);
        System.out.println("Dal Sweet Tuver Dal : "+ sweetDal);
        System.out.println("Rice Basmati : "+ basmatiRice);
        System.out.println("Roti Chapati : "+ fulkaRoti);
        System.out.println("================================");
        System.out.println("Total Bill Amount : "+ getPrice());
        System.out.println("================================");
    }
    
}
class PunjabiThali extends Thali{
    public double palakPaneer;
    public double spicyDal;
    public double khichdi;
    public double paratha;

    public void addSabji(double palakP) {
        System.out.println("Added Palak Paneer Subji Rs: "+palakP);
        palakPaneer = palakP;
    }
    public void addDal(double dal) {
        System.out.println("Added Spicy Dal Rs: "+dal);
        spicyDal = dal;
    }
    public void addRice(double rice) {
        System.out.println("Added Khichdi Rs: "+rice);
        khichdi = rice;
    }
    public void addRoti(double roti) {
        System.out.println("Added Paratha Rs: "+roti);
        paratha = roti;
    }
    public void setPrice() {
        totalPrice = palakPaneer+spicyDal+khichdi+paratha;
    }
    public double getPrice() {
        return totalPrice;
    }
    public void displayBill() {
        System.out.println("********Total Punjabi Bill************");
        System.out.println("Sabji Palak Paneer : "+ palakPaneer);
        System.out.println("Mixed Dal : "+ spicyDal);
        System.out.println("Punjabi Khichdi : "+ khichdi);
        System.out.println("Paratha : "+ paratha);
        System.out.println("================================");
        System.out.println("Total Bill Amount : "+ getPrice());
        System.out.println("================================");
    }
}
abstract class BaseThaliRestaurant{
    GujaratiThali gujju = new GujaratiThali();
    PunjabiThali paji = new PunjabiThali();
    abstract void createGujaratiThali();
    abstract void createPunjabiThali();

}
class ThaliRestuarant extends BaseThaliRestaurant{
    public void createGujaratiThali() {
        gujju.addDal(25);
        gujju.addRice(35);
        gujju.addRoti(20);
        gujju.addSabji(30);
    }
    public void getPunjabiPrice() {
        System.out.println("Punjabi Thali Price is : " + paji.getPrice());
    }
    public void getGujaratiPrice() {
        System.out.println("Gujarati Thali Price is : " + gujju.getPrice());
    }
    public void createPunjabiThali() {
        paji.addDal(30);
        paji.addRice(20);
        paji.addRoti(35);
        paji.addSabji(45);
    }

}
public class Question2{
    public static void main(String[] args) {
        System.out.println("\t\tName : Aakash Pavar Roll No : 3057");
        ThaliRestuarant basicThali = new ThaliRestuarant();
        basicThali.createGujaratiThali();
        basicThali.gujju.makeThali();
        basicThali.gujju.setPrice();
        
        basicThali.createPunjabiThali();
        basicThali.paji.makeThali();
        basicThali.paji.setPrice();

        basicThali.getGujaratiPrice();
        basicThali.getPunjabiPrice();
        System.out.println("-------------------------------");
        basicThali.gujju.displayBill();
        basicThali.paji.displayBill();
    }
}