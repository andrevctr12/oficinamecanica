package DAO;

import Model.UF;
import DAO.ConexaoBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UFDAO {
    public void CadastraUF(UF uf) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        st.executeQuery("INSERT INTO uf (siglaUF, nomeUF) VALUES ('" + uf.getUFsigla() + "', '" + uf.getNome() + "');");
    }
    public UF BuscaUFSigla(String sigla) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM uf where siglaUF = '" + sigla + "'");

        UF uf = null;
        while (r.next()) {
            uf = new UF();
            uf.setUFsigla(r.getString("siglaUF"));
            uf.setNome(r.getString("nomeUF"));
        }
        return uf;
    }
    public UF BuscaUFNome(String nome) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM uf WHERE nomeUF LIKE '" + nome + "'");

        UF uf = null;
        while (r.next()) {
            uf = new UF();
            uf.setUFsigla(r.getString("siglaUF"));
            uf.setNome(r.getString("nomeUF"));
        }
        return uf;
    }

}
