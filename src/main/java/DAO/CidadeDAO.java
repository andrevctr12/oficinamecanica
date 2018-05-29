package DAO;

import Model.Cidade;
import Model.UF;
import DAO.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeDAO {
    public void CadastraCidade(Cidade cidade) throws SQLException {
        UFDAO ufdao = new UFDAO();
        UF aux = ufdao.BuscaUFSigla(cidade.getUF().getUFsigla());


        if (aux == null)
        {
            ufdao.CadastraUF(cidade.getUF());
        }
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        st.executeQuery("INSERT INTO `cidade` (`nomeCidade`, `siglaCidade`, `UF_siglaUF`) VALUES ('"
                + cidade.getNome() + "','" + cidade.getSiglaCidade() + "','" + cidade.getUF().getUFsigla() + "');");
    }

    public Cidade BuscaCidade(String nome) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM `cidade` WHERE nomeCidade LIKE'" + nome + "'");

        Cidade cidade = null;
        while (r.next())
        {
            UFDAO ufdao = new UFDAO();
            cidade = new Cidade();
            cidade.setId(r.getInt("idCidade"));

            UF uf = ufdao.BuscaUFSigla(r.getString("UF_siglaUF"));
            cidade.setUF(uf);
            cidade.setNome(r.getString("nomeCidade"));
            cidade.setSiglaCidade(r.getString("Siglacidade"));
        }
        return cidade;
    }
    public Cidade BuscaCidadeID(int ID) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM `cidade` WHERE idCidade ='" + ID + "'");

        Cidade cidade = null;
        while (r.next())
        {
            UFDAO ufdao = new UFDAO();
            cidade = new Cidade();
            cidade.setId(r.getInt("idCidade"));
            UF uf = ufdao.BuscaUFSigla(r.getString("UF_siglaUF"));
            cidade.setUF(uf);
            cidade.setNome(r.getString("nomeCidade"));
            cidade.setSiglaCidade(r.getString("Siglacidade"));
        }
        return cidade;
    }

}
