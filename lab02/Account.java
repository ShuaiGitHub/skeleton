/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

	private int balance;
	private Account parent;

	/** Initialize an account with the given BALANCE. */
	public Account(int balance) {
		this.balance = balance;
		this.parent = null;
	}
	public Account(int balance,Account Parent) {
		this.balance = balance;
		this.parent = Parent;
	}

	/** Return the number of dollars in the account. */
	public int getBalance() {
		return this.balance;
	}
	public Account getParent(){
		return this.parent;
	}

	/** Deposits AMOUNT into the current account. */
	public void deposit(int amount) {
		if (amount < 0) {
			System.out.println("Cannot deposit negative amount.");
		} else {
			this.balance = this.balance + amount;
		}
	}

	/** Subtract AMOUNT from the account if possible. If subtracting AMOUNT
	 *	would leave a negative balance, print an error message and leave the
	 *	balance unchanged.
	 */
	public boolean withdraw(int amount) {
		if (amount < 0) {
			System.out.println("Cannot withdraw negative amount.");
			return false;
		} else if (this.balance < amount) {
			int residual = amount-this.balance;
			Account tmp = this.parent;
			System.out.println("overdraft protection begins!");
			while (residual > 0 && tmp != null){// Go up to find where the parent is
				residual = residual - tmp.getBalance();// See if full balance satifies
				tmp = tmp.parent;
			}
			if (residual > 0) {
			System.out.println("Insufficient funds");
			return false;
		}
		else {
			boolean flag = this.withdraw(this.getBalance());// first withdraw all money from existing account
			int tmp_residual = amount - this.balance;
			this.parent.withdraw(tmp_residual);
			return true;
		}
	}
		 else {
			this.balance = this.balance - amount;
			return true;
		}
	}

	/** Merge account OTHER into this account by removing all money from OTHER
	 *	and depositing it into this account.
     */
    public void merge(Account other) {
        // TODO Put your own code here
		int other_balance=other.getBalance();
		other.withdraw(other_balance);
		this.deposit(other_balance);
    }
}
