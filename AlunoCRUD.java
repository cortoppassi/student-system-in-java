/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.alunocrud;

/**
 *
 * @author Jonathan
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlunoCRUD {
    private static List<Aluno> alunos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;

        do {
            System.out.println("Menu de Opções:");
            System.out.println("1. Criar aluno");
            System.out.println("2. Editar aluno");
            System.out.println("3. Excluir aluno");
            System.out.println("4. Listar alunos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    criarAluno();
                    break;
                case 2:
                    editarAluno();
                    break;
                case 3:
                    excluirAluno();
                    break;
                case 4:
                    listarAlunos();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void criarAluno() {
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o registro do aluno: ");
        String registro = scanner.nextLine();

        Aluno aluno = new Aluno(nome, registro);
        alunos.add(aluno);

        System.out.println("Aluno criado com sucesso!");
    }

    private static void editarAluno() {
        System.out.print("Digite o registro do aluno que deseja editar: ");
        String registro = scanner.nextLine();

        Aluno aluno = buscarAlunoPorRegistro(registro);

        if (aluno != null) {
            System.out.print("Digite o novo nome do aluno: ");
            String novoNome = scanner.nextLine();

            aluno.setNome(novoNome);

            System.out.println("Aluno editado com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void excluirAluno() {
        System.out.print("Digite o registro do aluno que deseja excluir: ");
        String registro = scanner.nextLine();

        Aluno aluno = buscarAlunoPorRegistro(registro);

        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void listarAlunos() {
        System.out.println("Lista de Alunos:");
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + ", Registro: " + aluno.getRegistro());
        }
    }

    private static Aluno buscarAlunoPorRegistro(String registro) {
        for (Aluno aluno : alunos) {
            if (aluno.getRegistro().equals(registro)) {
                return aluno;
            }
        }
        return null;
    }
}

class Aluno {
    private String nome;
    private String registro;

    public Aluno(String nome, String registro) {
        this.nome = nome;
        this.registro = registro;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
}
