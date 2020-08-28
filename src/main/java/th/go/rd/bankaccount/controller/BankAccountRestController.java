package th.go.rd.bankaccount.controller;

import org.springframework.web.bind.annotation.*;
import th.go.rd.bankaccount.data.BankAccountRepository;
import th.go.rd.bankaccount.model.BankAccount;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountRestController {

    private BankAccountRepository repository;

    public BankAccountRestController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<BankAccount> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getOne(@PathVariable int id){
        return repository.findById(id).get();
    }
    
    @PostMapping
    public BankAccount creade(@RequestBody BankAccount bankaccount){
        repository.save(bankaccount);
        return bankaccount;
    }
}
