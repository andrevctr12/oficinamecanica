package DAO;

import Model.Bairro;
import DAO.ConexaoBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BairroDAO {
    public void CadastraBairro(Bairro bairro) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        st.executeQuery("INSERT INTO `bairro` (`nomeBairro`) VALUES ('"+ bairro.getNome() + "');");
        c.close();
    }

    public Bairro BuscaBairro(String nome) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM `bairro` where nomeBairro like '"+ nome +"'");

        Bairro bairro = null;
        while (r.next())
        {
            bairro = new Bairro();
            bairro.setNome(r.getString("nomeBairro"));
            bairro.setID(r.getInt("idBairro"));
        }

        c.close();

        return bairro;
    }
    public Bairro BuscaBairroID(int ID) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM `bairro` where idBairro = '"+ ID +"'");

        Bairro bairro = null;
        while (r.next())
        {
            bairro = new Bairro();
            bairro.setNome(r.getString("nomeBairro"));
            bairro.setID(r.getInt("idBairro"));
        }

        c.close();

        return bairro;
    }

}
