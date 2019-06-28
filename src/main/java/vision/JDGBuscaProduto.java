/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import control.ControleVisao;
import domain.Categoria;
import domain.Produto;
import domain.state.produto.EmAluguel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 *
 * @author gudeck
 */
public class JDGBuscaProduto extends javax.swing.JDialog {

    private static JDGBuscaProduto uniqueInstance;

    private final ControleVisao controladorVisao;
    private List<Produto> resultadoBusca;
    private Produto objetoProduto;

    private JDGBuscaProduto(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        super(parent, modal);
        initComponents();
        controladorVisao = controlador;
    }

    public static synchronized JDGBuscaProduto getInstance(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        if (uniqueInstance == null) {
            uniqueInstance = new JDGBuscaProduto(parent, modal, controlador);
        }

        uniqueInstance.setModal(modal);
        return uniqueInstance;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpTamanho = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        rdbPP = new javax.swing.JRadioButton();
        rdbP = new javax.swing.JRadioButton();
        rdbM = new javax.swing.JRadioButton();
        rdbG = new javax.swing.JRadioButton();
        rdbGG = new javax.swing.JRadioButton();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnSelecionar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar Produto");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Diária", "D. Perma."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(1).setPreferredWidth(15);
            tblProduto.getColumnModel().getColumn(2).setPreferredWidth(15);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tamanho"));
        jPanel2.setLayout(new java.awt.GridLayout(1, 5));

        grpTamanho.add(rdbPP);
        rdbPP.setText("PP");
        rdbPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPPActionPerformed(evt);
            }
        });
        jPanel2.add(rdbPP);

        grpTamanho.add(rdbP);
        rdbP.setText("P");
        rdbP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPPActionPerformed(evt);
            }
        });
        jPanel2.add(rdbP);

        grpTamanho.add(rdbM);
        rdbM.setText("M");
        rdbM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPPActionPerformed(evt);
            }
        });
        jPanel2.add(rdbM);

        grpTamanho.add(rdbG);
        rdbG.setText("G");
        rdbG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPPActionPerformed(evt);
            }
        });
        jPanel2.add(rdbG);

        grpTamanho.add(rdbGG);
        rdbGG.setText("GG");
        rdbGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPPActionPerformed(evt);
            }
        });
        jPanel2.add(rdbGG);

        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPPActionPerformed(evt);
            }
        });

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Todos"));

        btnTodos.setText("...");
        btnTodos.setToolTipText("");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTodos))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSelecionar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        grpTamanho.clearSelection();
        cmbCategoria.setSelectedIndex(-1);
        DefaultTableModel tabela = (DefaultTableModel) tblProduto.getModel();
        tabela.setRowCount(0);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        controladorVisao.preencherCombo(cmbCategoria, Categoria.class);
    }//GEN-LAST:event_formComponentShown

    private void rdbPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPPActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) tblProduto.getModel();
        String tamanho = "";
        Categoria categoria = null;

        if (rdbPP.isSelected()) {
            tamanho = "PP";
        } else if (rdbP.isSelected()) {
            tamanho = "P";
        } else if (rdbM.isSelected()) {
            tamanho = "M";
        } else if (rdbG.isSelected()) {
            tamanho = "G";
        } else if (rdbGG.isSelected()) {
            tamanho = "G";
        } else {
            JOptionPane.showMessageDialog(this, "Selecione um tamanho.");
        }

        if (cmbCategoria.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma categoria.");
        } else {
            categoria = (Categoria) cmbCategoria.getSelectedItem();
        }

        resultadoBusca = controladorVisao.getControleDominio().produtoReadTamanhoCategoria(tamanho, categoria);

        tabela.setRowCount(0);

        if (!resultadoBusca.isEmpty()) {
            resultadoBusca.forEach((p) -> {
                tabela.addRow(new Object[]{p.getNome(),
                    p.getValorDiaria(),
                    p.getValorDanoPermanente()});
            });
        }
    }//GEN-LAST:event_rdbPPActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if (tblProduto.getSelectedRow() > -1) {
            DefaultTableModel tabela = (DefaultTableModel) tblProduto.getModel();
            objetoProduto = resultadoBusca.get(tblProduto.getSelectedRow());
            tabela.setRowCount(0);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione ao menos um registro da tabela!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) tblProduto.getModel();

        if (tblProduto.getSelectedRow() > -1) {
            if (controladorVisao.getControleDominio().produtoReadEstado(EmAluguel.getInstance()).size() > 0) {
                JOptionPane.showMessageDialog(this, "O produto selecionado não pode ser excluído por estar fora da loja.");
            } else {
                controladorVisao.getControleDominio().produtoDelete(resultadoBusca.get(tblProduto.getSelectedRow()));
                tabela.removeRow(tblProduto.getSelectedRow());
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!", "Delete", JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione ao menos um registro da tabela!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) tblProduto.getModel();

        resultadoBusca = controladorVisao.getControleDominio().produtoReadAll();

        tabela.setRowCount(0);

        if (!resultadoBusca.isEmpty()) {
            resultadoBusca.forEach((p) -> {
                tabela.addRow(new Object[]{p.getNome(),
                    p.getValorDiaria(),
                    p.getValorDanoPermanente()});
            });
        }
    }//GEN-LAST:event_btnTodosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton btnTodos;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.ButtonGroup grpTamanho;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbG;
    private javax.swing.JRadioButton rdbGG;
    private javax.swing.JRadioButton rdbM;
    private javax.swing.JRadioButton rdbP;
    private javax.swing.JRadioButton rdbPP;
    private javax.swing.JTable tblProduto;
    // End of variables declaration//GEN-END:variables

    public Produto getObjetoProduto() {
        return this.objetoProduto;
    }
}
