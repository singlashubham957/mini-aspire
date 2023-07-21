package mini.aspire.data;

import mini.aspire.models.Loan;
import mini.aspire.models.LoanStatus;
import mini.aspire.models.Repayment;
import mini.aspire.models.RepaymentStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public class LoanDao {
    private int incrementalId = 1;
    private final List<Loan> loans;

    public LoanDao(List<Loan> loans) {
        this.loans = loans;
    }

    public Loan getLoanById(int id) throws Exception {
        Optional<Loan> loan = loans.stream().filter(it -> it.getId() == id).findFirst();
        if (loan.isEmpty()) throw new Exception("loan: $id does not exist");
        return loan.get();
    }

    public int addLoan(int userId, Double amount, List<Repayment> repayments, int loanTermInWeeks) throws Exception {
        Loan loan = new Loan(userId, incrementalId++, amount, repayments, loanTermInWeeks, LoanStatus.Pending);
        loans.add(loan);
        return loan.getId();
    }

    public List<Loan> getAllLoansByUserId(int userId) {
        Stream<Loan> loan = loans.stream().filter(it -> it.getUserId() == userId);
        return loan.toList();
    }

    public boolean updateLoanStatusToApproved(int loanId) throws Exception {
        Optional<Loan> loan = loans.stream().filter(it -> it.getId() == loanId).findFirst();
        if (loan.isEmpty()) throw new Exception("loan: $id does not exist");
        loan.get().setStatus(LoanStatus.Approved);
        return true;
    }

    public boolean updateRepaymentStatusToPaid(int loanId, int repaymentId) throws Exception {
        Optional<Loan> loan = loans.stream().filter(it -> it.getId() == loanId).findFirst();
        if (loan.isEmpty()) throw new Exception("loan: $id does not exist");
        Optional<Repayment> repayment = loan.get().getRepayments().stream().filter(it -> it.getId() == repaymentId).findFirst();
        if (repayment.isEmpty()) throw new Exception("repayment: $id does not exist");
        repayment.get().setStatus(RepaymentStatus.Repaid);
        return true;
    }
}
