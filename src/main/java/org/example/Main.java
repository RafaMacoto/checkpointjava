package org.example;

import org.example.factory.ModelFactory;
import org.example.model.Cliente;
import org.example.service.*;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        ClienteService clienteService = new ClienteService();

        Cliente cliente1 = ModelFactory.criarCliente(2L , "Macoto" , "rafaelm@gmail.com" ,"11111111111" , "Av.Paulista" , "11111111221");
        clienteService.salvarCliente(cliente1);
        System.out.printf("Cliente salvo: %s" , cliente1.getNome());
    }
}