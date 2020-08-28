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
    public BankAccount create(@RequestBody BankAccount bankaccount){
        repository.save(bankaccount);
        return bankaccount;
    }

    @PutMapping("/balance/{id}")
    public BankAccount update(@PathVariable int id,@RequestBody BankAccount bankaccount){
        BankAccount record = repository.findById(id).get();
        record.setBalance(bankaccount.getBalance());

        repository.save(record);
        return record;
    }

    @GetMapping("/customer/{customerId}")
    public List<BankAccount> getAllCustomerId(@PathVariable int customerId){
        return repository.findByCustomerId(customerId);
    }

   @DeleteMapping("delete/{id}")
    public BankAccount delete(@PathVariable int id) {
        BankAccount record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }


}
