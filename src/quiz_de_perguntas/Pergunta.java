package quiz_de_perguntas;

public class Pergunta {
    private String pergunta;
    private boolean resposta;

    public Pergunta(String pergunta, boolean resposta) {
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public boolean getResposta() {
        return resposta;
    }
}