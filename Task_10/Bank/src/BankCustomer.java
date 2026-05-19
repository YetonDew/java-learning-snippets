public class BankCustomer {
    private final String name;
    private final Account wallet;

    public BankCustomer(Person personName)
    {
        this.name = personName.getName();
        this.wallet = new Account();
    }

    Account getAccount(){
        return wallet;
    }

    @Override
    public String toString() {
        return "Customer: " + name + " account balance " + wallet.getBalance();
    }
}
