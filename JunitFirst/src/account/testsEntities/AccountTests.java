package testsEntities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import testsFactory.AccountFactory;

public class AccountTests {

    @Test //DEPOSIT
    //Nomear como <AÇÃO> Should <EFEITO> [When <CENÁRIO>]
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {
        // Arrange: instancie os objetos necessários
        double amount = 200d;
        double expectedValue = 196d;
        Account account = AccountFactory.createEmptyAccount();
        // Act: execute as ações necessárias
        account.deposit(amount);
        // Assert: declare o que deveria acontecer (resultado esperado)
        Assertions.assertEquals(account.getBalance(), expectedValue);   
    }

    @Test //DEPOSIT < 0 DO NOTHING
    public void depositShouldDoNothingWhenSmallerThanZero() {
        double amount = 0d;
        double expectedValue = 0d;
        Account account = AccountFactory.createEmptyAccount();

        account.deposit(amount);
        
        Assertions.assertEquals(account.getBalance(), expectedValue);
    }

    @Test //WITHDRAW
    public void withdrawShouldDecreaseBalanceWhenValueSmallerThanBalance() {
        Account account = AccountFactory.createWithBalanceAccount(200d);

        account.withdraw(100d);
        
        Assertions.assertEquals(account.getBalance(), 100d);   
    
    }

    @Test //WITHDRAW WITH EXCEPTION
    public void withdrawShouldExceptionWhenValueGreaterThanBalance() {
        Account account = AccountFactory.createEmptyAccount();

        account.deposit(200d);

        Assertions.assertThrows(IllegalArgumentException.class, () -> account.withdraw(210d));
    }

    @Test // FULLWITHDRAW
    public void fullwithdrawShouldWithdrawFullBalanceAndReturnFullBalance() {
        double expectedValue = 0d;
        double initialBalance = 200d;
        Account account = AccountFactory.createWithBalanceAccount(initialBalance);

        double result = account.fullWithdraw();
        
        Assertions.assertEquals(account.getBalance(), expectedValue);
        Assertions.assertTrue(result == initialBalance);
    }
}
