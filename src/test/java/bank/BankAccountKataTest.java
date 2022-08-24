package bank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankAccountKataTest {

	/**
	 * 
	 * US 1 : In order to save money, As a bank client I want to make a deposit in
	 * my account
	 */

	@Test
	public void test_deposit_with_negative_amount() {

		OperationException thrown = Assertions.assertThrows(OperationException.class, () -> {
			Account account = new Account();
			account.setAccountNumber(18121995);
			BigDecimal depositAmount = new BigDecimal(-1000);
			account.deposit(depositAmount);
		});

		Assertions.assertEquals("Deposit amount should be positive.", thrown.getMessageKey());

	}

	@Test
	public void test_deposit_with_positive_amount() throws OperationException {

		Account account = new Account();
		account.setAccountNumber(18121996);

		BigDecimal depositAmount = new BigDecimal(1000);
		account.deposit(depositAmount);

		BigDecimal depositSecondAmount = new BigDecimal(1000);
		account.deposit(depositSecondAmount);

		assertEquals(2000, account.getBalance().longValue());
	}

	/**
	 * 
	 * US 2 : In order to retrieve some or all of my savings As a bank client I want
	 * to make a withdrawal from my account
	 */

	@Test
	public void test_withdrawal_with_negative_amount() {

		OperationException thrown = Assertions.assertThrows(OperationException.class, () -> {
			Account account = new Account();
			account.setAccountNumber(18121997);
			BigDecimal withdrawalAmount = new BigDecimal(-1000);
			account.withdrawal(withdrawalAmount);
		});

		Assertions.assertEquals("Withdraw amount should be positive.", thrown.getMessageKey());

	}

	@Test
	public void test_withdrawal_with_positive_amount() throws OperationException {

		Account account = new Account();
		account.setAccountNumber(18121998);

		BigDecimal depositAmount = new BigDecimal(2000);
		account.deposit(depositAmount);

		BigDecimal withdrawalAmount = new BigDecimal(1000);
		account.withdrawal(withdrawalAmount);

		assertEquals(1000, account.getBalance().longValue());
	}

	@Test
	public void test_withdrawal_with_amount_greater_then_balance() {

		OperationException thrown = Assertions.assertThrows(OperationException.class, () -> {
			Account account = new Account();
			account.setAccountNumber(18121999);
			BigDecimal depositAmount = new BigDecimal(1000);
			account.deposit(depositAmount);

			BigDecimal withdrawalAmount = new BigDecimal(1200);
			account.withdrawal(withdrawalAmount);
		});

		Assertions.assertEquals("Insufficient funds to withdraw.", thrown.getMessageKey());

	}

	/**
	 * 
	 * US 3 : In order to check my operations As a bank client I want to see the
	 * history (operation, date, amount, balance) of my operations
	 * 
	 * @throws OperationException
	 */
	@Test
	public void test_print_operations() throws OperationException {

		Account account = new Account();
		account.setAccountNumber(18121990);
		BigDecimal depositAmount = new BigDecimal(3000);
		BigDecimal withdrawalAmount = new BigDecimal(1000);
		BigDecimal withdrawalAmount2 = new BigDecimal(500);
		BigDecimal depositAmount2 = new BigDecimal(2000);

		account.deposit(depositAmount);
		account.withdrawal(withdrawalAmount);
		account.withdrawal(withdrawalAmount2);
		account.deposit(depositAmount2);

		List<Operation> operations = account.getOperations();

		account.printOperations();

		assertEquals(4, operations.size());
		assertEquals(3500, account.getBalance().longValue());

	}

}
