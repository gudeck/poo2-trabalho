/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Categoria;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author gudeck
 */
public class DAOCategoria extends GenericDAO {

    private static DAOCategoria UNIQUEINSTANCE;

    private DAOCategoria() {
    }

    public static synchronized DAOCategoria getInstance() {
        if (UNIQUEINSTANCE == null) {
            UNIQUEINSTANCE = new DAOCategoria();
        }

        return UNIQUEINSTANCE;
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
