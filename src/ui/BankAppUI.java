/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

/**
 *
 * @author jhona
 */

import bank.BankAccountProxy;

import javax.swing.*;
import java.awt.*;

public class BankAppUI extends JFrame {
    private JTextField inputPassword;
    private JTextField inputAmount;
    private JLabel resultLabel;
    private BankAccountProxy accountProxy;

    public BankAppUI() {
        // Crear cuenta con saldo inicial
        accountProxy = new BankAccountProxy(1000.0);

        // Configuración de la ventana
        setTitle("Sistema Bancario - Patrón Proxy");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Colores y diseño
        getContentPane().setBackground(new Color(45, 45, 45)); // Fondo oscuro
        Font font = new Font("Arial", Font.BOLD, 16);

        // Etiqueta y campo para contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(20, 20, 120, 30);
        add(passwordLabel);

        inputPassword = new JTextField();
        inputPassword.setBounds(150, 20, 300, 30);
        inputPassword.setBackground(new Color(200, 200, 200));
        add(inputPassword);

        JButton authButton = new JButton("Autenticar");
        authButton.setBounds(20, 60, 430, 30);
        authButton.setBackground(new Color(70, 130, 180));
        authButton.setForeground(Color.WHITE);
        authButton.setFont(font);
        add(authButton);

        // Etiqueta y campo para cantidad
        JLabel amountLabel = new JLabel("Monto:");
        amountLabel.setForeground(Color.WHITE);
        amountLabel.setBounds(20, 120, 120, 30);
        add(amountLabel);

        inputAmount = new JTextField();
        inputAmount.setBounds(150, 120, 300, 30);
        inputAmount.setBackground(new Color(200, 200, 200));
        add(inputAmount);

        JButton withdrawButton = new JButton("Retirar");
        withdrawButton.setBounds(20, 160, 430, 30);
        withdrawButton.setBackground(new Color(255, 69, 0));
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.setFont(font);
        add(withdrawButton);

        JButton balanceButton = new JButton("Consultar Saldo");
        balanceButton.setBounds(20, 200, 430, 30);
        balanceButton.setBackground(new Color(34, 139, 34));
        balanceButton.setForeground(Color.WHITE);
        balanceButton.setFont(font);
        add(balanceButton);

        // Etiqueta para mostrar resultados
        resultLabel = new JLabel("Resultado:");
        resultLabel.setForeground(Color.WHITE);
        resultLabel.setBounds(20, 260, 460, 30);
        add(resultLabel);

        // Acciones de botones
        authButton.addActionListener(e -> {
            String password = inputPassword.getText();
            accountProxy.authenticate(password);
            resultLabel.setText("Autenticación realizada.");
        });

        withdrawButton.addActionListener(e -> {
            String amountText = inputAmount.getText();
            try {
                double amount = Double.parseDouble(amountText);
                String result = accountProxy.withdraw(amount);
                resultLabel.setText(result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Ingrese un monto válido.");
            }
        });

        balanceButton.addActionListener(e -> {
            String result = accountProxy.checkBalance();
            resultLabel.setText(result);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankAppUI app = new BankAppUI();
            app.setVisible(true);
        });
    }
}

