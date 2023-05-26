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
   
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> Alunos = new ArrayList<>();

    public static void main(String[] args) {

        int menu = 0;
        do {
            System.out.println("Menu de opções");
            System.out.println("1 - Criar Alunos");
            System.out.println("2 - Editar Alunos");
            System.out.println("3 - Excluir Alunos");
            System.out.println("4 - Listar Alunos");
            System.out.println("5 - Buscar Aluno");
            System.out.print("Escolha uma dessas opções: ");

            menu = sc.nextInt();
            sc.nextLine();
            switch (menu) {
                case 1:
                    criarAlunos();
                    break;

                case 2:
                    editarAlunos();
                    break;

                case 3:
                    excluirAlunos();
                    break;
                    
                case 4:
                    listarAlunos();
                    break;
                    
                case 5:
                    buscarAlunos();
                    break;

                default:
                    System.out.println("Opção invalida");

            }

        } while (menu != 5);

    }

   private static void criarAlunos() {
    System.out.println("Digite o nome do Aluno: ");
    String nome = sc.nextLine();
    System.out.println("Digite a idade do Aluno: ");
    String idade = sc.nextLine();
    System.out.println("Digite o curso do Aluno: ");
    String curso = sc.nextLine();
    System.out.println("Digite o semestre do Aluno: ");
    String semestre = sc.nextLine();
    System.out.println("Digite a matricula do Aluno: ");
    String matricula = sc.nextLine();
    System.out.println("Digite o email do Aluno: ");
    String email = sc.nextLine();
    System.out.println("Digite o telefone do Aluno: ");
    String telefone = sc.nextLine();
    
    String dadosAluno = "Nome: " + nome + ", Idade: " + idade + ", Curso: " + curso + ", Semestre: " + semestre + ", Matricula: " + matricula + ", Email: " + email + ", Telefone: " + telefone;
    Alunos.add(dadosAluno);
    
    System.out.println("Aluno criado com sucesso!");
}


   private static void editarAlunos() {
    System.out.println("Digite a matricula do Aluno que deseja editar: ");
    String matricula = sc.nextLine();
    boolean alunoEncontrado = false;

    for (int i = 0; i < Alunos.size(); i++) {
        String dadosAluno = Alunos.get(i);
        if (dadosAluno.contains("Matricula: " + matricula)) {
            System.out.println("Digite o novo nome do Aluno: ");
            String novoNome = sc.nextLine();
            System.out.println("Digite a nova idade do Aluno: ");
            String novaIdade = sc.nextLine();
            System.out.println("Digite o novo curso do Aluno: ");
            String novoCurso = sc.nextLine();
            System.out.println("Digite o novo semestre do Aluno: ");
            String novoSemestre = sc.nextLine();
            System.out.println("Digite o novo email do Aluno: ");
            String novoEmail = sc.nextLine();
            System.out.println("Digite o novo telefone do Aluno: ");
            String novoTelefone = sc.nextLine();
            String novoDadosAluno = "Nome: " + novoNome + ", Idade: " + novaIdade + ", Curso: " + novoCurso + ", Semestre: " + novoSemestre + ", Matricula: " + matricula + ", Email: " + novoEmail + ", Telefone: " + novoTelefone;
            Alunos.set(i, novoDadosAluno);
            alunoEncontrado = true;
            System.out.println("Aluno editado com sucesso!");
            break;
        }
    }

    if (!alunoEncontrado) {
        System.out.println("Aluno nÃ£o encontrado.");
    }
}

    private static void excluirAlunos() {
        System.out.println("Digite a matricula do Aluno que deseja excluir: ");
        String matricula = sc.nextLine();
        boolean alunoEncontrado = false;

        for (int i = 0; i < Alunos.size(); i++) {
            String dadosAluno = Alunos.get(i);
            if (dadosAluno.contains("Matricula: " + matricula)) {
                Alunos.remove(i);
                alunoEncontrado = true;
                System.out.println("Aluno excluido com sucesso!");
                break;
            }
        }

        if (!alunoEncontrado) {
            System.out.println("Aluno nÃ£o encontrado.");
        }
    }

    private static void listarAlunos() {
        if (Alunos.isEmpty()) {
            System.out.println("Não ha, alunos cadastrados.");
        } else {
            System.out.println("Lista de Alunos:");
            for (String aluno : Alunos) {
                System.out.println(aluno);
            }
        }
    }

    private static void buscarAlunos() {
        System.out.println("Digite a matricula do Aluno que deseja buscar: ");
        String matricula = sc.nextLine();
        boolean alunoEncontrado = false;

        for (String dadosAluno : Alunos) {
            if (dadosAluno.contains("Matricula: " + matricula)) {
                System.out.println("Aluno encontrado:");
                System.out.println(dadosAluno);
                alunoEncontrado = true;
                break;
            }
        }

        if (!alunoEncontrado) {
            System.out.println("Aluno nÃ£o encontrado.");
        }
    }
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
