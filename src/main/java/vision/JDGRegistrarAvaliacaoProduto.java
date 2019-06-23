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
        jPanel1.add(rdbEmManutencao, new java.awt.GridBagConstraints());

        grpEstadoProduto.add(rdbEmLoja);
        rdbEmLoja.setText("Em Loja");
        jPanel1.add(rdbEmLoja, new java.awt.GridBagConstraints());

        grpEstadoProduto.add(rdbEmDanoPermanente);
        rdbEmDanoPermanente.setText("Em Dano Permanente");
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

        btnEmLoja.setText("Em Loja");

        btnDanoPermanente.setText("Dano Permanente");

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
