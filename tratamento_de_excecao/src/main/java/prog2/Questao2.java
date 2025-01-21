package prog2;

public class Questao2 {
    public static void main(String args[]) {
        Conta c = new Conta();
        c.deposito(100);
        c.setLimite(50);
        final double valor = 55.0;
        try {
            c.saque(valor);
            System.out.printf("Saque de R$%.2f\n", valor);
        } catch (ContaExcecao e) {
            System.out.println(e);
        }
    }
}
