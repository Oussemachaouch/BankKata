package bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
		
	}

	public void withdrawal(BigDecimal amount) throws OperationException{

	}

	public void printOperations() {
		
	}

}
