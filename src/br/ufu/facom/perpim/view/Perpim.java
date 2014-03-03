/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufu.facom.perpim.view;

import br.ufu.facom.frameworkpim.control.AbstractFactory;
import br.ufu.facom.frameworkpim.view.MainWindowFrame;
import br.ufu.facom.perpim.control.ConcreteFactory;
import br.ufu.facom.perpim.control.DisciplinaControl;
import javax.swing.JOptionPane;

/**
 *
 * @author Hugo
 */
public class Perpim extends MainWindowFrame {

    private javax.swing.JMenu periodoMenu = new javax.swing.JMenu();
    private javax.swing.JMenuItem cadastroDisciplina = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem cadastroEventroAvaliativo = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem disciplinaMenu = new javax.swing.JMenuItem();
    private javax.swing.JMenuItem pesquisaMenu = new javax.swing.JMenuItem();
    private CadastroDisciplina cadDisc;

    public Perpim(AbstractFactory factory) {
        super(factory);
        initComponents();
    }

    private void initComponents() {
        periodoMenu.setText("Periodo");
        cadastroDisciplina.setText("Cadastro de Disciplina");
        cadastroDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroDisciplina(evt);
            }
        });
        periodoMenu.add(cadastroDisciplina);

        cadastroEventroAvaliativo.setText("Cadastro Evento Avaliativo");
        cadastroEventroAvaliativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroEventoAvaliativo(evt);
            }
        });
        periodoMenu.add(cadastroEventroAvaliativo);

        disciplinaMenu.setText("Cadastro de Aluno");
        disciplinaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroAluno(evt);
            }
        });
        periodoMenu.add(disciplinaMenu);
        
        pesquisaMenu.setText("Pesquisa");
        pesquisaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisa(evt);
            }
        });
        periodoMenu.add(pesquisaMenu);
        
        this.menuBar.add(periodoMenu);
    }

    private void cadastroEventoAvaliativo(java.awt.event.ActionEvent evt) {
        if (DisciplinaControl.getDisciplinas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi encontrada nenhuma disciplina para cadastro de evento relacionado!", "Ops!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            CadastroEventoAvaliativo eventFrame = new CadastroEventoAvaliativo();//instancia a classe iFrmCliente
            desktopPane.add(eventFrame);//adiciona o cliente no seu JdesktopPane
            eventFrame.setLocation(400, 0);//colocar a tela iFrmCliente na posiÃ§Ã£o(0,0)
            eventFrame.setVisible(true);//deixa visÃ­vel
        }
    }

    private void cadastroDisciplina(java.awt.event.ActionEvent evt) {
        this.cadDisc = new CadastroDisciplina();
        this.desktopPane.add(this.cadDisc);
        this.cadDisc.setVisible(true);
    }

    private void cadastroAluno(java.awt.event.ActionEvent evt) {
        if (DisciplinaControl.getDisciplinas().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi encontrada nenhuma disciplina para cadastro de aluno relacionado!", "Ops!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            CadastroAluno cadastroAluno = new CadastroAluno();
            this.desktopPane.add(cadastroAluno);
            cadastroAluno.setVisible(true);
        }
    }
    
    private void pesquisa(java.awt.event.ActionEvent evt){
        Pesquisa pesquisa = new Pesquisa();
        this.desktopPane.add(pesquisa);
        pesquisa.setVisible(true);
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Perpim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Perpim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Perpim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Perpim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Perpim(new ConcreteFactory()).setVisible(true);
            }
        });
    }
}
