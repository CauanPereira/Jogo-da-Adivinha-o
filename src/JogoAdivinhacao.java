import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random valorAleatorio = new Random();

        System.out.println("\nCaro jogador, seja muito bem-vindo ao Jogo da Adivinhação!\n");

        // Definindo variáveis e alocando método
        int valorMinimo = verificacaoEntradas("Estabeleça um valor mínimo para o seu intervalo: ", sc);
        int valorMaximo = verificacaoEntradas("Estabeleça um valor máximo para o seu intervalo: ", sc);
        boolean respostaCorreta = false;

        // Geração do número secreto
        int numeroSecreto = valorAleatorio.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;

        // Apresentação do intervalo estabelecido pelo usuário
        System.out.println("\nO jogo iniciou, agora tente adivinhar o número que estiver no intervalo entre " + valorMinimo + " e " + valorMaximo);
        System.out.println("Caso deseje sair do jogo, digite a tecla 0\n");

        // Estabelecendo loop de tentativas para o usuário
        while (!respostaCorreta) {

            int tentativaJogador = verificacaoEntradas("Digite sua tentativa: ", sc);

            // Condição para caso o usuário deseje sair do jogo
            if (tentativaJogador == 0) {

                System.out.println("\nCaro jogador, você acabou de encerrar o jogo! O número secreto era: " + numeroSecreto);
                System.out.println("Lamento por você ter finalizado, mas obrigado por ter jogado!");
                sc.close();
                break;
            }

            // Fornecendo dicas interativas ao usuário
            if (tentativaJogador < valorMinimo || tentativaJogador > valorMaximo) {

                System.out.println("Caro jogador, você digitou um número fora do intervalo estabelecido.\n");

            } else if (tentativaJogador < numeroSecreto) {

                System.out.println("O número secreto é maior que " + tentativaJogador + ".");

            } else if (tentativaJogador > numeroSecreto) {

                System.out.println("O número secreto é menor que " + tentativaJogador + ".");

            } else {

                System.out.println("Meus parabéns, jogador! O número secreto era: " + numeroSecreto + ". E você conseguiu adivinhá-lo!\n");
                respostaCorreta = true;
            }
        }
        
    }

    // Método para obter entrada numérica válida do usuário
    private static int verificacaoEntradas(String informacao, Scanner sc) {

        int valorNumerico;
       
        while (true) {

            System.out.println(informacao);

            try {

                valorNumerico = sc.nextInt(); // Lê um número inteiro
                break; // Sai do loop se a entrada for válida

            } catch (Exception e) {

                System.out.println("Caro usuário, você digitou um valor inválido. Por favor, insira apenas valores numéricos.\n");
                sc.next(); // Limpa a entrada inválida
            }
        }

        return valorNumerico;
    }
}
