package ma.enset.accountservice.repositories;

import ma.enset.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BankAccountRepo extends JpaRepository<BankAccount, String> {
}
