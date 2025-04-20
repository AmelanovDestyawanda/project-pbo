package premium;

public class PremiumPlan {
    protected String name;
    protected double price;
    protected double discount;
    protected int sold;

    public PremiumPlan(String name, double price) {
        setName(name);
        setPrice(price); 
        setDiscount(0);
        setSold(0);;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getDiscount(){
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public int getSold(){
        return sold;
    }
    public void setSold(int sold) {
        this.sold = sold;
    }
    public void applyDiscount(double discount) {
        this.discount = discount;
        System.out.println("Diskon " + discount + "% diterapkan ke " + name + " plan.");
    }

    public double getFinalPrice() {
        return price * (1 - discount / 100);
    }

    public void sell(int quantity) {
        sold += quantity;
        System.out.println(quantity + "x " + name + " plan terjual.");
    }
    public double getRevenue() {
        return getFinalPrice() * sold;
    }
    public String getInfo() {
        return name + " Plan - Harga: Rp" + (int)price + ", \nDiskon: " + discount + "%, \nTerjual: " + sold;
    }
}