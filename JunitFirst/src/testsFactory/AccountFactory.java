package testsFactory;

import entities.Account;

public class AccountFactory {

    public static Account createEmptyAccount() {
        return new Account(1L, 0d);
    }

    public static Account createWithBalanceAccount(double initialBalance) {
        return new Account(1L, initialBalance);
    }
    
}
