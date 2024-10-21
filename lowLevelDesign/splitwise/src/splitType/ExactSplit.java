package splitType;

import model.User;

public class ExactSplit extends Split {
    public ExactSplit(User user) {
        super(user);
    }

    @Override
    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }
}
