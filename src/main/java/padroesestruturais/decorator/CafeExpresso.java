package padroesestruturais.decorator;

import java.math.BigDecimal;

public class CafeExpresso implements Bebida {
    @Override
    public String getDescricao() {
        return "Café expresso";
    }

    @Override
    public BigDecimal getPreco() {
        return new BigDecimal("5.00");
    }
}
