package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    fail("Não implementado");

  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    fail("Não implementado");


  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    fail("Não implementado");

  }

}
