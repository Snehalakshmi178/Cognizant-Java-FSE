package Junit.Ex4;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        // Setup - executed before each test
        account = new BankAccount(100); // initial balance
        System.out.println("Setup done");
    }

    @After
    public void tearDown() {
        // Teardown - executed after each test
        account = null;
        System.out.println("Teardown done");
    }

    @Test
    public void testDeposit() {
        // Arrange
        int depositAmount = 50;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(150, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        // Arrange
        int withdrawAmount = 40;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(60, account.getBalance());
    }

    @Test
    public void testWithdrawTooMuch() {
        // Arrange
        int withdrawAmount = 200;

        // Act
        account.withdraw(withdrawAmount); // should not allow

        // Assert
        assertEquals(100, account.getBalance()); // balance unchanged
    }
}
