/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import control.ControleVisao;
import domain.Produto;
import domain.state.produto.DanoPermanente;
import domain.state.produto.EmAluguel;
import domain.state.produto.EmLoja;
import domain.state.produto.EmManutencao;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gudeck
 */
public class JDGRegistrarAvaliacaoProduto extends javax.swing.JDialog {

    private static JDGRegistrarAvaliacaoProduto UNIQUEINSTANCE;

    private final ControleVisao controladorVisao;
    private List<Produto> resultadoBusca;

    private JDGRegistrarAvaliacaoProduto(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        super(parent, modal);
        initComponents();
        controladorVisao = controlador;
    }

    public static synchronized JDGRegistrarAvaliacaoProduto getInstance(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        if (UNIQUEINSTANCE == null) {
            UNIQUEINSTANCE = new JDGRegistrarAvaliacaoProduto(parent, modal, controlador);
        }

        UNIQUEINSTANCE.setModal(modal);
        return UNIQUEINSTANCE;
    }

    private void atualizaTabela(List<Produto> resultadoBusca) {
        DefaultTableModel tabela = (DefaultTableModel) tblProdutos.getModel();

        tabela.setRowCount(0);

        if (!resultadoBusca.isEmpty() || resultadoBusca != null) {
            tblProdutos.setEnabled(true);
            tblProdutos.setEnabled(true);
            resultadoBusca.forEach((p) -> {
                tabela.addRow(new Object[]{
                    p.getNome(),
                    p.getEstado()
                });
            });
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpEstadoProduto = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdbEmManutencao = new javax.swing.JRadioButton();
        rdbEmLoja = new javax.swing.JRadioButton();
        rdbEmDanoPermanente = new javax.swing.JRadioButton();
        rdbEmAluguel = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnEmManutencao = new javax.swing.JButton();
        btnEmLoja = new javax.swing.JButton();
        btnDanoPermanente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Estado do Produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualizar Produtos"));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.GridLayout(2, 2));

        grpEstadoProduto.add(rdbEmManutencao);
        rdbEmManutencao.setText("Em Manutenção");
        rdbEmManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEmManutencaoActionPerformed(evt);
            }
        });
        jPanel1.add(rdbEmManutencao);

        grpEstadoProduto.add(rdbEmLoja);
        rdbEmLoja.setText("Em Loja");
        rdbEmLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEmLojaActionPerformed(evt);
            }
        });
        jPanel1.add(rdbEmLoja);

        grpEstadoProduto.add(rdbEmDanoPermanente);
        rdbEmDanoPermanente.setText("Em Dano Permanente");
        rdbEmDanoPermanente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEmDanoPermanenteActionPerformed(evt);
            }
        });
        jPanel1.add(rdbEmDanoPermanente);

        rdbEmAluguel.setText("EmAluguel");
        rdbEmAluguel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEmAluguelActionPerformed(evt);
            }
        });
        jPanel1.add(rdbEmAluguel);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Estado"
            }
        ));
        tblProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblProdutos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblProdutos);

        btnEmManutencao.setMnemonic('M');
        btnEmManutencao.setText("Em Manutenção");
        btnEmManutencao.setEnabled(false);
        btnEmManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmManutencaoActionPerformed(evt);
            }
        });

        btnEmLoja.setMnemonic('L');
        btnEmLoja.setText("Em Loja");
        btnEmLoja.setEnabled(false);
        btnEmLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmManutencaoActionPerformed(evt);
            }
        });

        btnDanoPermanente.setMnemonic('D');
        btnDanoPermanente.setText("Dano Permanente");
        btnDanoPermanente.setEnabled(false);
        btnDanoPermanente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmManutencaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEmManutencao, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEmLoja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDanoPermanente))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmManutencao)
                    .addComponent(btnEmLoja)
                    .addComponent(btnDanoPermanente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbEmManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEmManutencaoActionPerformed

        btnDanoPermanente.setEnabled(true);
        btnEmLoja.setEnabled(true);
        btnEmManutencao.setEnabled(false);

        resultadoBusca = controladorVisao.getControleDominio().produtoReadEstado(EmManutencao.getInstance());
        atualizaTabela(resultadoBusca);

    }//GEN-LAST:event_rdbEmManutencaoActionPerformed

    private void rdbEmLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEmLojaActionPerformed

        btnDanoPermanente.setEnabled(true);
        btnEmLoja.setEnabled(false);
        btnEmManutencao.setEnabled(true);

        resultadoBusca = controladorVisao.getControleDominio().produtoReadEstado(EmLoja.getInstance());
        atualizaTabela(resultadoBusca);

    }//GEN-LAST:event_rdbEmLojaActionPerformed

    private void rdbEmDanoPermanenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEmDanoPermanenteActionPerformed

        btnDanoPermanente.setEnabled(false);
        btnEmLoja.setEnabled(true);
        btnEmManutencao.setEnabled(true);

        resultadoBusca = controladorVisao.getControleDominio().produtoReadEstado(DanoPermanente.getInstance());
        atualizaTabela(resultadoBusca);

    }//GEN-LAST:event_rdbEmDanoPermanenteActionPerformed

    private void btnEmManutencaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmManutencaoActionPerformed

        DefaultTableModel tabela = (DefaultTableModel) tblProdutos.getModel();
        Integer linhaSelecionada = tblProdutos.getSelectedRow();

        if (linhaSelecionada > -1) {

            Produto produto = resultadoBusca.get(linhaSelecionada);

            resultadoBusca.remove(produto);

            switch (((JButton) evt.getSource()).getMnemonic()) {
                case 'M':
                    produto.setEstado(produto.getEstado().setEmManutencao());
                    break;
                case 'L':
                    produto.setEstado(produto.getEstado().setEmLoja());
                    break;
                case 'D':
                    produto.setEstado(produto.getEstado().setDanoPermanente());
                    break;
            }

            controladorVisao.getControleDominio().produtoUpdate(produto);
            tabela.removeRow(linhaSelecionada);

        } else {
            JOptionPane.showMessageDialog(this, "Selecione ao menos uma linha da tabela.");
        }
    }//GEN-LAST:event_btnEmManutencaoActionPerformed

    private void rdbEmAluguelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEmAluguelActionPerformed
        btnDanoPermanente.setEnabled(false);
        btnEmLoja.setEnabled(false);
        btnEmManutencao.setEnabled(false);

        resultadoBusca = controladorVisao.getControleDominio().produtoReadEstado(EmAluguel.getInstance());
        atualizaTabela(resultadoBusca);
    }//GEN-LAST:event_rdbEmAluguelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanoPermanente;
    private javax.swing.JButton btnEmLoja;
    private javax.swing.JButton btnEmManutencao;
    private javax.swing.ButtonGroup grpEstadoProduto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbEmAluguel;
    private javax.swing.JRadioButton rdbEmDanoPermanente;
    private javax.swing.JRadioButton rdbEmLoja;
    private javax.swing.JRadioButton rdbEmManutencao;
    private javax.swing.JTable tblProdutos;
    // End of variables declaration//GEN-END:variables
}
