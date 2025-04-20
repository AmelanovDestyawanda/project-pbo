package premium;

public class IndividualPlan extends PremiumPlan {
    private boolean isStudent;

    public IndividualPlan(boolean isStudent) {
        super("Individual", 50000);
        this.isStudent = isStudent;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    @Override
    public String getInfo() {
        return name + " Plan (1 User)" +
               (isStudent ? " [Student]" : "") +
               " - Harga: Rp" + (int)price +
               ", Diskon: " + discount + "%, Terjual: " + sold;
    }
}