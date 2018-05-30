package DAO;

import DAO.*;
import Model.Cliente;
import Model.Endereco;
import Model.TelCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {
    public void CadastraCliente(Cliente cliente) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        EnderecoDAO enderecoDAO = new EnderecoDAO();
        if (enderecoDAO.BuscaEnderecoByIds(cliente.getEndereco().getRua().getID(),cliente.getEndereco().getBairro().getID(),
                cliente.getEndereco().getCidade().getId()) == null) {
            enderecoDAO.CadastraEnd(cliente.getEndereco());
        }
        cliente.getEndereco().setId(enderecoDAO.BuscaEnderecoByIds(cliente.getEndereco().getRua().getID(),
                cliente.getEndereco().getBairro().getID(),
                cliente.getEndereco().getCidade().getId()).getId());

        TelClienteDAO telClienteDAO = new TelClienteDAO();
        if (telClienteDAO.BuscaTelCliente(cliente.getTelCliente().getTelefone())== null)
        {
            telClienteDAO.CadastraTelCliente(cliente.getTelCliente());
        }

        cliente.getTelCliente().setID(telClienteDAO.BuscaTelCliente(cliente.getTelCliente().getTelefone()).getID());
        st.executeQuery("INSERT INTO cliente (idCliente, nomeCliente, CPF," +
                "TelCliente_TelClienteid, endereçoCliente_idendereçoCliente, Complemento, número_endereço, Senha)" +
                "VALUES (NULL, '"+cliente.getNome()+"', '"+cliente.getCpf() +"', '"+cliente.getTelCliente().getID()+"'," +
                " '"+cliente.getEndereco().getId()+"', '"+cliente.getComplemento()+"'," +
                " '"+cliente.getEnd_num()+"', '"+cliente.getSenha()+"')");

        EmailClienteDAO emailClienteDAO = new EmailClienteDAO();

        ClienteDAO clienteDAO = new ClienteDAO();

        emailClienteDAO.CadastraEmail(cliente.getEmail(),clienteDAO.BuscaCliente(cliente.getNome(),cliente.getCpf()).getID());

        c.close();

    }

    public Cliente BuscaCliente(String nome, String CPF) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM cliente WHERE nomeCliente LIKE '" + nome +"'" +
                "AND CPF like '"+ CPF +"'");

        Cliente cliente = null;
        while (r.next())
        {
            cliente = new Cliente();
            cliente.setID(r.getInt("idCliente"));
            cliente.setNome(r.getString("nomeCliente"));
            cliente.setCpf(r.getString("CPF"));
            cliente.setSenha(r.getString("Senha"));
            cliente.setEnd_num(r.getInt("número_endereço"));

            TelClienteDAO telClienteDAO = new TelClienteDAO();
            TelCliente telCliente= telClienteDAO.BuscaTelClienteID(r.getInt("TelCliente_TelClienteid"));

            cliente.setTelCliente(telCliente);

            EnderecoDAO enderecoDAO = new EnderecoDAO();
            Endereco endereco = enderecoDAO.BuscaEnderecoid(r.getInt("endereçoCliente_idendereçoCliente"));



            cliente.setEndereco(endereco);

            c.close();


        }
        return cliente;
    }
    public Cliente BuscaClienteID(int id) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM cliente WHERE idCliente = " + id);

        Cliente cliente = null;
        while (r.next()) {
            cliente = new Cliente();
            cliente.setID(r.getInt("idCliente"));
            cliente.setNome(r.getString("nomeCliente"));
            cliente.setCpf(r.getString("CPF"));
            cliente.setSenha(r.getString("Senha"));
            cliente.setEnd_num(r.getInt("número_endereço"));
            cliente.setComplemento(r.getString("Complemento"));

            TelClienteDAO telClienteDAO = new TelClienteDAO();
            TelCliente telCliente= telClienteDAO.BuscaTelClienteID(r.getInt("TelCliente_TelClienteid"));

            cliente.setTelCliente(telCliente);

            EnderecoDAO enderecoDAO = new EnderecoDAO();
            Endereco endereco = enderecoDAO.BuscaEnderecoid(r.getInt("endereçoCliente_idendereçoCliente"));
            EmailClienteDAO emailClienteDAO = new EmailClienteDAO();
            cliente.setEmail(emailClienteDAO.BuscaEmail(id));


            cliente.setEndereco(endereco);
        }

        c.close();

        return cliente;
    }

    public ArrayList<Cliente> BuscaLista() throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("SELECT * FROM cliente");
        ArrayList<Cliente> list = new ArrayList<Cliente>();

        Cliente cliente = null;
        while (r.next()) {

            cliente = new Cliente();
            cliente.setID(r.getInt("idCliente"));
            cliente.setNome(r.getString("nomeCliente"));
            cliente.setCpf(r.getString("CPF"));
            cliente.setSenha(r.getString("Senha"));
            cliente.setEnd_num(r.getInt("número_endereço"));
            cliente.setComplemento(r.getString("Complemento"));

            TelClienteDAO telClienteDAO = new TelClienteDAO();
            TelCliente telCliente= telClienteDAO.BuscaTelClienteID(r.getInt("TelCliente_TelClienteid"));

            cliente.setTelCliente(telCliente);

            EnderecoDAO enderecoDAO = new EnderecoDAO();
            Endereco endereco = enderecoDAO.BuscaEnderecoid(r.getInt("endereçoCliente_idendereçoCliente"));

            cliente.setEndereco(endereco);
            EmailClienteDAO emailClienteDAO = new EmailClienteDAO();
            cliente.setEmail(emailClienteDAO.BuscaEmail(cliente.getID()));

            list.add(cliente);
        }

        c.close();
        return list;

    }

    public void ExcluirCliente(int id) throws SQLException {
        Connection c = new ConexaoBD().getConexaoMySQL();
        java.sql.Statement st = c.createStatement();
        ResultSet r = st.executeQuery("DELETE FROM cliente WHERE idCliente = " + id);
        c.close();
    }
}
