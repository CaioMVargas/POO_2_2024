package quiz_de_perguntas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import javax.swing.JOptionPane;

public class Arquivo {
    private List<Pergunta> perguntas;
    private List<String> resultados;

    public Arquivo() {
        this.perguntas = new ArrayList<>();
        this.resultados = new ArrayList<>();
        lerPerguntasDoArquivo();
    }

    private void lerPerguntasDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("perguntasQuiz.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split("\\.\\s*");
                String pergunta = partes[0];
                boolean resposta = partes[1].contains("(Verdadeiro)");
                perguntas.add(new Pergunta(pergunta, resposta));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo de perguntas: " + e.getMessage());
        }
    }

    public void rodadaDePerguntas() {
        Collections.shuffle(perguntas);
        int pontos = 0;
        for (int i = 0; i < 10; i++) {
            Pergunta pergunta = perguntas.get(i);
            String respostaUsuario = JOptionPane.showInputDialog(null, pergunta.getPergunta() + "\nResposta (Verdadeiro/Falso):").trim().toLowerCase();
            boolean respostaCorreta = pergunta.getResposta();
            String resultado = respostaCorreta == (respostaUsuario.equals("verdadeiro")) ? "acerto" : "erro";
            resultados.add((i + 1) + ", " + pergunta.getPergunta() + ", " + resultado);
            if (resultado.equals("acerto")) {
                pontos++;
            }
        }
        JOptionPane.showMessageDialog(null, "Pontuação final: " + pontos);
    }

    public void salvarResultados() {
        try (FileWriter writer = new FileWriter("resultados.txt")) {
            for (String resultado : resultados) {
                writer.write(resultado + "\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar resultados: " + e.getMessage());
        }
    }

    public void exibirResultados() {
        StringBuilder sb = new StringBuilder();
        for (String resultado : resultados) {
            sb.append(resultado).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Score total", JOptionPane.INFORMATION_MESSAGE);
    }
}