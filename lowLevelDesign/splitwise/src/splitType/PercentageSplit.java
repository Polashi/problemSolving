package splitType;

import model.User;

public class PercentageSplit extends Split{
    private final double percent;
    @Override
    public double getAmount() {
        return amount;
    }

    public PercentageSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }
}
