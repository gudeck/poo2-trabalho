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
public class DAOCategoria extends GenericDAO {

    private static DAOCategoria uniqueInstance;

    private DAOCategoria() {
    }

    public static synchronized DAOCategoria getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new DAOCategoria();
        }

        return uniqueInstance;
    }

}
