package mini.aspire.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AddLoanRequest {
    int userId;
    Double amount;
    List<Repayment> repayments;
    int loanTermInWeeks;
}
