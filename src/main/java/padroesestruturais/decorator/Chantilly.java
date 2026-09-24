package padroesestruturais.decorator;

import java.math.BigDecimal;

public class Chantilly extends AdicionalDecorator {
    public Chantilly(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", chantilly";
    }

    @Override
    public BigDecimal getPreco() {
        return super.getPreco().add(new BigDecimal("2.50"));
    }
}
