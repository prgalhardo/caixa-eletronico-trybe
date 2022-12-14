package com.trybe.acc.java.caixaeletronico;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {
  String nomeCompleto = "Priscila Silva";
  String cpf = "421.949.798-67";
  String senha = "012345";
  String tipoConta = "Corrente";

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    ByteArrayOutputStream saida = new ByteArrayOutputStream();
    PrintStream impressao = System.out;
    System.setOut(new PrintStream(saida));
    new PessoaCliente(nomeCompleto, cpf, senha);

    assertEquals("Nova pessoa cliente " + nomeCompleto + " com CPF: " + cpf + " criada!\n",
            saida.toString());
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);

    assertEquals(1, pessoaCliente.retornaNumeroDeContas());
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    conta.adicionarTransacao(500.00, "Transação realizada.");

    assertEquals(500.00, pessoaCliente.retornarSaldoContaEspecifica(0));
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    String idConta = conta.getIdConta();

    assertEquals(idConta, pessoaCliente.retornarIdContaEspecifica(0));
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    ByteArrayOutputStream saida = new ByteArrayOutputStream();
    PrintStream impressao = System.out;
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);
    Transacao transacao = new Transacao(100.00, "Depósito");
    System.setOut(new PrintStream(saida));

    conta.adicionarTransacao(100.00, "Depósito");
    pessoaCliente.adicionarConta(conta);
    pessoaCliente.retornarExtratoContaEspecifica(0);

    assertTrue(saida.toString().contains(transacao.retornarInstante()));
    assertTrue(saida.toString().contains("Depósito"));

    System.setOut(impressao);
  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    pessoaCliente.adicionarTransacaoContaEspecifica(0, 500.00, "Depósito realizado.");

    assertEquals(500.00, conta.retornarSaldo());
  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    String senhaIncorreta = "senhaerrada";
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);

    assertTrue(pessoaCliente.validarSenha(senha));
    assertFalse(pessoaCliente.validarSenha(senhaIncorreta));

  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    ByteArrayOutputStream saida = new ByteArrayOutputStream();
    PrintStream impressao = System.out;
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    Conta conta = new Conta(tipoConta, pessoaCliente, banco);
    pessoaCliente.adicionarConta(conta);
    pessoaCliente.retornarResumoContas();
    System.setOut(new PrintStream(saida));

    assertTrue(saida.toString().contains(conta.getIdConta()));
    assertTrue(saida.toString().contains(String.valueOf(conta.retornarSaldo())));
    assertTrue(saida.toString().contains(conta.getTipoConta()));

    System.setOut(impressao);
  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);

    assertEquals(cpf, pessoaCliente.getCpf());
  }

}
