package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;


/**
 * Classe: Pessoa Cliente.
 */

public class PessoaCliente {
  String nomeCompleto;
  String cpf;
  String senha;
  ArrayList<Conta> contas;

  PessoaCliente(String nomeCompleto, String cpf, String senha) {
    this.nomeCompleto = nomeCompleto;
    this.cpf = cpf;
    this.senha = senha;
    System.out.println("Nova pessoa cliente " + nomeCompleto + " com CPF: " + cpf + " criada!");
  }
}
