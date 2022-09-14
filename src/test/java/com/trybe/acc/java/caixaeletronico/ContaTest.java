package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {
  String nomeCompleto = "Priscila Silva";
  String cpf = "421.949.798-67";
  String senha = "012345";

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta("Corrente", pessoaCliente, banco);

    assertEquals("Corrente", conta.tipoConta);
    assertEquals(pessoaCliente, conta.pessoaCliente);
    assertEquals(10, conta.idConta.length());
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta("Corrente", pessoaCliente, banco);

    conta.adicionarTransacao(1000.00, "Transação realizada");
    assertEquals(1000.00, conta.retornarSaldo());
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    fail("Não implementado");
  }

}
