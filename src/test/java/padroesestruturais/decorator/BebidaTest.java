package padroesestruturais.decorator;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BebidaTest {

    @Test
    void deveCalcularCafe() {
        Bebida bebida = new CafeExpresso();
        assertEquals(new BigDecimal("5.00"), bebida.getPreco());
        assertEquals("Café expresso", bebida.getDescricao());
    }

    @Test
    void deveCalcularCafeComLeite() {
        Bebida bebida = new Leite(new CafeExpresso());
        assertEquals(new BigDecimal("6.50"), bebida.getPreco());
        assertEquals("Café expresso, leite", bebida.getDescricao());
    }

    @Test
    void deveCalcularCafeComChocolate() {
        Bebida bebida = new Chocolate(new CafeExpresso());
        assertEquals(new BigDecimal("7.00"), bebida.getPreco());
        assertEquals("Café expresso, chocolate", bebida.getDescricao());
    }

    @Test
    void deveCalcularCafeComChantilly() {
        Bebida bebida = new Chantilly(new CafeExpresso());
        assertEquals(new BigDecimal("7.50"), bebida.getPreco());
        assertEquals("Café expresso, chantilly", bebida.getDescricao());
    }

    @Test
    void deveCalcularCafeComLeiteComChocolate() {
        Bebida bebida = new Chocolate(new Leite(new CafeExpresso()));
        assertEquals(new BigDecimal("8.50"), bebida.getPreco());
        assertEquals("Café expresso, leite, chocolate", bebida.getDescricao());
    }

    @Test
    void deveCalcularCafeComLeiteComChantilly() {
        Bebida bebida = new Chantilly(new Leite(new CafeExpresso()));
        assertEquals(new BigDecimal("9.00"), bebida.getPreco());
        assertEquals("Café expresso, leite, chantilly", bebida.getDescricao());
    }

    @Test
    void deveCalcularCafeComChocolateComChantilly() {
        Bebida bebida = new Chantilly(new Chocolate(new CafeExpresso()));
        assertEquals(new BigDecimal("9.50"), bebida.getPreco());
        assertEquals("Café expresso, chocolate, chantilly", bebida.getDescricao());
    }

    @Test
    void deveCalcularCafeComLeiteComChocolateComChantilly() {
        Bebida bebida = new Chantilly(new Chocolate(new Leite(new CafeExpresso())));
        assertEquals(new BigDecimal("11.00"), bebida.getPreco());
        assertEquals("Café expresso, leite, chocolate, chantilly", bebida.getDescricao());
    }

    @Test
    void devePermitirPorcoesRepetidas() {
        Bebida bebida = new Leite(new Leite(new CafeExpresso()));
        assertEquals(new BigDecimal("8.00"), bebida.getPreco());
        assertEquals("Café expresso, leite, leite", bebida.getDescricao());
    }

    @Test
    void devePreservarOrdemDosAdicionais() {
        Bebida primeira = new Leite(new Chocolate(new CafeExpresso()));
        Bebida segunda = new Chocolate(new Leite(new CafeExpresso()));
        assertEquals(primeira.getPreco(), segunda.getPreco());
        assertEquals("Café expresso, chocolate, leite", primeira.getDescricao());
        assertEquals("Café expresso, leite, chocolate", segunda.getDescricao());
    }

    @Test
    void deveManterBebidaOriginalAoCriarPedidos() {
        Bebida base = new CafeExpresso();
        Bebida comLeite = new Leite(base);
        Bebida comChocolate = new Chocolate(base);
        assertEquals(new BigDecimal("6.50"), comLeite.getPreco());
        assertEquals(new BigDecimal("7.00"), comChocolate.getPreco());
        assertEquals(new BigDecimal("5.00"), base.getPreco());
        assertEquals("Café expresso", base.getDescricao());
    }

    @Test
    void deveRejeitarBebidaNulaEmLeite() {
        assertThrows(NullPointerException.class, () -> new Leite(null));
    }

    @Test
    void deveRejeitarBebidaNulaEmChocolate() {
        assertThrows(NullPointerException.class, () -> new Chocolate(null));
    }

    @Test
    void deveRejeitarBebidaNulaEmChantilly() {
        assertThrows(NullPointerException.class, () -> new Chantilly(null));
    }

    @Test
    void deveDecorarOutraImplementacaoDeBebida() {
        Bebida cha = new Bebida() {
            public String getDescricao() { return "Chá"; }
            public BigDecimal getPreco() { return new BigDecimal("3.25"); }
        };
        Bebida bebida = new Leite(cha);
        assertEquals("Chá, leite", bebida.getDescricao());
        assertEquals(new BigDecimal("4.75"), bebida.getPreco());
    }
}
