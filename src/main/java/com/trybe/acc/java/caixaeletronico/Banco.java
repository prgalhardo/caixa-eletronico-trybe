package com.trybe.acc.java.caixaeletronico;

/**
 * Classe: Banco.
 */

public class Banco {

  /**
   * Método: Gerar Nova Conta.
   */
  public String gerarNumeroNovaConta() {
    /* https://acervolima.com/gerar-string-aleatoria-de-determinado-tamanho-em-java/ */
    StringBuilder numberOfAccount = new StringBuilder();

    for (int i = 0; i <= 9; i++) {
      int number = (int) Math.floor(Math.random() * 10);
      numberOfAccount.append(number);
    }
    return numberOfAccount.toString();
  }

}
