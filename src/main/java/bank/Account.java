package bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Account {

	private int accountNumber;
	private BigDecimal balance;
	private List<Operation> operations;

	public Account() {
		this.balance = new BigDecimal(0);
		this.operations = new ArrayList<>();
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public void deposit(BigDecimal amount) throws OperationException {
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new OperationException("Deposit amount should be positive.");
		}
		balance = balance.add(amount);
		operations.add(Operation.deposit(LocalDate.now(), amount, balance));

	}

	public void withdrawal(BigDecimal amount) throws OperationException{
		if (amount.compareTo(BigDecimal.ZERO) < 0) {
			throw new OperationException("Withdraw amount should be positive.");
		}

		if (balance.compareTo(amount) >= 0) {
			balance = balance.subtract(amount);
			operations.add(Operation.withdrawal(LocalDate.now(), amount.negate(), balance));

		} else {
			throw new OperationException("Insufficient funds to withdraw.");

		}

	}

	public void printOperations() {
		Logger logger = Logger.getLogger(Account.class.getName()) ;
		for (Operation operation : getOperations()) {
			logger.info(operation.toString());
		}
	}

}
