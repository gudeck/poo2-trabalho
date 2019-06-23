/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Produto;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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

    public List<Produto> readEmLoja() {
        List lista = null;
        Session sessao = null;

        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            lista = sessao.createNativeQuery("select "
                    + "* "
                    + "from anarrie.produto p "
                    + "inner join "
                    + "anarrie.estadoproduto e on p.codEstado= e.codEstado "
                    + "and e.DTYPE like '%loja%';", Produto.class).list();

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
    
    public List<Produto> readEmManutencao() {
        List lista = null;
        Session sessao = null;

        try {
            // Abrir a SESSÃO
            sessao = ConexaoHibernate.getSessionFactory().openSession();
            sessao.getTransaction().begin();

            lista = sessao.createNativeQuery("select "
                    + "* "
                    + "from anarrie.produto p "
                    + "inner join "
                    + "anarrie.estadoproduto e on p.codEstado= e.codEstado "
                    + "and e.DTYPE like '%manutencao%';", Produto.class).list();

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

//    public List<Produto> readBetweenDates(Date dataRetirada, Date dataDevolucao) {
//        List lista = null;
//        Session sessao = null;
//
//        try {
//            // Abrir a SESSÃO
//            sessao = ConexaoHibernate.getSessionFactory().openSession();
//            sessao.getTransaction().begin();
//
////            CriteriaBuilder builder = sessao.getCriteriaBuilder();
////            CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
////
////            Root<Produto> root = criteria.from(Produto.class);
////
////            Join<Produto, ProdutoAlugado> produtoAlugadoJoin = root.join("listaProdutosAlugados");
////            Join<ProdutoAlugado, ProdutoAlugadoPK> chaveJoin = produtoAlugadoJoin.join("chaveComposta");
////            Join<ProdutoAlugadoPK, Aluguel> aluguelJoin = chaveJoin.join("aluguel");
////
////            criteria.where();
////            
////            lista = sessao.createQuery( criteria ).getResultList();
//            lista = sessao.createNativeQuery(
//                    "SELECT P.* "
//                    + "FROM PRODUTO P "
//                    + "INNER JOIN PRODUTOALUGADO PA ON P.CODPRODUTO = PA.CODPRODUTO "
//                    + "INNER JOIN ALUGUEL A ON PA.CODALUGUEL = A.CODALUGUEL"
//                    + "WHERE ")
//                    .addEntity("PRODUTO", Produto.class)
//                    //                    .addJoin("pr", "phone.person")
//                    .list();
//
//            sessao.getTransaction().commit();
//            sessao.close();
//        } catch (HibernateException ex) {
//            if (sessao != null) {
//                sessao.getTransaction().rollback();
//                sessao.close();
//            }
//
//            throw new HibernateException(ex);
//        }
//        return lista;
//
//    }
}
