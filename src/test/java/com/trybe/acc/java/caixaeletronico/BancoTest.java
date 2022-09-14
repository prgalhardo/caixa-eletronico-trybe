package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Testes para a classe Banco")
class BancoTest {
  String nomeCompleto = "Priscila Silva";
  String cpf = "421.949.798-67";
  String senha = "012345";

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();
    String numberOfAccount = banco.gerarNumeroNovaConta();
    assertEquals(10, numberOfAccount.length());
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    PessoaCliente pessoaClienteTest = banco.adicionarPessoaCliente(pessoaCliente);
    assertEquals(pessoaClienteTest, pessoaCliente);
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    banco.adicionarPessoaCliente(pessoaCliente);
    PessoaCliente pessoaClienteLoginTest = banco.pessoaClienteLogin("421.949.798-67", "012345");
    assertEquals(pessoaClienteLoginTest, pessoaCliente);
  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    banco.adicionarPessoaCliente(pessoaCliente);
    Conta cCCliente = new Conta("Corrente", pessoaCliente, banco);
    Conta cPCliente = new Conta("Poupança", pessoaCliente, banco);
    banco.adicionarConta(cCCliente);
    banco.adicionarConta(cPCliente);
    banco.depositar(pessoaCliente, 0, 1000.00);
    banco.transferirFundos(pessoaCliente, 0, 1, 500.00);

    assertEquals(pessoaCliente.retornarSaldoContaEspecifica(0), 500.00);
    assertEquals(pessoaCliente.retornarSaldoContaEspecifica(1), 500.00);
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente = new PessoaCliente(nomeCompleto, cpf, senha);
    banco.adicionarPessoaCliente(pessoaCliente);
    Conta cCCliente = new Conta("Corrente", pessoaCliente, banco);
    Conta cPCliente = new Conta("Poupança", pessoaCliente, banco);
    banco.adicionarConta(cCCliente);
    banco.adicionarConta(cPCliente);
    banco.depositar(pessoaCliente, 0, 1000.00);
    banco.sacar(pessoaCliente, 0, 500.00);

    assertEquals(pessoaCliente.retornarSaldoContaEspecifica(0), 500.00);
  }

}
