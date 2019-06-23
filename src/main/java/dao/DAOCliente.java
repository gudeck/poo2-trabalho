/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author gudeck
 */
public class DAOCliente extends GenericDAO {

    private static DAOCliente uniqueInstance;

    private DAOCliente() {
    }

    public static synchronized DAOCliente getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DAOCliente();
        }

        return uniqueInstance;
    }

    /*
   
    public ResultSet read(String nome) throws SQLException {

        ResultSet result;
        sql = "select * from cliente where nome like '" + nome + "%'";
        statement = conexao.prepareStatement(sql);
        result = statement.executeQuery();
        return result;
    }

    public int cpfConsulta(String cpf) throws SQLException{

        ResultSet result;
        sql = "select count(*) from cliente where cpf like '" + cpf + "'";
        statement = conexao.prepareStatement(sql);
        result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getInt(1);
        } else {
            return -1;
        }

    }
     */
}
