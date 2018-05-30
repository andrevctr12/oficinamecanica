package DAO;



import Model.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmailClienteDAO {
    public void CadastraEmail(String email, int idCliente) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("INSERT INTO emailcliente " +
                "(idemailCliente, emailCliente, Cliente_idCliente) " +
                "VALUES (NULL, '" + email + "', '" + idCliente + "');");

        c.close();

    }
    public String BuscaEmail(int idCliente) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM emailcliente WHERE Cliente_idCliente = " + idCliente );

        String email= null;
        while (r.next()){

            email = (r.getString("emailCliente"));


        }

        c.close();

        return email;
    }

    public void BuscaEmailLista(ArrayList<Cliente> listaCliente) throws SQLException {
        EmailClienteDAO emailClienteDAO = new EmailClienteDAO();
        for (Cliente cliente : listaCliente) {
            cliente.setEmail(emailClienteDAO.BuscaEmail(cliente.getID()));
        }
    }
}

