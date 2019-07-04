/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import dao.GenericDAO;
import domain.Aluguel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author guzuc
 */
class ControleRelatorio {

    private static final ControleRelatorio UNIQUEINSTANCE = new ControleRelatorio();
    private final GenericDAO genericDao;

    private ControleRelatorio() {

        genericDao = GenericDAO.getInstance();

    }

    public static ControleRelatorio getInstance() {
        return UNIQUEINSTANCE;
    }

    void relatorioAlugueis() {
        try {
            // PASSO 1 - Caminho do relatório
            InputStream rel = getClass().getResourceAsStream("../report/RelatorioAlugueis.jasper");

            // PASSO 2 - Criar parâmetros de Pesquisa 
            Map parametros = new HashMap();

            // PASSO 3 - Carregar o relatório com os dados
            JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(genericDao.read(Aluguel.class));
            JasperPrint print;
            print = JasperFillManager.fillReport(rel,
                    parametros,
                    dados);

            if (print.getPages().size() > 0) {
                // PASSO 4 - Mostrat em uma JANELA

                // Cria o JasperViewer
                JasperViewer jrViewer = new JasperViewer(print, false);
                jrViewer.setVisible(true);

                // Criar uma janela MODAL e colocar o JasperView dentro dela
//                JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
//                viewer.setSize(800, 600);
//                viewer.setLocationRelativeTo(null);
//                viewer.getContentPane().add(jrViewer.getContentPane());
//                viewer.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Relatório de clientes vazio.");
            }

        } catch (JRException erro) {
            JOptionPane.showMessageDialog(null, "ERRO ao abrir relatório de clientes. " + erro.getMessage());

        }

    }
}
