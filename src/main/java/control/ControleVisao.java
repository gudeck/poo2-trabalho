/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import domain.*;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import vision.*;

/**
 *
 * @author gudeck
 */
public class ControleVisao {

    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        ControleVisao visaoCtrl = new ControleVisao();
        visaoCtrl.janelaPrincipal();

//        System.exit(0);
    }

    private ControleDominio dominioCtlr;
    private JFRPrincipal janelaPrincipal;

    public ControleVisao() {
        dominioCtlr = ControleDominio.getInstance();
    }

    public ControleDominio getControleDominio() {
        return dominioCtlr;
    }

    public void janelaPrincipal() {
        janelaPrincipal = new JFRPrincipal(this);
        janelaPrincipal.setLocationRelativeTo(null);
        janelaPrincipal.setResizable(false);
        janelaPrincipal.setSize(565, 327);
        janelaPrincipal.setVisible(true);
    }

    public void cadastroCliente() {
        JDGCadastroCliente cadastroCliente = JDGCadastroCliente.getInstance(janelaPrincipal, true, this);
        cadastroCliente.setLocationRelativeTo(null);
        cadastroCliente.setResizable(false);
        cadastroCliente.setVisible(true);
    }

    public Cliente buscaCliente() {
        JDGBuscaCliente buscaCliente = JDGBuscaCliente.getInstance(janelaPrincipal, true, this);
        buscaCliente.setLocationRelativeTo(null);
        buscaCliente.setResizable(false);
        buscaCliente.setVisible(true);

        return buscaCliente.getObjetoCliente();
    }

    public void cadastroCategoria() {
        JDGCadastroCategoria cadastroCategoria = JDGCadastroCategoria.getInstance(janelaPrincipal, true, this);
        cadastroCategoria.setLocationRelativeTo(null);
        cadastroCategoria.setResizable(false);
        cadastroCategoria.setVisible(true);
    }

    public Categoria buscaCategoria() {
        JDGBuscaCategoria buscaCategoria = JDGBuscaCategoria.getInstance(janelaPrincipal, true, this);
        buscaCategoria.setLocationRelativeTo(null);
        buscaCategoria.setResizable(false);
        buscaCategoria.setVisible(true);

        return buscaCategoria.getObjetoCategoria();
    }

    public void registrarReserva() {
        JDGRegistrarReserva registrarReserva = JDGRegistrarReserva.getInstance(janelaPrincipal, true, this);
        registrarReserva.setLocationRelativeTo(null);
        registrarReserva.setResizable(false);
        registrarReserva.setVisible(true);
    }

    public Produto buscaProduto() {
        JDGBuscaProduto buscaProduto = JDGBuscaProduto.getInstance(janelaPrincipal, true, this);
        buscaProduto.setLocationRelativeTo(null);
        buscaProduto.setResizable(false);
        buscaProduto.setVisible(true);

        return buscaProduto.getObjetoProduto();
    }

    public void registrarDevolucao() {
        JDGRegistrarDevolucao registrarDevolucao = JDGRegistrarDevolucao.getInstance(janelaPrincipal, true, this);
        registrarDevolucao.setLocationRelativeTo(null);
        registrarDevolucao.setResizable(false);
        registrarDevolucao.setVisible(true);
    }

    public void registrarRetirada() {
        JDGRegistrarRetirada registrarMovimentacao = JDGRegistrarRetirada.getInstance(janelaPrincipal, true, this);
        registrarMovimentacao.setLocationRelativeTo(null);
        registrarMovimentacao.setResizable(false);
        registrarMovimentacao.setVisible(true);
    }

    public void cadastroProduto() {
        JDGCadastroProduto cadastroProduto = JDGCadastroProduto.getInstance(janelaPrincipal, true, this);
        cadastroProduto.setLocationRelativeTo(null);
        cadastroProduto.setResizable(false);
        cadastroProduto.setVisible(true);
    }

    public void registrarAvaliacaoProduto() {
        JDGRegistrarAvaliacaoProduto registrarAvaliacaoProduto = JDGRegistrarAvaliacaoProduto.getInstance(janelaPrincipal, true, this);
        registrarAvaliacaoProduto.setLocationRelativeTo(null);
        registrarAvaliacaoProduto.setResizable(false);
        registrarAvaliacaoProduto.setVisible(true);
    }

    public void preencherCombo(JComboBox combo, Class classe) {

        List lista = dominioCtlr.getGenericDao().read(classe);
        combo.setModel(new DefaultComboBoxModel(lista.toArray()));

    }

}
