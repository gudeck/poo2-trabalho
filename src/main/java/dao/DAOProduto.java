/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Categoria;
import domain.Produto;
import domain.state.produto.EstadoProduto;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 *
 * @author gudeck
 */
public class DAOProduto extends GenericDAO {

    private static DAOProduto uniqueInstance;

    private DAOProduto() {
    }

    public static synchronized DAOProduto getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DAOProduto();
        }

        return uniqueInstance;
    }

    public List<Produto> readEstado(EstadoProduto estado) {
        List lista = null;
        Session sessao = null;

        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSESSIONFACTORY().openSession();
            sessao.getTransaction().begin();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();

            CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
            Root<Produto> root = criteria.from(Produto.class);
            criteria.select(root);
            criteria.where(builder.equal(root.get("estado"), estado));

            lista = sessao.createQuery(criteria).getResultList();

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

    public List<Produto> readTamanhoCategoria(String tamanho, Categoria categoria) {
        List lista = null;
        Session sessao = null;

        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSESSIONFACTORY().openSession();
            sessao.getTransaction().begin();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();

            CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
            Root<Produto> root = criteria.from(Produto.class);
            criteria.select(root);
            criteria.where(
                    builder.and(
                            builder.equal(root.get("tamanho"), tamanho),
                            builder.equal(root.get("categoria"), categoria))
            );

            lista = sessao.createQuery(criteria).getResultList();

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

    public List<Produto> readCategoria(Categoria categoria) {
        List lista = null;
        Session sessao = null;

        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSESSIONFACTORY().openSession();
            sessao.getTransaction().begin();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();

            CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
            Root<Produto> root = criteria.from(Produto.class);
            criteria.select(root);
            criteria.where(builder.equal(root.get("categoria"), categoria));

            lista = sessao.createQuery(criteria).getResultList();

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

}
