/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank;

/**
 *
 * @author jhona
 */

public class BankAccountProxy implements BankAccount {
    private RealBankAccount realAccount;
    private boolean isAuthenticated;

    public BankAccountProxy(double initialBalance) {
        this.realAccount = new RealBankAccount(initialBalance);
        this.isAuthenticated = false; // Por defecto, no está autenticado
    }

    public void authenticate(String password) {
        if ("1234".equals(password)) {
            isAuthenticated = true;
        }
    }

    @Override
    public String withdraw(double amount) {
        if (!isAuthenticated) {
            return "Acceso denegado. Autentíquese primero.";
        }
        return realAccount.withdraw(amount);
    }

    @Override
    public String checkBalance() {
        if (!isAuthenticated) {
            return "Acceso denegado. Autentíquese primero.";
        }
        return realAccount.checkBalance();
    }
}

