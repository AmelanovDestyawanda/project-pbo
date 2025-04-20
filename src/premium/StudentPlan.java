package premium;

public class StudentPlan extends PremiumPlan {
    private String studentEmail;

    public StudentPlan(String name, double price, String studentEmail) {
        super(name, price);
        this.studentEmail = studentEmail;
    }

    public String getStudentemail(){
        return studentEmail;
    }
    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    @Override
    public String getInfo() {
        return name + " Plan - Email Mahasiswa: " + studentEmail +
               ", Harga: Rp" + (int)price +
               ", Diskon: " + discount + "%, Terjual: " + sold;
    }
}