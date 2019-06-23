/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vision;

import control.ControleVisao;
import domain.Aluguel;
import domain.Cliente;
import domain.Produto;
import domain.ProdutoAlugado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author liviaaurich
 */
public class JDGRegistrarDevolucao extends javax.swing.JDialog {

    private static JDGRegistrarDevolucao uniqueInstance;

    private final ControleVisao controladorVisao;
    private Cliente cliente;
    private Aluguel aluguel;
    private List<ProdutoAlugado> resultadoBusca;

    private JDGRegistrarDevolucao(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        super(parent, modal);
        initComponents();
        controladorVisao = controlador;
    }

    public static synchronized JDGRegistrarDevolucao getInstance(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        if (uniqueInstance == null) {
            uniqueInstance = new JDGRegistrarDevolucao(parent, modal, controlador);
        }

        uniqueInstance.setModal(modal);
        return uniqueInstance;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpEstado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rdbPerfeito = new javax.swing.JRadioButton();
        rdbDanificado = new javax.swing.JRadioButton();
        rdbDanoPermanente = new javax.swing.JRadioButton();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Devolução");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        txtNome.setEnabled(false);

        btnBuscarCliente.setText("...");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Tamanho", "Descrição", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);
        if (tblProduto.getColumnModel().getColumnCount() > 0) {
            tblProduto.getColumnModel().getColumn(0).setPreferredWidth(6);
            tblProduto.getColumnModel().getColumn(1).setPreferredWidth(1);
            tblProduto.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jPanel2.add(jScrollPane1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado"));

        grpEstado.add(rdbPerfeito);
        rdbPerfeito.setMnemonic('1');
        rdbPerfeito.setText("Perfeito");
        rdbPerfeito.setEnabled(false);
        jPanel3.add(rdbPerfeito);

        grpEstado.add(rdbDanificado);
        rdbDanificado.setMnemonic('2');
        rdbDanificado.setText("Danificado");
        rdbDanificado.setEnabled(false);
        jPanel3.add(rdbDanificado);

        grpEstado.add(rdbDanoPermanente);
        rdbDanoPermanente.setMnemonic('3');
        rdbDanoPermanente.setText("Dano Permanente");
        rdbDanoPermanente.setEnabled(false);
        jPanel3.add(rdbDanoPermanente);

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalvar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        cliente = controladorVisao.buscaCliente();
        txtNome.setText(cliente.toString());

        aluguel = controladorVisao.getControleDominio().aluguelReadDireto(cliente, "emaberto");

        if (aluguel == null) {
            JOptionPane.showMessageDialog(this, "O usuário não possui aluguéis a serem devolvidos.");
        } else {

            DefaultTableModel tabela = (DefaultTableModel) tblProduto.getModel();
            resultadoBusca = aluguel.getProdutosAlugados();
            tabela.setRowCount(0);

            for (ProdutoAlugado pa : resultadoBusca) {
                tabela.addRow(new Object[]{
                    pa.getProduto().getNome(),
                    pa.getProduto().getTamanho(),
                    pa.getProduto().getDescricao(),
                    pa.getProduto().getEstado()
                });
            }

            rdbDanificado.setEnabled(true);
            rdbDanoPermanente.setEnabled(true);
            rdbPerfeito.setEnabled(true);
            btnSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        grpEstado.clearSelection();
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        DefaultTableModel tabela = (DefaultTableModel) tblProduto.getModel();
        Integer linhaSelecionada = tblProduto.getSelectedRow();
        if (linhaSelecionada > -1) {

            Produto produto = resultadoBusca.get(linhaSelecionada).getProduto();

            if (rdbPerfeito.isSelected()) {
                produto.setEstado(produto.getEstado().setEmManutencao());
                tabela.removeRow(linhaSelecionada);
            } else if (rdbDanificado.isSelected()) {
                produto.setEstado(produto.getEstado().setEmManutencao());
                aluguel.setValorTotal(aluguel.getValorTotal() + produto.getValorDiaria() * 0.5);
                tabela.removeRow(linhaSelecionada);
            } else if (rdbDanoPermanente.isSelected()) {
                produto.setEstado(produto.getEstado().setDanoPermanente());
                aluguel.setValorTotal(aluguel.getValorTotal() + produto.getValorDanoPermanente());
                tabela.removeRow(linhaSelecionada);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um estado.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Selecione ao menos um registro da tabela!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        DefaultTableModel tabela = (DefaultTableModel) tblProduto.getModel();
        if (tabela.getRowCount() == 0) {

            System.out.println("\n\n\n\n\n" + resultadoBusca.get(0).getProduto().getEstado().getClass());
            JOptionPane.showMessageDialog(this, "Todos os produtos desse aluguel foram avaliados.");
            JOptionPane.showMessageDialog(this, "O valor a ser pago é: " + (aluguel.getValorTotal() - aluguel.getValorPago()));
            aluguel.setValorPago(aluguel.getValorTotal());
            aluguel.setEstado(aluguel.getEstado().setFechado());
            controladorVisao.getControleDominio().aluguelUpdate(aluguel);

            tabela.setRowCount(0);
            resultadoBusca.clear();
            aluguel = null;
            cliente = null;
            txtNome.setText("");
        }

    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup grpEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbDanificado;
    private javax.swing.JRadioButton rdbDanoPermanente;
    private javax.swing.JRadioButton rdbPerfeito;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
