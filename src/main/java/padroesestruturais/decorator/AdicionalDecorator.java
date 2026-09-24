package padroesestruturais.decorator;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class AdicionalDecorator implements Bebida {
    private final Bebida bebida;

    protected AdicionalDecorator(Bebida bebida) {
        this.bebida = Objects.requireNonNull(bebida, "A bebida é obrigatória");
    }

    @Override
    public String getDescricao() {
        return this.bebida.getDescricao();
    }

    @Override
    public BigDecimal getPreco() {
        return this.bebida.getPreco();
    }
}
