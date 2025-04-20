package premium;

public class FamilyPlan extends PremiumPlan {
    private int memberCount;

    public FamilyPlan(String name, double price, double discount, int sold, int memberCount) {
        super(name, price);
        setMemberCount(memberCount);
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    @Override
    public String getInfo() {
        return name + "Plan (Max 6 Users) - " +
               "Anggota: " + memberCount +
               ", Harga: Rp" + (int)price +
               ", Diskon: " + discount + "%, Terjual: " + sold;
    }
}
