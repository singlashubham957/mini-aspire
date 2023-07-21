package mini.aspire.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Repayment {
    @NonNull
    private int id;
    private String date;
    private Double amount;
    private RepaymentStatus status;
}
