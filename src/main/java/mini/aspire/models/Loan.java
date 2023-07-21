package mini.aspire.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Loan {
    @NonNull
    private int id;
    private int userId;
    private Double amount;
    private List<Repayment> repayments;
    private int loanTermInWeeks;
    private LoanStatus status;
}
