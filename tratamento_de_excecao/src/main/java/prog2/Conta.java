package prog2;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Conta {
    private double saldo;
    private double limite;
    private Map<LocalDate, List<Saque>> saquesPorDia = new HashMap<>();

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void deposito(double valor) {
        saldo += valor;
    }

    public void saque(double valor) throws ContaExcecao {
        if (valor < 0) {
            throw new ContaExcecao("Não pode sacar valor negativo");
        }
        if (somaDosSaquesDoDia(LocalDate.now()) + valor > limite) {
            throw new ContaExcecao("Saque excede limite diário de saque da conta");
        }
        if (valor > saldo) {
            throw new ContaExcecao("Saque excede saldo da conta");
        }
        saldo -= valor;
        registrarSaque(valor);
    }

    public Saque registrarSaque(double valor) {
        saquesPorDia.putIfAbsent(LocalDate.now(), new ArrayList<>());
        final List<Saque> saques = saquesPorDia.get(LocalDate.now());
        final Saque saque = new Saque(valor);
        saques.add(saque);
        return saque;
    }

    public double somaDosSaquesDoDia(LocalDate dia) {
        final List<Saque> saques = saquesPorDia.get(dia);
        if (saques == null)
            return 0;
        return saques.stream().map((saque) -> saque.valor).reduce(0.0, (a, b) -> a + b);
    }
}
