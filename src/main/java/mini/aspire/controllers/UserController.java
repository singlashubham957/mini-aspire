package mini.aspire.controllers;

import mini.aspire.models.AddLoanRequest;
import mini.aspire.models.Loan;
import mini.aspire.models.User;
import mini.aspire.services.LoanService;
import mini.aspire.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private LoanService loanService;

    @GetMapping("/aspire/user/{userId}")
    public User getUserById(@PathVariable("userId") int id) throws Exception {
        System.out.println("request for getUserById for userId: " + id);
        return userService.getUserById(id);
    }

    @GetMapping("/aspire/loan/{loanId}")
    public Loan getLoanById(@PathVariable("loanId") int id) throws Exception {
        System.out.println("request for getLoanById for loanId: " + id);
        return loanService.getLoanById(id);
    }

    @PostMapping("/aspire/loan")
    public int addLoan(@RequestBody AddLoanRequest addLoanRequest) throws Exception {
        System.out.println("request for addLoan request: " + addLoanRequest);
        return loanService.addLoan(addLoanRequest.getUserId(), addLoanRequest.getAmount(), addLoanRequest.getRepayments(), addLoanRequest.getLoanTermInWeeks());
    }

    @GetMapping("/aspire/user/{userId}/loan")
    public List<Loan> getAllLoansByUserId(@PathVariable("userId") int userId) {
        System.out.println("request for getAllLoansByUserId for userId: " + userId);
        return loanService.getAllLoansByUserId(userId);
    }
}
