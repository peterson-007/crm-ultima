package com.ultimaschool.java.clientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClienteBuilder {

    private String primeiroNome;
    private String nomeDoMeio;
    private String sobrenome;
    private String nomeCompleto;
    private String cpf;
    private String dataDeNascimento;
    private int idadeAtual;
    private String email;
    private char genero;
    private String endereco;
    private String telefone;

    public ClienteBuilder() {
    }

    public ClienteBuilder(String primeiroNome, String nomeDoMeio, String sobrenome, String cpf,
                          String dataDeNascimento, String email, char genero, String endereco, String telefone) {
        this.primeiroNome = primeiroNome;
        this.nomeDoMeio = nomeDoMeio;
        this.sobrenome = sobrenome;
        this.nomeCompleto = primeiroNome + " "+nomeDoMeio+" "+ sobrenome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.idadeAtual = definirIdadeAtual();
        this.email = email;
        this.genero = genero;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    private int definirIdadeAtual(){
       int anoAtual = recuperarAnoAtual();
       int anoNascimento = recuperarAnoNascimento();
       return anoAtual - anoNascimento;
    }

    private int recuperarAnoNascimento(){
        Calendar calendario = Calendar.getInstance();
        Date dataDeNascimentoCliente;
        try {
            dataDeNascimentoCliente = definirFormatoData("").parse(dataDeNascimento);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        calendario.setTime(dataDeNascimentoCliente);
        return calendario.get(Calendar.YEAR);
    }

    private int recuperarAnoAtual(){
        Calendar calendario = Calendar.getInstance();
        Date diaAtual = new Date();
        calendario.setTime(diaAtual);
        return calendario.get(Calendar.YEAR);
    }

    private SimpleDateFormat definirFormatoData(String formatoData){
       if (formatoData == ""){
           return new SimpleDateFormat("dd/MM/YYYY");
       } else {
           return new SimpleDateFormat(formatoData);
       }
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomeDoMeio() {
        return nomeDoMeio;
    }

    public void setNomeDoMeio(String nomeDoMeio) {
        this.nomeDoMeio = nomeDoMeio;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getIdadeAtual() {
        return idadeAtual;
    }

    public void setIdadeAtual(int idadeAtual) {
        this.idadeAtual = idadeAtual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String tratamentoGenero(){
        if(getGenero() == 'M'){
            return "Sr.";
        } else if (getGenero() == 'F'){
            return "Sra.";
        } else {
            return "";
        }
    }

    public String toString(){
        return tratamentoGenero() + " " + getNomeCompleto() + ",com CPF " +
                getCpf() + ", data de nascimento " + getDataDeNascimento() +
                " com idade de " + getIdadeAtual() +
                ", e-mail " + getEmail() +
                ", endereço " + getEndereco() +
                " telefone " + getTelefone();
    }

    public String toStringIdentificacao(){
        return "Os dados pessoais são: " + tratamentoGenero() + " " +getNomeCompleto() + ", com CPF " +
                getCpf() + ", data de nascimento " + getDataDeNascimento() +
                " com idade de " + getIdadeAtual();
    }

    public String toStringContatos(){
        return "Os dados de contatos são: Email " + getEmail() +
                ", endereco " + getEndereco() +
                ", telefone " + getTelefone();
    }

}
