package ma.enset.accountservice.entities;

import ma.enset.accountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = BankAccount.class)
public interface BankAccountProjection {
    public String getId();
    public AccountType getAccountType();
}
