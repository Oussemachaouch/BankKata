package bank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Operation {

	private LocalDate date;
	private BigDecimal amount;
	private BigDecimal balance;
	private OperationType operationType;

	private Operation(LocalDate date, BigDecimal amount, BigDecimal balance, OperationType operationType) {
		super();
		this.date = date;
		this.amount = amount;
		this.balance = balance;
		this.operationType = operationType;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public OperationType getOperationType() {
		return operationType;
	}

	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setCurrentBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public static Operation deposit(LocalDate executionDate, BigDecimal amount, BigDecimal balance) {
		return new Operation(executionDate, amount, balance, OperationType.DEPOSIT);
	}

	public static Operation withdrawal(LocalDate executionDate, BigDecimal amount, BigDecimal balance) {
		return new Operation(executionDate, amount, balance, OperationType.WITHDRAWAL);
	}

	@Override
	public String toString() {

		return getOperationType().toString() + " Operation on " + getDate() + " of " + getAmount() + " : Balance is "
				+ getBalance();

	}
}
