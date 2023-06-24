class AlunoGraduacao extends Alunos {
    private String instituicaoOrigem;
    private String cursoOrigem;

    public AlunoGraduacao(String nome, String idade, String curso, String semestre, String matricula, String instituicaoOrigem, String cursoOrigem) {
        super(nome, idade, curso, semestre, matricula);
        this.instituicaoOrigem = instituicaoOrigem;
        this.cursoOrigem = cursoOrigem;
    }

    public String getInstituicaoOrigem() {
        return instituicaoOrigem;
    }

    public void setInstituicaoOrigem(String instituicaoOrigem) {
        this.instituicaoOrigem = instituicaoOrigem;
    }

    public String getCursoOrigem() {
        return cursoOrigem;
    }

    public void setCursoOrigem(String cursoOrigem) {
        this.cursoOrigem = cursoOrigem;
    }
}