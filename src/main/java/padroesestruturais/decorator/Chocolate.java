package padroesestruturais.decorator;

import java.math.BigDecimal;

public class Chocolate extends AdicionalDecorator {
    public Chocolate(Bebida bebida) {
        super(bebida);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + ", chocolate";
    }

    @Override
    public BigDecimal getPreco() {
        return super.getPreco().add(new BigDecimal("2.00"));
    }
}
