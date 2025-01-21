package prog2;

import java.time.LocalDate;

public class Saque {
    public final LocalDate data = LocalDate.now();
    public final Double valor;

    public Saque(Double valor) {
        this.valor = valor;
    }
}