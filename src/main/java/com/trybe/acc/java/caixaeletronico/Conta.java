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

}
