/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;

/**
 *
 * @author jhona
 */

public class RealBankAccount implements BankAccount {
    private double balance;

    public RealBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public String withdraw(double amount) {
        if (amount > balance) {
            return "Saldo insuficiente.";
        }
        balance -= amount;
        return "Retiro exitoso. Saldo actual: $" + balance;
    }

    @Override
    public String checkBalance() {
        return "Saldo actual: $" + balance;
    }
}

