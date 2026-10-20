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
 * @author Alexandre Zampieri e Caio Andrade
 */
public class FormPessoa2 extends JFrame {
 
    private Pessoa UmaPessoa;
 
    public FormPessoa2()
    {
        setTitle("CadastroPessoas - Versao 02");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        setLayout(new BorderLayout(5, 5));
 
        JPanel painel = new JPanel(new GridLayout(4, 2, 5, 5));
        JLabel lNumero = new JLabel("Numero:");
        JLabel lNome = new JLabel("Nome:");
        JLabel lSexo = new JLabel("Sexo:");
        JLabel lIdade = new JLabel("Idade:");
 
        JTextField txtNumero = new JTextField();
        JTextField txtNome = new JTextField();
        // Item vazio no inicio: mantem o campo obrigatorio
        JComboBox<String> cmbSexo = new JComboBox<>(new String[] { "", "M", "F" });
        JTextField txtIdade = new JTextField();
 
        txtNumero.setEditable(false);
 
        painel.add(lNumero);
        painel.add(txtNumero);
        painel.add(lNome);
        painel.add(txtNome);
        painel.add(lSexo);
        painel.add(cmbSexo);
        painel.add(lIdade);
        painel.add(txtIdade);
 
        JPanel painelBotoes = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton btnOk = new JButton("OK");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnSair = new JButton("Sair");
 
        painelBotoes.add(btnOk);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnMostrar);
        painelBotoes.add(btnSair);
 
        add(painel, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);
 
        // OK
        btnOk.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String sexo = (String) cmbSexo.getSelectedItem();
            String idadeTxt = txtIdade.getText().trim();
 
            if (nome.isEmpty() || sexo == null || sexo.isEmpty() || idadeTxt.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha Nome, Sexo e Idade.");
                return;
            }
 
            int idade;
            try {
                idade = Integer.parseInt(idadeTxt);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Idade inválida.");
                return;
            }
 
            UmaPessoa = new Pessoa(nome, sexo.charAt(0), idade);
            txtNumero.setText(String.valueOf(UmaPessoa.getKp()));
 
            txtNome.setText("");
            cmbSexo.setSelectedIndex(0);
            txtIdade.setText("");
            txtNome.requestFocus();
        });
 
        // Limpar
        btnLimpar.addActionListener(e -> {
            txtNumero.setText("");
            txtNome.setText("");
            cmbSexo.setSelectedIndex(0);
            txtIdade.setText("");
            txtNome.requestFocus();
        });
 
        // Mostrar
        btnMostrar.addActionListener(e -> {
            if (UmaPessoa == null) {
                JOptionPane.showMessageDialog(this, "Nenhuma pessoa cadastrada ainda.");
                return;
            }
            txtNumero.setText(String.valueOf(UmaPessoa.getKp()));
            txtNome.setText(UmaPessoa.getNome());
            cmbSexo.setSelectedItem(String.valueOf(UmaPessoa.getSexo()));
            txtIdade.setText(String.valueOf(UmaPessoa.getIdade()));
        });
 
        // Sair
        btnSair.addActionListener(e -> System.exit(0));
 
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                txtNome.requestFocusInWindow();
            }
        });
        setLocationRelativeTo(null);
        setVisible(true);
    }
}