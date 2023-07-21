package mini.aspire.services;

import mini.aspire.data.LoanDao;
import mini.aspire.models.Loan;
import mini.aspire.models.Repayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanDao loanDao;

    public Loan getLoanById(int id) throws Exception {
        return loanDao.getLoanById(id);
    }

    public int addLoan(int userId, Double amount, List<Repayment> repayments, int loanTermInWeeks) throws Exception {
        return loanDao.addLoan(userId, amount, repayments, loanTermInWeeks);
    }

    public List<Loan> getAllLoansByUserId(int userId) {
        return loanDao.getAllLoansByUserId(userId);
    }

    public boolean updateLoanStatusToApproved(int loanId) throws Exception {
        return loanDao.updateLoanStatusToApproved(loanId);
    }

    public boolean updateRepaymentStatusToPaid(int loanId, int repaymentId) throws Exception {
        return loanDao.updateRepaymentStatusToPaid(loanId, repaymentId);
    }
}
