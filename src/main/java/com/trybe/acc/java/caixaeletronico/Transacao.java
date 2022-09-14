package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

  /**
   * Método: retornarResumoTransacao.
   */
  public String retornarResumoTransacao() {
    return instante + quantia + descricao;
  }

  /**
   * Método: retornarInstante.
   */
  public String retornarInstante() {
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return LocalDateTime.now().format(formato);
  }
}

