import java.util.Scanner;
import java.util.ArrayList;

public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Alunos> alunos = new ArrayList<>();

    public static void main(String[] args) {

        alunosPredefinidos();

        int menu = 0;
        do {
            exibirMenu();

            try {
                menu = Integer.parseInt(sc.nextLine());

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
                        System.out.println("Opcao invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opcao invalida. Por favor, digite um numero valido.");
            }

        } while (menu != 5);

    }

    private static void exibirMenu() {
        System.out.println("Menu de opcoes");
        System.out.println("1 - Criar Alunos");
        System.out.println("2 - Editar Alunos");
        System.out.println("3 - Excluir Alunos");
        System.out.println("4 - Listar Alunos");
        System.out.println("5 - Buscar Aluno");
        System.out.print("Escolha uma dessas opcoes: ");
    }

    private static void criarAlunos() {
        System.out.println("Digite o tipo de aluno (1 - Graduacao ou 2 - Pos-graduacao): ");
        int tipoAluno = Integer.parseInt(sc.nextLine());

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

        if (tipoAluno == 1) {
            System.out.println("Digite a instituicao de origem do Aluno: ");
            String instituicaoOrigem = sc.nextLine();

            System.out.println("Digite o curso de origem do Aluno: ");
            String cursoOrigem = sc.nextLine();

            AlunoGraduacao aluno = new AlunoGraduacao(nome, idade, curso, semestre, matricula,
                    instituicaoOrigem, cursoOrigem);
            alunos.add(aluno);
            System.out.println("Aluno de Graduacao cadastrado com sucesso!");
        } else if (tipoAluno == 2) {
            System.out.println("Digite a area de pesquisa do Aluno: ");
            String areaPesquisa = sc.nextLine();

            System.out.println("Digite o titulo da dissertacao do Aluno: ");
            String tituloDissertacao = sc.nextLine();

            AlunoPosGraduacao aluno = new AlunoPosGraduacao(nome, idade, curso, semestre, matricula,
                    areaPesquisa, tituloDissertacao);
            alunos.add(aluno);
            System.out.println("Aluno de Pos-graduacao cadastrado com sucesso!");
        } else {
            System.out.println("Tipo de aluno invalido. Por favor, escolha 1 para Graduacao ou 2 para Pos-graduacao.");
        }
    }

    private static void editarAlunos() {
        System.out.println("Digite a matricula do Aluno que deseja editar: ");
        String matricula = sc.nextLine();

        boolean alunoEncontrado = false;
        for (Alunos aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                alunoEncontrado = true;
                try {
                    System.out.println("Digite o novo nome do Aluno: ");
                    String novoNome = sc.nextLine();
                    System.out.println("Digite a nova idade do Aluno: ");
                    String novaIdade = sc.nextLine();
                    System.out.println("Digite o novo curso do Aluno: ");
                    String novoCurso = sc.nextLine();
                    System.out.println("Digite o novo semestre do Aluno: ");
                    String novoSemestre = sc.nextLine();

                    aluno.setNome(novoNome);
                    aluno.setIdade(novaIdade);
                    aluno.setCurso(novoCurso);
                    aluno.setSemestre(novoSemestre);

                    System.out.println("Aluno editado com sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro ao editar aluno: " + e.getMessage());
                }
                break;
            }
        }

        if (!alunoEncontrado) {
            System.out.println("Aluno nao encontrado. Por favor, digite uma matricula valida.");
        }
    }

    private static void excluirAlunos() {
        System.out.println("Digite a matricula do Aluno que deseja excluir: ");
        String matricula = sc.nextLine();

        boolean alunoEncontrado = false;
        for (int i = 0; i < alunos.size(); i++) {
            Alunos aluno = alunos.get(i);
            if (aluno.getMatricula().equals(matricula)) {
                alunoEncontrado = true;
                try {
                    alunos.remove(i);
                    System.out.println("Aluno excluido com sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro ao excluir aluno: " + e.getMessage());
                }
                break;
            }
        }

        if (!alunoEncontrado) {
            System.out.println("Aluno nao encontrado. Por favor, digite uma matricula valida.");
        }
    }

    private static void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Nao ha alunos cadastrados.");
        } else {
            System.out.println("\t\t\t-----Lista de Alunos-----");
            System.out.println("|Nome|\t\t|Idade|\t\t|Curso|\t\t|Semestre|\t|Matricula|\t|Tipo|\t\t\t|");
            System.out.println("___________________________________________________________________________________");

            for (Alunos aluno : alunos) {
                String tipoAluno;
                if (aluno instanceof AlunoGraduacao) {
                    tipoAluno = "Graduacao";
                } else if (aluno instanceof AlunoPosGraduacao) {
                    tipoAluno = "Pos-graduacao";
                } else {
                    tipoAluno = "Desconhecido";
                }
            
                System.out.println(aluno.getNome() + "\t\t" + aluno.getIdade() + "\t\t" + aluno.getCurso() + "\t\t" + aluno.getSemestre() + "\t\t" + aluno.getMatricula());
                System.out.println("___________________________________________________________________________________");
            }
        }
    }

    private static void buscarAlunos() {
        System.out.println("Digite a matricula do Aluno que deseja buscar: ");
        String matricula = sc.nextLine();

        for (Alunos aluno : alunos) {
            if (aluno.getMatricula().equals(matricula)) {
                System.out.println("Aluno encontrado:");
                System.out.println(aluno);
                break;
            }
        }
    }

    private static void alunosPredefinidos() {
        Alunos aluno1 = new Alunos("Joao", "20", "Engenharia", "3", "2021001");
        Alunos aluno2 = new Alunos("Maria", "22", "Administracao", "5", "2021002");
        Alunos aluno3 = new Alunos("Pedro", "21", "Medicina", "4", "2021003");
        Alunos aluno4 = new Alunos("Ana", "19", "Psicologia", "2", "2021004");
        Alunos aluno5 = new Alunos("Lucas", "23", "Direito", "\t6", "2021005");
        Alunos aluno6 = new Alunos("Mariana", "20", "Arquitetura", "3", "2021006");
        Alunos aluno7 = new Alunos("Gabriel", "22", "C. Computacao", "5", "2021007");

        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        alunos.add(aluno4);
        alunos.add(aluno5);
        alunos.add(aluno6);
        alunos.add(aluno7);
    }
}
