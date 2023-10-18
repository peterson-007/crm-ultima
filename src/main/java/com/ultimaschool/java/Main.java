package com.ultimaschool.java;

import com.ultimaschool.java.clientes.Cliente;

public class Main {
    public static void main(String[] args) {

        Cliente clienteF = new Cliente("Joana","Maria","Rocha","123.456.789-00",
                "10/01/1993", "joana@gmail.com",'F',"Av. Brasil","(11 8888-8888)");
        System.out.println(clienteF.toString());

        Cliente clienteM = new Cliente("Rogério","Azevedo","Rocha","123.456.789-00",
                "10/01/1983", "rogerio@gmail.com",'M',"Av. Brasil","(11 9999-8888)");
        System.out.println(clienteM.toString());
    }
}
