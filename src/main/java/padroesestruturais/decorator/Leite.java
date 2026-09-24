package padroesestruturais.decorator;

import java.math.BigDecimal;

public class Leite extends AdicionalDecorator {
    public Leite(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", leite";
    }

    @Override
    public BigDecimal getPreco() {
        return super.getPreco().add(new BigDecimal("1.50"));
    }
}
