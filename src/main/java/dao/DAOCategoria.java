/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Categoria;
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
public class DAOCategoria {

    private static DAOCategoria uniqueInstance;

    private DAOCategoria() {
    }

    public static synchronized DAOCategoria getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DAOCategoria();
        }

        return uniqueInstance;
    }

    public List<Categoria> readNome(String nome) {
        List lista = null;
        Session sessao = null;

        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSESSIONFACTORY().openSession();
            sessao.getTransaction().begin();

            CriteriaBuilder builder = sessao.getCriteriaBuilder();

            CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
            Root<Categoria> root = criteria.from(Categoria.class);
            criteria.select(root);
            criteria.where(builder.like(root.get("nome"), nome + "%"));

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
