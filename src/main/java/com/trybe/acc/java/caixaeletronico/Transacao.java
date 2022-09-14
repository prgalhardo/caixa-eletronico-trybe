package com.trybe.acc.java.caixaeletronico;

/**
 * Classe: Transação.
 */

public class Transacao {
  double quantia;
  String instante;
  String descricao;
  Conta conta;

  Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;
    this.instante = retornarInstante();
  }

  public double getQuantia() {
    return quantia;
  }
}

