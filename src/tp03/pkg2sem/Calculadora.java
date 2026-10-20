/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp03.pkg2sem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author cavia
 */
public class Calculadora extends JFrame {
    
    public Calculadora()
    {
        setTitle("Calculadora");
        setSize(250, 340);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Painel principal
        setLayout(new BorderLayout(5, 5));

        // Visor da calculadora
        JTextField visor = new JTextField();
        visor.setEditable(false);
        visor.setHorizontalAlignment(JTextField.RIGHT);
        visor.setFont(new Font("Arial", Font.PLAIN, 24));

        // Grid dos botões
        JPanel painel = new JPanel(new GridLayout(5, 4 , 5, 5));

        String[] teclas = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "+", "0", "=", ".","C"
        };

        for (String tecla : teclas) {
              JButton botao = new JButton(tecla);
                botao.setFont(new Font("Arial",Font.BOLD,18));
                
     botao.addActionListener(e -> {
    if (tecla.equals("C")) {
        visor.setText("");
    }
    else if (tecla.equals("=")) {
        try {
            String expressao = visor.getText();

            char operador = ' ';
            int posicao = -1;

            for (int i = 1; i < expressao.length(); i++) {
                char caractere = expressao.charAt(i);

                if (caractere == '+' || caractere == '-'
                        || caractere == '*' || caractere == '/') {
                    operador = caractere;
                    posicao = i;
                    break;
                }
            }

            if (posicao != -1) {
                double num1 = Double.parseDouble(
                    expressao.substring(0, posicao)
                );

                double num2 = Double.parseDouble(
                    expressao.substring(posicao + 1)
                );

                double resultado = 0;

                switch (operador) {
                    case '+':
                        resultado = num1 + num2;
                        break;
                    case '-':
                        resultado = num1 - num2;
                        break;
                    case '*':
                        resultado = num1 * num2;
                        break;
                    case '/':
                        if (num2 == 0) {
                            throw new ArithmeticException();
                        }
                        resultado = num1 / num2;
                        break;
                }

                visor.setText(String.valueOf(resultado));
            }
        } catch (ArithmeticException ex) {
            visor.setText("Erro: divisão por zero");
        } catch (Exception ex) {
            visor.setText("Expressão inválida");
        }
    }
    else {
        visor.setText(visor.getText() + tecla);
    }
});
                painel.add(botao);
        }

        add(visor, BorderLayout.NORTH);
        add(painel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }    
}
