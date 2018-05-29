package DAO;


import Model.DDD;
import DAO.ConexaoBD;
import Model.TelCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TelClienteDAO {
    public void CadastraTelCliente(TelCliente telCliente) throws SQLException {
        DDDDAO ddddao = new DDDDAO();
        DDD ddd = ddddao.BuscaDDD(telCliente.getDDD());

        if (ddd == null)
        {
            ddd = new DDD(telCliente.getDDD());
            ddddao.CadastraDDD(ddd);
        }

        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        st.executeQuery("INSERT INTO `telefone` (`Telefoneid`, `Telefone`, `DDD_idDDD`)" +
                " VALUES (NULL, '"+telCliente.getTelefone()+"', '"+telCliente.getDDD()+"')");
    }

    public TelCliente BuscaTelClienteID(int id) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM `telefone` WHERE `Telefoneid` = " + id);

        TelCliente telCliente = null;
        while (r.next())
        {
            telCliente = new TelCliente();
            telCliente.setID(r.getInt("Telefoneid"));
            telCliente.setTelefone(r.getString("Telefone"));
            telCliente.setDDD(r.getInt("DDD_idDDD"));
        }
        return telCliente;
    }

    public TelCliente BuscaTelCliente(String tel) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM `telefone` WHERE `Telefone` like " + tel);

        TelCliente telCliente = null;
        while (r.next())
        {
            telCliente = new TelCliente();
            telCliente.setID(r.getInt("Telefoneid"));
            telCliente.setTelefone(r.getString("Telefone"));
            telCliente.setDDD(r.getInt("DDD_idDDD"));

        }
        return telCliente;
    }
}
