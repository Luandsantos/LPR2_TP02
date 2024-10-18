package TP02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AlunoForm extends JFrame {
    private List<Aluno> alunos;

    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField enderecoField;

    public AlunoForm() {
        alunos = new ArrayList<>(); 

        setTitle("Cadastro de Alunos");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(3, 2, 10, 10)); 
        
        panelSuperior.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panelSuperior.add(nomeField);

        panelSuperior.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        panelSuperior.add(idadeField);

        panelSuperior.add(new JLabel("Endereço:"));
        enderecoField = new JTextField();
        panelSuperior.add(enderecoField);

        add(panelSuperior, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(1, 4, 10, 10)); // 1x4, hgap=10, vgap=10

        JButton okButton = new JButton("Ok");
        JButton limparButton = new JButton("Limpar");
        JButton mostrarButton = new JButton("Mostrar");
        JButton sairButton = new JButton("Sair");

        panelInferior.add(okButton);
        panelInferior.add(limparButton);
        panelInferior.add(mostrarButton);
        panelInferior.add(sairButton);

        add(panelInferior, BorderLayout.SOUTH);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAluno();
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlunos();
            }
        });

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void cadastrarAluno() {
        String nome = nomeField.getText();
        int idade;
        idade = Integer.parseInt(idadeField.getText());
        String endereco = enderecoField.getText();

        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setEndereco(endereco);
        aluno.setUuid(UUID.randomUUID());

        alunos.add(aluno);

        JOptionPane.showMessageDialog(this, "Aluno cadastrado com sucesso.");
        limparCampos();
    }

    private void limparCampos() {
        nomeField.setText("");
        idadeField.setText("");
        enderecoField.setText("");
    }

    private void mostrarAlunos() {
        if (alunos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum aluno cadastrado.");
            return;
        }

        StringBuilder mensagem = new StringBuilder("Lista de Alunos:\n");
        for (Aluno aluno : alunos) {
            mensagem.append("ID: ").append(aluno.getUuid()).append(", Nome: ").append(aluno.getNome()).append("\n");
        }

        JOptionPane.showMessageDialog(this, mensagem.toString());
    }

    public static void main(String[] args) {
        AlunoForm form = new AlunoForm();
        form.setVisible(true);
    }
}
