package es1.oficina.controllers;

import DAO.ClienteDAO;
import DAO.EmailClienteDAO;
import Model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping(produces = "application/json")
    public @ResponseBody ArrayList<Cliente> ListaCliente() throws SQLException {

        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> listaCliente = clienteDAO.BuscaLista();

        return listaCliente;
    }

    @PostMapping()
    public void CadastraCliente(@RequestBody Cliente cliente) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();

        if(clienteDAO.BuscaCliente(cliente.getNome(),cliente.getCpf()) == null){
            clienteDAO.CadastraCliente(cliente);
        }
    }

    @RequestMapping("/{id}")
    @GetMapping(produces = "application/json")
    public @ResponseBody Cliente BuscaCliente(@PathVariable("id") int id) throws SQLException {
       ClienteDAO clienteDao = new ClienteDAO();

       return clienteDao.BuscaClienteID(id);

    }
//    @RequestMapping("/{id}")
//    @DeleteMapping()
//    public void ExcluirCliente(@PathVariable("id") int id) throws SQLException {
//        ClienteDAO clienteDao = new ClienteDAO();
//        clienteDao.ExcluirCliente(id);
//
//    }



}
