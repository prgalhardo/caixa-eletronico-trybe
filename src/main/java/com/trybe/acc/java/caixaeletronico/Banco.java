package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;


/**
 * Classe: Banco.
 */

public class Banco {
  ArrayList<PessoaCliente> arrayPessoasClientes = new ArrayList<PessoaCliente>();
  ArrayList<Conta> arrayContas = new ArrayList<Conta>();

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

  /**
   * Método: Adicionar Pessoa Cliente.
   */
  public PessoaCliente adicionarPessoaCliente(PessoaCliente pessoaCliente) {
    arrayPessoasClientes.add(pessoaCliente);
    return pessoaCliente;
  }

  /**
   * Método: Adicionar Conta.
   */
  public void adicionarConta(Conta novaConta) {
    arrayContas.add(novaConta);
  }

  /**
   * Método: Login Pessoa Cliente.
   */
  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    for (PessoaCliente pessoaCliente : arrayPessoasClientes) {
      if (pessoaCliente.cpf == cpf && pessoaCliente.senha == senha) {
        return pessoaCliente;
      }
    }
    return null;
  }

  /**
   * Método: Transferir Fundos.
   */
  public void transferirFundos(
          PessoaCliente pessoaCliente,
          int daConta,
          int paraConta,
          double quantia
  ) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, quantia * (-1), "Depósito realizado.");
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Depósito recebido.");
  }

  /**
   * Método: Sacar.
   */
  public void sacar(
          PessoaCliente pessoaCliente,
          int daConta,
          double quantia
  ) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, quantia * (-1), "Saque realizado.");
  }

  /**
   * Método: Depositar.
   */
  public void depositar(
          PessoaCliente pessoaCliente,
          int paraConta,
          double quantia
  ) {
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Depósito realizado.");
  }

  /**
   * Método: Mostrar Extrato.
   */
  public void mostrarExtrato(PessoaCliente pessoaCliente, int conta) {
    pessoaCliente.retornarExtratoContaEspecifica(conta);
  }

}
