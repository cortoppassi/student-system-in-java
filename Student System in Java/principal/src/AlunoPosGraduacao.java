class AlunoPosGraduacao extends Alunos {
    private String areaPesquisa;
    private String tituloDissertacao;

    public AlunoPosGraduacao(String nome, String idade, String curso, String semestre, String matricula, String areaPesquisa, String tituloDissertacao) {
        super(nome, idade, curso, semestre, matricula);
        this.areaPesquisa = areaPesquisa;
        this.tituloDissertacao = tituloDissertacao;
    }

    public String getAreaPesquisa() {
        return areaPesquisa;
    }

    public void setAreaPesquisa(String areaPesquisa) {
        this.areaPesquisa = areaPesquisa;
    }

    public String getTituloDissertacao() {
        return tituloDissertacao;
    }

    public void setTituloDissertacao(String tituloDissertacao) {
        this.tituloDissertacao = tituloDissertacao;
    }
}