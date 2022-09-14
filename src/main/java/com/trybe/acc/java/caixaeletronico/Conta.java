package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

/**
 * Classe: Conta.
 */

public class Conta {

  String tipoConta;
  String idConta;
  PessoaCliente pessoaCliente;
  ArrayList<Transacao> transacoes;

  Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  public String getTipoConta() {
    return tipoConta;
  }

  public String getIdConta() {
    return idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return pessoaCliente;
  }

  public ArrayList<Transacao> getTransacoes() {
    return transacoes;
  }

  /**
   * Método: Adicionar Transação.
   */
  public void adicionarTransacao(double quantia, String descricao) {
    Transacao transacao = new Transacao(quantia, descricao);
    transacoes.add(transacao);
  }

  /**
   * Método: Retornar Saldo.
   */
  public double retornarSaldo() {
    double total = 0;
    for (Transacao transacao : transacoes) {
      total += transacoes.getQuantia();
    }
    return total;
  }

  /**
   * Método: Retornar Resumo Conta.
   */
  public String retornarResumoConta() {
    return "Número de identificação único: " + getIdConta() + ". Saldo: " + retornarSaldo() +
            ". Tipo de Conta: " + getTipoConta() + ".";
  }

  /**
   * Método: Retornar Extrato.
   */
  public void retornarExtrato() {
    for (Transacao transacao : transacoes) {
      System.out.println(transacao.retornarResumoTransacao);
    }
  }

}
