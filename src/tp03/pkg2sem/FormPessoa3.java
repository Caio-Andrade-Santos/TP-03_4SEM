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
public class FormPessoa3 extends JFrame{
    private Pessoa UmaPessoa;
 
    public FormPessoa3()
    {
        setTitle("CadastroPessoas - Versao 03");
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
        JTextField txtIdade = new JTextField();
 
        // Sexo: dois JRadioButton, nenhum selecionado no inicio (campo obrigatorio)
        JRadioButton rbM = new JRadioButton("M");
        JRadioButton rbF = new JRadioButton("F");
        ButtonGroup grupoSexo = new ButtonGroup();   // garante selecao exclusiva
        grupoSexo.add(rbM);
        grupoSexo.add(rbF);
 
        JPanel painelSexo = new JPanel(new GridLayout(1, 2));
        painelSexo.add(rbM);
        painelSexo.add(rbF);
 
        txtNumero.setEditable(false);
 
        painel.add(lNumero);
        painel.add(txtNumero);
        painel.add(lNome);
        painel.add(txtNome);
        painel.add(lSexo);
        painel.add(painelSexo);
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
            String idadeTxt = txtIdade.getText().trim();
 
            String sexo = "";
            if (rbM.isSelected()) {
                sexo = "M";
            } else if (rbF.isSelected()) {
                sexo = "F";
            }
 
            if (nome.isEmpty() || sexo.isEmpty() || idadeTxt.isEmpty()) {
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
            grupoSexo.clearSelection();
            txtIdade.setText("");
            txtNome.requestFocus();
        });
 
        // Limpar
        btnLimpar.addActionListener(e -> {
            txtNumero.setText("");
            txtNome.setText("");
            grupoSexo.clearSelection();
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
            if (UmaPessoa.getSexo() == 'M') {
                rbM.setSelected(true);
            } else {
                rbF.setSelected(true);
            }
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
