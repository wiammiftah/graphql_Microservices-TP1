package ma.enset.accountservice.web;

import lombok.AllArgsConstructor;
import ma.enset.accountservice.dtos.BankAccountRequestDto;
import ma.enset.accountservice.dtos.BankAccountResponseDto;
import ma.enset.accountservice.entities.BankAccount;
import ma.enset.accountservice.repositories.BankAccountRepo;
import ma.enset.accountservice.service.BankAccountServiceImp;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountRestController {

    private BankAccountRepo repo;
    private BankAccountServiceImp bankAccountServiceImp;

    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return repo.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("Bank Account Not Found"));
    }

    @PostMapping("/bankAccounts")
    public BankAccountResponseDto save(@RequestBody BankAccountRequestDto requestDto){
        return bankAccountServiceImp.addAccount(requestDto);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount existingAccount = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Bank Account Not Found"));

        if (bankAccount.getBalance() != null) {
            existingAccount.setBalance(bankAccount.getBalance());
        }
        if (bankAccount.getAccountType() != null) {
            existingAccount.setAccountType(bankAccount.getAccountType());
        }
        if (bankAccount.getCurrency() != null) {
            existingAccount.setCurrency(bankAccount.getCurrency());
        }
        if (bankAccount.getCreatedAt() != null) {
            existingAccount.setCreatedAt(bankAccount.getCreatedAt());
        }

        return repo.save(existingAccount);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
        repo.deleteById(id);
    }


}
