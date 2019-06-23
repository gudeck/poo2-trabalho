/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Aluguel;
import domain.Cliente;
import domain.Produto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author gudeck
 */
public class DAOAluguel extends GenericDAO {

    private static DAOAluguel uniqueInstance;

    private DAOAluguel() {
    }

    public static synchronized DAOAluguel getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DAOAluguel();
        }

        return uniqueInstance;
    }

    public List<Produto> readRoupas(Cliente cliente, Aluguel aluguel) {

        List<Produto> lista = null;
        Session sessao = null;

        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            lista = sessao.createNativeQuery(
                    "select "
                    + "p.* "
                    + "from "
                    + "anarrie.aluguel a "
                    + "inner join "
                    + "anarrie.cliente c on a.codCliente = c.codCliente "
                    + "and c.codCliente = " + cliente.getCodCliente() + " "
                    + "and a.codAluguel = " + aluguel.getCodAluguel() + " "
                    + "inner join "
                    + "anarrie.produtoalugado pa on a.codAluguel = pa.codAluguel "
                    + "inner join "
                    + "anarrie.produto p on pa.codProduto = p.codProduto;",
                    Produto.class).list();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }

            throw new HibernateException(ex);
        }
        return lista;

    }

    public List<Aluguel> readAluguelEstadoIndireto(Cliente cliente, String estado) {
        List lista = null;
        Session sessao = null;

        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            lista = sessao.createNativeQuery(
                    "select "
                    + "a.* "
                    + "from "
                    + "anarrie.aluguel a "
                    + "inner join "
                    + "anarrie.cliente c on a.codCliente = c.codCliente "
                    + "and c.codCliente = " + cliente.getCodCliente() + " "
                    + "inner join "
                    + "anarrie.estadoaluguel ea on ea.codEstado = a.codEstado "
                    + "and ea.DTYPE not like '%" + estado + "%';",
                    Aluguel.class).list();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }

            throw new HibernateException(ex);
        }
        return lista;
    }

    public Aluguel readAluguelEstadoDireto(Cliente cliente, String estado) {
        List lista = null;
        Session sessao = null;

        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            lista = sessao.createNativeQuery(
                    "select "
                    + "a.* "
                    + "from "
                    + "anarrie.aluguel a "
                    + "inner join "
                    + "anarrie.cliente c on a.codCliente = c.codCliente "
                    + "and c.codCliente = " + cliente.getCodCliente() + " "
                    + "inner join "
                    + "anarrie.estadoaluguel ea on ea.codEstado = a.codEstado "
                    + "and ea.DTYPE like '%" + estado + "%';",
                    Aluguel.class).list();

            sessao.getTransaction().commit();
            sessao.close();
        } catch (HibernateException ex) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
                sessao.close();
            }

            throw new HibernateException(ex);
        }
        return (Aluguel) lista.get(0);
    }

}
