package exercise7;

class InsufficientFundsException extends Exception {
    // TODO: Add your implementation here.
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String message) {
        super(message);
    }
    // TODO: Add your implementation here.
}

class BankAccount {
    private final String accountHolder;
    private int balance;

    public BankAccount(String accountHolder, int initialBalance) {
        if(initialBalance < 0) {
            throw new NegativeAmountException("Initial balance cannot be negative");
        }
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        // TODO: Delete line below and write your own solution.
        if(amount < 0) {
            throw new NegativeAmountException("Deposit amount cannot be negative");
        }
        this.balance += amount;
    }

    public void withdraw(int amount) throws InsufficientFundsException {
        // TODO: Delete line below and write your own solution.
        if(amount < 0) {
            throw new NegativeAmountException("Withdrawal amount cannot be negative");
        }

        if(amount > balance) {
            throw new InsufficientFundsException("Insufficient funds to withdraw $" + amount);
        }
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return accountHolder + ": " + balance;
    }
}