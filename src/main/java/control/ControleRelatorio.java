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

    void relatorio(String nomeArquivo, Class<?> classe) {
        try {
            String caminho = "../report/" + nomeArquivo + ".jasper";

            InputStream relatorio = getClass().getResourceAsStream(caminho);
            Map<String, Object> parametros = new HashMap<String, Object>();
            JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(genericDao.read(classe));

            JasperPrint print;
            print = JasperFillManager.fillReport(relatorio, parametros, dados);

            if (print.getPages().size() > 0) {

                JasperViewer mostrarRelatorio = new JasperViewer(print, false);
                mostrarRelatorio.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Relatório vazio.");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "ERRO ao abrir relatório: " + erro);

        }
    }
}
