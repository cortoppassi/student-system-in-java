class Alunos {
    private String nome;
    private String idade;
    private String curso;
    private String semestre;
    private String matricula;

    public Alunos(String nome, String idade, String curso, String semestre, String matricula) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.semestre = semestre;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}