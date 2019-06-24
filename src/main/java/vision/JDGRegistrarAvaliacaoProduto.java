/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import control.ControleVisao;

/**
 *
 * @author gudeck
 */
public class JDGRegistrarAvaliacaoProduto extends javax.swing.JDialog {

    private static JDGRegistrarAvaliacaoProduto uniqueInstance;

    private final ControleVisao controladorVisao;

    private JDGRegistrarAvaliacaoProduto(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        super(parent, modal);
        initComponents();
        controladorVisao = controlador;
    }

    public static synchronized JDGRegistrarAvaliacaoProduto getInstance(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        if (uniqueInstance == null) {
            uniqueInstance = new JDGRegistrarAvaliacaoProduto(parent, modal, controlador);
        }

        uniqueInstance.setModal(modal);
        return uniqueInstance;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpEstadoProduto = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        rdbEmManutencao = new javax.swing.JRadioButton();
        rdbEmLoja = new javax.swing.JRadioButton();
        rdbEmDanoPermanente = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        btnEmManutencao = new javax.swing.JButton();
        btnEmLoja = new javax.swing.JButton();
        btnDanoPermanente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Estado do Produto");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualizar Produtos"));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new java.awt.GridBagLayout());

        grpEstadoProduto.add(rdbEmManutencao);
        rdbEmManutencao.setText("Em Manutenção");
        rdbEmManutencao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEmManutencaoActionPerformed(evt);
            }
        });
        jPanel1.add(rdbEmManutencao, new java.awt.GridBagConstraints());

        grpEstadoProduto.add(rdbEmLoja);
        rdbEmLoja.setText("Em Loja");
        rdbEmLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEmLojaActionPerformed(evt);
            }
        });
        jPanel1.add(rdbEmLoja, new java.awt.GridBagConstraints());

        grpEstadoProduto.add(rdbEmDanoPermanente);
        rdbEmDanoPermanente.setText("Em Dano Permanente");
        rdbEmDanoPermanente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbEmDanoPermanenteActionPerformed(evt);
            }
        });
        jPanel1.add(rdbEmDanoPermanente, new java.awt.GridBagConstraints());

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Estado"
            }
        ));
        tblProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tblProdutos);

        btnEmManutencao.setText("Em Manutenção");
        btnEmManutencao.setEnabled(false);

        btnEmLoja.setText("Em Loja");
        btnEmLoja.setEnabled(false);

        btnDanoPermanente.setText("Dano Permanente");
        btnDanoPermanente.setEnabled(false);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    }//GEN-LAST:event_rdbEmManutencaoActionPerformed

    private void rdbEmLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEmLojaActionPerformed

        btnDanoPermanente.setEnabled(true);
        btnEmLoja.setEnabled(false);
        btnEmManutencao.setEnabled(true);

    }//GEN-LAST:event_rdbEmLojaActionPerformed

    private void rdbEmDanoPermanenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbEmDanoPermanenteActionPerformed

        btnDanoPermanente.setEnabled(false);
        btnEmLoja.setEnabled(true);
        btnEmManutencao.setEnabled(true);

    }//GEN-LAST:event_rdbEmDanoPermanenteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanoPermanente;
    private javax.swing.JButton btnEmLoja;
    private javax.swing.JButton btnEmManutencao;
    private javax.swing.ButtonGroup grpEstadoProduto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbEmDanoPermanente;
    private javax.swing.JRadioButton rdbEmLoja;
    private javax.swing.JRadioButton rdbEmManutencao;
    private javax.swing.JTable tblProdutos;
    // End of variables declaration//GEN-END:variables
}
