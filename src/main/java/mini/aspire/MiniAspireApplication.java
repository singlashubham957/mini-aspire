package mini.aspire;

import mini.aspire.models.Repayment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;

@SpringBootApplication
public class MiniAspireApplication {
    public static void main(String[] args) {
        ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(true);

        SpringApplication.run(MiniAspireApplication.class, args);
        Repayment r = new Repayment();
        System.out.println(r.getId());
        System.out.println(r.getAmount());
        System.out.println(r.getDate());
    }
}
