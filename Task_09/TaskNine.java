public class TaskNine {

	public static class NoSuchCustomerException extends Exception {
		public NoSuchCustomerException() {
			super();
		}

		public NoSuchCustomerException(String message) {
			super(message);
		}

		public NoSuchCustomerException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static class NegativeAmountException extends Exception {
		public NegativeAmountException() {
			super();
		}

		public NegativeAmountException(String message) {
			super(message);
		}

		public NegativeAmountException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static class InsufficientFundsException extends Exception {
		public InsufficientFundsException() {
			super();
		}

		public InsufficientFundsException(String message) {
			super(message);
		}

		public InsufficientFundsException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static class BankruptcyException extends RuntimeException {
		public BankruptcyException() {
			super("Bank went bankrupt!!!");
		}

		public BankruptcyException(String message) {
			super(message);
		}

		public BankruptcyException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	public static class Customer {
		private final String name;
		private int balance = 100;

		public Customer(String name, int balance) {
			this.name = name;
			this.balance = balance;
		}

		public Customer(String name) {
			this.name = name;
		}

		void deposit(int amount) throws NegativeAmountException {
			if (amount < 0) {
				throw new NegativeAmountException("Cancelled: amount negative");
			}
			this.balance += amount;
		}

		void withdraw(int amount) throws NegativeAmountException, InsufficientFundsException {
			if (amount < 0) {
				throw new NegativeAmountException("Cancelled: amount negative");
			}
			if (amount > this.balance + Bank.MAX_DEBET) {
				throw new InsufficientFundsException("Cancelled: insufficient funds");
			}
			this.balance -= amount;
		}

		public String getName() {
			return this.name;
		}

		public int getBalance() {
			return this.balance;
		}
	}

	public static class Bank {
		public static final int MAX_DEBET = 50;
		private final Customer[] customers;

		public Bank(Customer[] customers) {
			this.customers = customers;
		}

		Customer getCustomerByName(String name) throws NoSuchCustomerException {
			for (Customer c : customers) {
				if (c != null && c.getName().equals(name)) {
					return c;
				}
			}
			throw new NoSuchCustomerException("Cancelled: No such customer: " + name);
		}

		void deposit(String name, int amount) {
			try {
				Customer target = getCustomerByName(name);
				target.deposit(amount);
				System.err.println(name + ": deposit " + amount);
			} catch (NoSuchCustomerException | NegativeAmountException e) {
				System.err.println(e.getMessage());
			}
		}

		void withdraw(String name, int amount) {
			try {
				Customer target = getCustomerByName(name);
				target.withdraw(amount);
				System.err.println(name + ": withdrawal " + amount);

				checkAssets();
			} catch (NoSuchCustomerException | NegativeAmountException | InsufficientFundsException e) {
				System.err.println(e.getMessage());
			}
		}

		private void checkAssets() {
			int total = 0;
			for (Customer c : customers) {
				if (c != null)
					total += c.getBalance();
			}
			if (total < 0) {
				throw new BankruptcyException("Bank went bankrupt!!!");
			}
		}
	}

	public static void main(String[] args) {
		Customer[] customers = {
				new Customer("Jane", 60), new Customer("John", 20),
				new Customer("Bill"), new Customer("Sue")
		};

		Bank bank = new Bank(customers);
		bank.deposit("Carol", 20);
		bank.deposit("Bill", 10);
		bank.withdraw("Jane", 110);
		bank.withdraw("Sue", 140);
		bank.deposit("Sue", -40);
		bank.deposit("John", 10);
		bank.withdraw("Jane", 50);
		bank.withdraw("Bill", 90);
	}
}
