package mini.aspire;

import mini.aspire.controllers.AdminController;
import mini.aspire.controllers.UserController;
import mini.aspire.models.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

@SpringBootTest
class MiniAspireTests {

    @Autowired
    private AdminController adminController;

    @Autowired
    private UserController userController;

    @Test
    void testCreateUser() throws Exception {
        AddUserRequest addUserRequest = new AddUserRequest();
        addUserRequest.setName("testUser");
        int userId = adminController.addUser(addUserRequest);
        User user = userController.getUserById(userId);
        assertThat(user.getName()).isEqualTo("testUser");
    }

    @Test
    void testCreateLoan() throws Exception {
        testCreateUser();
        Repayment repayment = new Repayment();
        repayment.setStatus(RepaymentStatus.Pending);
        repayment.setAmount(100.0);
        repayment.setId(1);
        repayment.setDate("someDate");

        AddLoanRequest addLoanRequest = new AddLoanRequest(1, 100.0, List.of(repayment), 3);

        int loanId = userController.addLoan(addLoanRequest);
        Loan loan = userController.getLoanById(loanId);
        assertThat(loan.getAmount()).isEqualTo(100);
    }

    @Test
    void testUpdateLoanToApproved() throws Exception {
        testCreateLoan();
        adminController.updateLoanStatusToApproved(1);
        Loan loan = userController.getLoanById(1);
        assertThat(loan.getStatus()).isEqualTo(LoanStatus.Approved);
    }

    @Test
    void testUpdateRepaymentToRepaid() throws Exception {
        testUpdateLoanToApproved();
        adminController.updateRepaymentStatusToPaid(1, 1);
        Loan loan = userController.getLoanById(1);
        assertThat(loan.getRepayments().get(0).getStatus()).isEqualTo(RepaymentStatus.Repaid);
    }

}
