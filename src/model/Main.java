/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author italo
 */
import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.InputMismatchException;

public class Main {

    private static Scanner entrada;
    private static PessoaFisicaRepo fisicaRepo = new PessoaFisicaRepo();
    private static PessoaJuridicaRepo juridicaRepo = new PessoaJuridicaRepo();
    private static int acao;

    public static void main(String args[]) {
        entrada = new Scanner(System.in);
        do {
            try {
                System.out.println("Para continuar digite:");
                System.out.println("=========================");
                System.out.println("1 - Incluir Pessoa");
                System.out.println("2 - Alterar Pessoa");
                System.out.println("3 - Excluir Pessoa");
                System.out.println("4 - Buscar pelo ID");
                System.out.println("5 - Exibir Todos");
                System.out.println("6 - Persistir Dados");
                System.out.println("7 - Recuperar Dados");
                System.out.println("0 - Finalizar Programa");
                System.out.println("=========================");

                acao = entrada.nextInt();
                entrada.nextLine();

                //incluir
                if (acao == 1) {
                    System.out.println("Digite F para incluir uma Pessoa Fisica");
                    System.out.println("ou");
                    System.out.println("Digite J para incluir uma Pessoa Juridica");
                    String tipoPessoa = entrada.next();
                    entrada.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F") || tipoPessoa.equalsIgnoreCase("f")) {
                        System.out.println("Insira uma ID: ");
                        int id;
                        boolean idExistente;
                        do {
                            idExistente = false;
                            id = entrada.nextInt();
                            entrada.nextLine();

                            List<PessoaFisica> pessoas = fisicaRepo.obterTodos();
                            for (PessoaFisica pessoa : pessoas) {
                                if (pessoa.getId() == id) {
                                    System.out.println("Essa ID ja existe!");
                                    System.out.println("Por favor insira uma nova ID: ");
                                    idExistente = true;
                                    break;
                                }
                            }
                        } while (idExistente);

                        System.out.println("ID aceitavel.");
                        System.out.println("Insira o Nome: ");
                        String nome = entrada.nextLine();

                        System.out.println("Insira o CPF: ");
                        String cpf = entrada.nextLine();

                        System.out.println("Insira a Idade: ");
                        int idade = entrada.nextInt();
                        entrada.nextLine();

                        PessoaFisica novaPessoa = new PessoaFisica(id, nome, cpf, idade);
                        fisicaRepo.inserir(novaPessoa);
                        System.out.println("Pessoa fisica inserida com sucesso!");
                    } else if (tipoPessoa.equalsIgnoreCase("J") || tipoPessoa.equalsIgnoreCase("j")) {
                        System.out.println("Insira uma ID: ");
                        int id;
                        boolean idExistente;
                        do {
                            idExistente = false;
                            id = entrada.nextInt();
                            entrada.nextLine();

                            List<PessoaJuridica> pessoas = juridicaRepo.obterTodos();
                            for (PessoaJuridica pessoa : pessoas) {
                                if (pessoa.getId() == id) {
                                    System.out.println("Essa ID ja existe!");
                                    System.out.println("Por favor insira uma nova ID: ");
                                    idExistente = true;
                                    break;
                                }
                            }
                        } while (idExistente);

                        System.out.println("ID aceitavel.");
                        System.out.println("Insira o nome da empresa: ");
                        String nome = entrada.nextLine();

                        System.out.println("Insira o CNPJ: ");
                        String cnpj = entrada.nextLine();

                        PessoaJuridica novaPessoa = new PessoaJuridica(id, nome, cnpj);
                        juridicaRepo.inserir(novaPessoa);
                        System.out.println("Pessoa juridica inserida com sucesso!");
                    } else {
                        System.out.println("Erro: valor diferente do solicitado.");
                        System.out.println("Por favor insira somente F ou J.");
                    }
                }

                //alterar
                if (acao == 2) {
                    System.out.println("Digite F para alterar uma Pessoa Fisica");
                    System.out.println("ou");
                    System.out.println("Digite J para alterar uma Pessoa Juridica");
                    String tipoPessoa = entrada.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F") || tipoPessoa.equalsIgnoreCase("f")) {
                        System.out.println("Digite a ID da pessoa que deseja alterar: ");
                        int id = entrada.nextInt();
                        entrada.nextLine();

                        List<PessoaFisica> pessoas = fisicaRepo.obterTodos();
                        for (PessoaFisica pessoa : pessoas) {
                            if (pessoa.getId() == id) {
                                System.out.println("Pessoa Fisica encontrada.");
                                System.out.println("Estes sao os dados atuais: ");
                                pessoa.exibir();

                                System.out.println("----------------------------------");

                                System.out.println("Agora insira as alteracoes.");
                                System.out.println("Insira o nome: ");
                                String nome = entrada.nextLine();

                                System.out.println("Insira o CPF: ");
                                String cpf = entrada.nextLine();

                                System.out.println("Insira a idade: ");
                                int idade = entrada.nextInt();
                                entrada.nextLine();

                                PessoaFisica pessoaAlterada = new PessoaFisica(id, nome, cpf, idade);
                                fisicaRepo.alterar(pessoaAlterada);
                                System.out.println("Alteracao realizada com sucesso.");
                            } else {
                                System.out.println("Essa ID não existe.");
                            }
                        }
                    } else if (tipoPessoa.equalsIgnoreCase("J") || tipoPessoa.equalsIgnoreCase("j")) {
                        System.out.println("Digite a ID da pessoa que deseja alterar");
                        int id = entrada.nextInt();
                        entrada.nextLine();

                        List<PessoaJuridica> pessoas = juridicaRepo.obterTodos();
                        for (PessoaJuridica pessoa : pessoas) {
                            if (pessoa.getId() == id) {
                                System.out.println("Pessoa juridica encontrada.");
                                System.out.println("Estes sao os dados atuais");
                                pessoa.exibir();

                                System.out.println("----------------------------------");

                                System.out.println("Agora insira as alteracoes");
                                System.out.println("Insira o nome da empresa: ");
                                String nome = entrada.nextLine();

                                System.out.println("Insira o CNPJ: ");
                                String cnpj = entrada.nextLine();

                                PessoaJuridica pessoaAlterada = new PessoaJuridica(id, nome, cnpj);
                                juridicaRepo.alterar(pessoaAlterada);
                                System.out.println("Pessoa alterada com sucesso.");
                            } else {
                                System.out.println("Essa ID não existe.");
                            }
                        }
                    } else {
                        System.out.println("Erro: Valor inserido diferente do solicitado.");
                        System.out.println("Por favor digite somente F ou J.");
                    }
                }

                //excluir
                if (acao == 3) {
                    System.out.println("Digite F para excluir uma Pessoa Fisica");
                    System.out.println("ou");
                    System.out.println("Digite J para excluir uma Pessoa Juridica");
                    String tipoPessoa = entrada.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F") || tipoPessoa.equalsIgnoreCase("f")) {
                        System.out.println("Qual a ID da pessoa que dejesa exluir?");
                        int id = entrada.nextInt();
                        entrada.nextLine();

                        List<PessoaFisica> pessoas = fisicaRepo.obterTodos();
                        for (PessoaFisica pessoa : pessoas) {
                            if (pessoa.getId() == id) {
                                System.out.println("Pessoa Fisica encontrada");
                                System.out.println("Esses sao os dados: ");
                                pessoa.exibir();
                                System.out.println("---------------------------------------");
                                System.out.println("Para excluir digite 'confirmar' dessa mesma forma.");
                                System.out.println("Caso contrario, digite qualquer outra coisa.");
                                String confirma = entrada.nextLine();

                                if (confirma.equalsIgnoreCase("confirmar")) {
                                    fisicaRepo.excluir(id);
                                    System.out.println("Pessoa excluida com sucesso.");
                                } else {
                                    System.out.println("Pessoa nao excluida.");
                                }
                            } else {
                                System.out.println("Essa ID nao existe.");
                            }
                        }
                    } else if (tipoPessoa.equalsIgnoreCase("J") || tipoPessoa.equalsIgnoreCase("j")) {
                        System.out.println("Qual a ID da pessoa que deseja excluir");
                        int id = entrada.nextInt();
                        entrada.nextLine();

                        List<PessoaJuridica> pessoas = juridicaRepo.obterTodos();
                        for (PessoaJuridica pessoa : pessoas) {
                            if (pessoa.getId() == id) {
                                System.out.println("Pessoa Juridica encontrada");
                                System.out.println("Esses sao os dados: ");
                                pessoa.exibir();
                                System.out.println("------------------------------");
                                System.out.println("Para excluir digite 'confirmar' dessa mesma forma.");
                                System.out.println("Caso contrario, digite qualquer outra coisa");
                                String confirma = entrada.nextLine();

                                if (confirma.equalsIgnoreCase("confirmar")) {
                                    juridicaRepo.excluir(id);
                                    System.out.println("Pessoa excluida com sucesso.");
                                } else {
                                    System.out.println("Pessoa nao excluida.");
                                }
                            } else {
                                System.out.println("Essa ID nao existe.");
                            }
                        }
                    } else {
                        System.out.println("Erro: entrada diferente da solicitada.");
                        System.out.println("Por favor insira somente F ou J.");
                    }
                }

                //Obter/Buscar
                if (acao == 4) {
                    System.out.println("Digite F para buscar uma Pessoa Fisica");
                    System.out.println("ou");
                    System.out.println("Digite J para buscar uma Pessoa Juridica");
                    String tipoPessoa = entrada.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F") || tipoPessoa.equalsIgnoreCase("f")) {
                        System.out.println("Digite a ID da pessoa que deseja ver os dados.");
                        int id = entrada.nextInt();
                        entrada.nextLine();

                        List<PessoaFisica> pessoas = fisicaRepo.obterTodos();
                        for (PessoaFisica pessoa : pessoas) {
                            if (pessoa.getId() == id) {
                                System.out.println("Pessoa Fisica encontrada.");
                                System.out.println("Estes sao os dados:");
                                pessoa.exibir();
                                System.out.println("-----------------------------");
                            } else {
                                System.out.println("Essa ID nao existe");
                            }
                        }
                    } else if (tipoPessoa.equalsIgnoreCase("J") || tipoPessoa.equalsIgnoreCase("j")) {
                        System.out.println("Digite a ID da pessoa que deseja ver os dados.");
                        int id = entrada.nextInt();
                        entrada.nextLine();

                        List<PessoaJuridica> pessoas = juridicaRepo.obterTodos();
                        for (PessoaJuridica pessoa : pessoas) {
                            if (pessoa.getId() == id) {
                                System.out.println("Pessoa Juridica encontrada.");
                                System.out.println("Estes sao os dados:");
                                pessoa.exibir();
                                System.out.println("-------------------------------");
                            } else {
                                System.out.println("Essa ID nao existe.");
                            }
                        }
                    } else {
                        System.out.println("Erro: valor inserido diferente do solicitado.");
                        System.out.println("Por favor digite somente F ou J.");
                    }
                }

                //Obter Todos
                if (acao == 5) {
                    System.out.println("Digite F para visualizar todas as Pessoas Fisicas");
                    System.out.println("ou");
                    System.out.println("Digite J para visualizar todas as Pessoas Juridicas");
                    String tipoPessoa = entrada.nextLine();

                    if (tipoPessoa.equalsIgnoreCase("F") || tipoPessoa.equalsIgnoreCase("f")) {
                        System.out.println("Aqui estao todos os dados de Pessoas Fisicas");
                        System.out.println("-------------------------------");

                        List<PessoaFisica> pessoas = fisicaRepo.obterTodos();
                        for (PessoaFisica pessoa : pessoas) {
                            pessoa.exibir();
                            System.out.println("-------------------------------");
                        }
                    } else if (tipoPessoa.equalsIgnoreCase("J") || tipoPessoa.equalsIgnoreCase("j")) {
                        System.out.println("Aqui entao todos od dados de Pesooas Juridicas");
                        System.out.println("-------------------------------");

                        List<PessoaJuridica> pessoas = juridicaRepo.obterTodos();
                        for (PessoaJuridica pessoa : pessoas) {
                            pessoa.exibir();
                            System.out.println("-------------------------------");
                        }
                    } else {
                        System.out.println("Erro: valor inserido diferente do solicitado.");
                        System.out.println("Por favor insira somente F ou J.");
                    }
                }

                //Salvar/Persistir
                if (acao == 6) {
                    System.out.println("Salvando os dados...");
                    System.out.println("Qual sera o nome do arquivo?");
                    //o leitor não difere letra maiuscula e minuscula
                    String nomeArquivo = entrada.nextLine();

                    try {
                        fisicaRepo.persistir(nomeArquivo + ".fisica.bin");
                        juridicaRepo.persistir(nomeArquivo + ".juridica.bin");
                        System.out.println("Lembre-se do nome desse arquivo");
                        System.out.println("voce pode precisar dele mais tarde.");
                    } catch (IOException e) {
                        System.out.println("Erro ao persistir os dados no disco: " + e.getMessage());
                    }
                }

                //recuperar
                if (acao == 7) {
                    System.out.println("Recuperando os dados...");
                    System.out.println("Qual o nome do arquivo?");
                    String nomeArquivo = entrada.nextLine();

                    try {
                        fisicaRepo.recuperar(nomeArquivo + ".fisica.bin");
                        juridicaRepo.recuperar(nomeArquivo + ".juridica.bin");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada nao permitida: " + e.getMessage());
                break;
            }
        } while (acao != 0);
    }
}
