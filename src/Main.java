import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantos alunos deseja cadastrar?");

        while (!scanner.hasNextInt()) { // Garante que o usuário digite um número válido
            System.out.println("Por favor, digite um número inteiro válido.");
            scanner.next(); // Descarta a entrada inválida
        }

        int quantidadeAlunos = scanner.nextInt();
        scanner.nextLine();

        while (quantidadeAlunos <= 0) { // Verifica se o número é maior que 0
            System.out.println("Por favor, digite um número maior que 0.");
            while (!scanner.hasNextInt()) { // Garante que o usuário digite um número válido
                System.out.println("Por favor, digite um número inteiro válido.");
                scanner.next(); // Descarta a entrada inválida
            }
            quantidadeAlunos = scanner.nextInt();
            scanner.nextLine();
        }

        String resultado;
        String[] nomes = new String[quantidadeAlunos];
        double[][] notas = new double[quantidadeAlunos][2];
        double[] medias = new double[quantidadeAlunos];

        int aprovados = 0, reprovados = 0, recuperacao = 0;
        double somaDasMedias = 0;
        double maiorNota = 0, menorNota = 10;

        for (int i = 0; i < quantidadeAlunos; i++) {
            System.out.println("Digite o nome do " + (i + 1) + "º aluno: ");
            nomes[i] = scanner.nextLine();

            double somaDasNotas = 0;
            for (int j = 0; j < 2; j++) {
                System.out.println((j + 1) + "º nota de " + nomes[i] + ": ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Por favor, digite uma nota válida.");
                    scanner.next();
                }
                notas[i][j] = scanner.nextDouble();
                somaDasNotas += notas[i][j];

                if (notas[i][j] > maiorNota) maiorNota = notas[i][j];
                if (notas[i][j] < menorNota) menorNota = notas[i][j];
            }
            scanner.nextLine();

            medias[i] = somaDasNotas / 2;
            somaDasMedias += medias[i];

            if (medias[i] >= 7) {
                aprovados++;
            }
            else if (medias[i] >= 5) {
                recuperacao++;
            }
            else {
                reprovados++;
            }
        }

        System.out.println("Resultados: ");
        System.out.println(" ");
        for (int i = 0; i < quantidadeAlunos; i++) {
            if (medias[i] >= 7) {
                resultado = "Aprovado";
            }
            else if (medias[i] >= 5) {
                resultado = "Recuperação";
            }
            else {
                resultado = "Reprovado";
            }

            System.out.println(nomes[i] + " - Média: " + medias[i] + " - Status: " + resultado);
        }

        double mediaDaTurma = somaDasMedias / quantidadeAlunos;

        System.out.println("Estatísticas da Turma:");
        System.out.println(" ");
        System.out.println("Média da turma: " + mediaDaTurma);
        System.out.println("Maior nota: " + maiorNota);
        System.out.println("Menor nota: " + menorNota);
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Recuperação: " + recuperacao);
        System.out.println("Reprovados: " + reprovados);
    }
}