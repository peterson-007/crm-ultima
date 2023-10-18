package com.ultimaschool.java.clientes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteBuilderTest {

    private ClienteBuilder clienteBuilder;
    private ClienteBuilder clienteBuilder2;

    @BeforeEach
    public void setUp() {

        clienteBuilder = new ClienteBuilder("Joana","Maria","Rocha","123.456.789-00",
                "10/01/1993", "joana@gmail.com",'F',"Av. Brasil","(11 8888-8888)");

        clienteBuilder2 = new ClienteBuilder();
    }

    @Test
    public void testToString(){
        Assertions.assertEquals(clienteBuilder.toString(),"Sra. Joana Maria Rocha,com CPF 123.456.789-00" +
                ", data de nascimento 10/01/1993 com idade de 31, e-mail joana@gmail.com, endereço Av. Brasil " +
                "telefone (11 8888-8888)");
    }

    @Test
    public void testToStringIdentificacao(){
        Assertions.assertEquals(clienteBuilder.toStringIdentificacao(),
                "Os dados pessoais são: Sra. Joana Maria Rocha, com CPF 123.456.789-00, " +
                        "data de nascimento 10/01/1993 com idade de 31");
        clienteBuilder.setGenero('M');
        Assertions.assertEquals(clienteBuilder.toStringIdentificacao(),
                "Os dados pessoais são: Sr. Joana Maria Rocha, com CPF 123.456.789-00, " +
                        "data de nascimento 10/01/1993 com idade de 31");
        clienteBuilder.setGenero(' ');
        Assertions.assertEquals(clienteBuilder.toStringIdentificacao(),
                "Os dados pessoais são:  Joana Maria Rocha, com CPF 123.456.789-00, " +
                        "data de nascimento 10/01/1993 com idade de 31");
        clienteBuilder.setGenero('@');
        Assertions.assertEquals(clienteBuilder.toStringIdentificacao(),
                "Os dados pessoais são:  Joana Maria Rocha, com CPF 123.456.789-00, " +
                        "data de nascimento 10/01/1993 com idade de 31");
        clienteBuilder.setDataDeNascimento("");
        Assertions.assertEquals(clienteBuilder.toStringIdentificacao(),
                "Os dados pessoais são:  Joana Maria Rocha, com CPF 123.456.789-00, " +
                        "data de nascimento  com idade de 31");
    }

    @Test
    public void testToStringContatos(){
        Assertions.assertEquals(clienteBuilder.toStringContatos(),"Os dados de contatos são: Email" +
                " joana@gmail.com, endereco Av. Brasil, telefone (11 8888-8888)");
    }

    @Test
    public void testGetCpf() {
        Assertions.assertEquals(clienteBuilder.getCpf(),"123.456.789-00");
        Assertions.assertNull(clienteBuilder2.getCpf());
    }

    @Test
    public void testSetCpf() {
        clienteBuilder.setCpf("000.000.000-00");
        Assertions.assertEquals(clienteBuilder.getCpf(),"000.000.000-00");
        clienteBuilder2.setCpf("111.111.111-11");
        Assertions.assertEquals(clienteBuilder2.getCpf(),"111.111.111-11");
    }

    @Test
    public void testGetPrimeiroNome() {
        Assertions.assertEquals(clienteBuilder.getPrimeiroNome(),"Joana");
        Assertions.assertNull(clienteBuilder2.getPrimeiroNome());
    }

    @Test
    public void testSetPrimeiroNome() {
        clienteBuilder.setPrimeiroNome("Maria");
        Assertions.assertEquals(clienteBuilder.getPrimeiroNome(),"Maria");
        clienteBuilder2.setPrimeiroNome("Jubileu");
        Assertions.assertEquals(clienteBuilder2.getPrimeiroNome(),"Jubileu");
    }

    @Test
    public void testGetNomeDoMeio(){
        Assertions.assertEquals(clienteBuilder.getNomeDoMeio(),"Maria");
        Assertions.assertNull(clienteBuilder2.getNomeDoMeio());
    }

    @Test
    public void testSetNomeDoMeio(){
        clienteBuilder.setNomeDoMeio("Catarina");
        Assertions.assertEquals(clienteBuilder.getNomeDoMeio(),"Catarina");
        clienteBuilder2.setNomeDoMeio("Bia");
        Assertions.assertEquals(clienteBuilder2.getNomeDoMeio(),"Bia");
    }

    @Test
    public void testGetSobrenome(){
        Assertions.assertEquals(clienteBuilder.getSobrenome(), "Rocha");
        Assertions.assertNull(clienteBuilder2.getSobrenome());
    }

    @Test
    public void testSetSobrenome(){
        clienteBuilder.setSobrenome("Menezes");
        Assertions.assertEquals(clienteBuilder.getSobrenome(),"Menezes");
        clienteBuilder2.setSobrenome("Carvalho");
        Assertions.assertEquals(clienteBuilder2.getSobrenome(),"Carvalho");
    }

    @Test
    public void testGetNomeCompleto(){
        Assertions.assertEquals(clienteBuilder.getNomeCompleto(),"Joana Maria Rocha");
        Assertions.assertNull(clienteBuilder2.getNomeCompleto());
    }

    @Test
    public void testSetNomeCompleto(){
        clienteBuilder.setNomeCompleto("Conceição Graça Costa");
        Assertions.assertEquals(clienteBuilder.getNomeCompleto(),"Conceição Graça Costa");
        clienteBuilder2.setNomeCompleto("Marina Silva Dias");
        Assertions.assertEquals(clienteBuilder2.getNomeCompleto(),"Marina Silva Dias");
    }

    @Test
    public void testGetDataDeNascimento(){
        Assertions.assertEquals(clienteBuilder.getDataDeNascimento(),"10/01/1993");
    }

    @Test
    public void testSetDataDeNasciemnto(){
        clienteBuilder.setDataDeNascimento("01/01/1970");
        Assertions.assertEquals(clienteBuilder.getDataDeNascimento(),"01/01/1970");
    }

    @Test
    public void testGetIdadeAtual(){
        Assertions.assertEquals(clienteBuilder.getIdadeAtual(),31);
    }

    @Test
    public void testSetIdadeAtual(){
        clienteBuilder.setIdadeAtual(50);
        Assertions.assertEquals(clienteBuilder.getIdadeAtual(),50);
    }

    @Test
    public void testGetEmail(){
        Assertions.assertEquals(clienteBuilder.getEmail(),"joana@gmail.com");
    }

    @Test
    public void testSetEmail(){
        clienteBuilder.setEmail("joanamaria@hotmail.com");
        Assertions.assertEquals(clienteBuilder.getEmail(),"joanamaria@hotmail.com");
    }

    @Test
    public void testGetGenero(){
        Assertions.assertEquals(clienteBuilder.getGenero(),'F');
    }

    @Test
    public void testSetGenero(){
        clienteBuilder.setGenero('M');
        Assertions.assertEquals(clienteBuilder.getGenero(),'M');
    }

    @Test
    public void testGetEndereco(){
        Assertions.assertEquals(clienteBuilder.getEndereco(),"Av. Brasil");
    }

    @Test
    public void testSetEndereco(){
        clienteBuilder.setEndereco("Av. Paulista");
        Assertions.assertEquals(clienteBuilder.getEndereco(),"Av. Paulista");
    }

    @Test
    public void testGetTelefone(){
        Assertions.assertEquals(clienteBuilder.getTelefone(),"(11 8888-8888)");
    }

    @Test
    public void testSetTelefone(){
        clienteBuilder.setTelefone("(61)9999-8888");
        Assertions.assertEquals(clienteBuilder.getTelefone(),"(61)9999-8888");
    }


    @AfterEach
    public void tearDown() {
        clienteBuilder = null;
        clienteBuilder2 = null;
    }
}