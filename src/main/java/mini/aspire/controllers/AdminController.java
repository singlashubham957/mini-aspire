package mini.aspire.controllers;

import mini.aspire.models.AddUserRequest;
import mini.aspire.services.LoanService;
import mini.aspire.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoanService loanService;

    @PostMapping("/aspire/user")
    public int addUser(@RequestBody AddUserRequest request) throws Exception {
        System.out.println("got request for adding user" + request);
        return userService.addUser(request.getName());
    }

    @PutMapping("/aspire/loan/{loanId}")
    public boolean updateLoanStatusToApproved(@PathVariable("loanId") int loanId) throws Exception {
        System.out.println("got request for updating loan status for loanId: " + loanId);
        return loanService.updateLoanStatusToApproved(loanId);
    }

    @PutMapping("/aspire/loan/{loanId}/repayment/{repaymentId}")
    public boolean updateRepaymentStatusToPaid(@PathVariable("loanId") int loanId, @PathVariable("repaymentId") int repaymentId) throws Exception {
        System.out.println("got request for updating repayment status for loanId: " + loanId + ", repaymentId " + repaymentId);
        return loanService.updateRepaymentStatusToPaid(loanId, repaymentId);
    }
}
