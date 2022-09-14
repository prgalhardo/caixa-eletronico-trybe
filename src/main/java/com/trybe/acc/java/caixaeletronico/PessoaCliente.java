package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Objects;


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

  /**
   * Método: Adicionar conta.
   */
  public void adicionarConta(Conta conta) {
    contas.add(conta);
  }

  /**
   * Método: Retornar número de contas.
   */
  public int retornaNumeroDeContas() {
    return contas.size();
  }

  /**
   * Método: Retornar Saldo Conta Específica.
   */
  public double retornarSaldoContaEspecifica(int indice) {
    Conta conta = contas.get(indice);
    return conta.retornarSaldo();
  }

  /**
   * Método: Retornar Id Conta Específica.
   */
  public String retornarIdContaEspecifica(int indice) {
    Conta conta = contas.get(indice);
    return conta.getIdConta();
  }

  /**
   * Método: Retornar Extrato Conta Específica.
   */
  public void retornarExtratoContaEspecifica(int indice) {
    Conta conta = contas.get(indice);
    conta.retornarExtrato();
  }

  /**
   * Método: adicionarTransacaoContaEspecifica.
   */
  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    Conta conta = contas.get(indice);
    conta.adicionarTransacao(quantia, descricao);
  }

  /**
   * Método: validarSenha.
   */
  public boolean validarSenha(String senha) {
    return Objects.equals(this.senha, senha);
  }

  /**
   * Método: retornarResumoContas.
   */
  public void retornarResumoContas() {
    for (Conta conta : contas) {
      System.out.println(conta.retornarResumoConta());
    }
  }
  public String getCpf() {
    return cpf;
  }
}
