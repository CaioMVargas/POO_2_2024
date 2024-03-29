package quiz_de_perguntas;

import javax.swing.JOptionPane;

public class Prova {
    public static void main(String[] args) {
        Arquivo arquivo = new Arquivo();

        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n1 - Rodada de perguntas\n2 - Score total\n3 - Sair"));
            switch (opcao) {
                case 1:
                    arquivo.rodadaDePerguntas();
                    arquivo.salvarResultados();
                    break;
                case 2:
                    arquivo.exibirResultados();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } while (opcao != 3);
    }
}