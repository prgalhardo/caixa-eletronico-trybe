package com.trybe.acc.java.caixaeletronico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste da classe Conta")
class ContaTest {
  String nomeCompleto = "Priscila Silva";
  String cpf = "421.949.798-67";
  String senha = "012345";
  String tipoConta = "Corrente";

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);

    assertEquals(tipoConta, conta.getTipoConta());
    assertEquals(pessoaCliente, conta.getPessoaCliente());
    assertEquals(10, conta.getIdConta().length());
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);

    conta.adicionarTransacao(1000.00, "Transação realizada");
    assertEquals(1000.00, conta.retornarSaldo());
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);
    conta.adicionarTransacao(1000.00, "Transação realizada");

    String idConta = conta.getIdConta();
    String resumoConta = conta.retornarResumoConta();
    String saldo = String.valueOf(conta.retornarSaldo());

    assertTrue(resumoConta.contains(idConta));
    assertTrue(resumoConta.contains(tipoConta));
    assertTrue(resumoConta.contains(saldo));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);
    String idConta = conta.getIdConta();

    assertEquals(10, idConta.length());
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);
    PessoaCliente testPessoaCliente = conta.getPessoaCliente();

    assertEquals(testPessoaCliente, pessoaCliente);
  }

}
