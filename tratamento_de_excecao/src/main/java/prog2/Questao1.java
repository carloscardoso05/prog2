package prog2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Questao1 {
    public static void main(String args[]) {
        final Scanner scan = new Scanner(System.in);
        System.out.println("Preencha 3 valores no array na posição desejada.");
        final String pos[] = { "primeira", "segunda", "terceira" };
        final int valores[] = new int[3];
        for (int i = 0; i < pos.length; i++) {
            System.out.print("Diga a " + pos[i] + " posição: ");
            int idx = readValidInt(scan, (n) -> n >= 0 && n < valores.length,
                    "A posição deve estar entre 0 e %d".formatted(valores.length - 1));
            System.out.print("Diga o valor da posição " + idx + ": ");
            int val = readInt(scan);
            valores[idx] = val;
        }
        System.out.printf("Os 3 valores são: %s\n", Arrays.toString(valores));
        try {
            scan.close();
        } catch (IllegalStateException e) {
            System.out.println("Scanner já foi fechado");
        }
    }

    public static int readInt(Scanner scan) {
        while (true) {
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Insira um inteiro válido");
            }
        }
    }

    public static int readValidInt(Scanner scan, Function<Integer, Boolean> validation, String errorMessage) {
        while (true) {
            final int value = readInt(scan);
            if (validation.apply(value)) {
                return value;
            }
            System.out.println(errorMessage);
        }
    }
}