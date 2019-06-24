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
import domain.state.aluguel.NaoRetirado;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gudeck
 */
public class JDGRegistrarRetirada extends javax.swing.JDialog {

    private static JDGRegistrarRetirada UNIQUEINSTANCE;

    private final ControleVisao controladorVisao;
    private Cliente cliente;
    private Aluguel aluguel;
    private List<Produto> resultadoBusca;

    private JDGRegistrarRetirada(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        super(parent, modal);
        initComponents();

        controladorVisao = controlador;
    }

    public static synchronized JDGRegistrarRetirada getInstance(java.awt.Frame parent, boolean modal, ControleVisao controlador) {
        if (UNIQUEINSTANCE == null) {
            UNIQUEINSTANCE = new JDGRegistrarRetirada(parent, modal, controlador);
        }

        UNIQUEINSTANCE.setModal(modal);
        return UNIQUEINSTANCE;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblRoupas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNomeCliente = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Retirada");
        setResizable(false);

        tblRoupas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Tamanho", "Descrição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRoupas.setEnabled(false);
        jScrollPane1.setViewportView(tblRoupas);
        if (tblRoupas.getColumnModel().getColumnCount() > 0) {
            tblRoupas.getColumnModel().getColumn(0).setMinWidth(5);
            tblRoupas.getColumnModel().getColumn(0).setPreferredWidth(5);
            tblRoupas.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        txtNomeCliente.setEnabled(false);

        btnBusca.setText("...");
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNomeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBusca))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnConfirmar.setText("Confirmar Retirada");
        btnConfirmar.setEnabled(false);
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 158, Short.MAX_VALUE)
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        cliente = null;
        cliente = controladorVisao.buscaCliente();

        System.out.println("\n\n" + cliente + "\n\n");
        DefaultTableModel tabela = (DefaultTableModel) tblRoupas.getModel();

        aluguel = null;
        aluguel = controladorVisao.getControleDominio().aluguelReadDireto(cliente, NaoRetirado.getInstance());
        tabela.setRowCount(0);
        if (aluguel != null) {
            if (aluguel.getProdutosAlugados().size() > 0) {
                resultadoBusca = (List) aluguel.getProdutosAlugados();
                txtNomeCliente.setText(cliente.toString());
                btnConfirmar.setEnabled(true);
                for (Produto pa : resultadoBusca) {
                    tabela.addRow(new Object[]{pa.getNome(),
                        pa.getTamanho(),
                        pa.getDescricao()});
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "O cliente selecionado não possui produtos a serem retirados.");
            aluguel = null;
            cliente = null;
            resultadoBusca = null;
        }
    }//GEN-LAST:event_btnBuscaActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed

        aluguel.setEstado(aluguel.getEstado().setEmAberto());
        for (Produto pa : resultadoBusca) {
            pa.setEstado(pa.getEstado().setEmAluguel());
        }
        controladorVisao.getControleDominio().aluguelUpdate(aluguel);
        JOptionPane.showMessageDialog(this, "Registro de retirada efetuado com sucesso.");

        cliente = null;
        aluguel = null;
        resultadoBusca = null;
        ((DefaultTableModel) tblRoupas.getModel()).setRowCount(0);
        txtNomeCliente.setText("");

    }//GEN-LAST:event_btnConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRoupas;
    private javax.swing.JTextField txtNomeCliente;
    // End of variables declaration//GEN-END:variables
}
