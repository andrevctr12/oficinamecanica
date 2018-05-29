package DAO;

import Model.DDD;
import DAO.ConexaoBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class DDDDAO {
    public void CadastraDDD(DDD DDD) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        st.executeQuery("INSERT INTO `ddd` (`idDDD`) VALUES ('" + DDD.getDDD() + "')");
    }

    public DDD BuscaDDD(int DDD) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM `ddd` WHERE `idDDD` =" + DDD);

        DDD ddd = null;
        while (r.next()) {
            ddd = new DDD();
            ddd.setDDD(r.getInt("idDDD"));
        }
        return ddd;
    }
}
