package padroesestruturais.decorator;

import java.text.NumberFormat;
import java.util.Locale;

public class Aplicacao {
    public static void main(String[] args) {
        Bebida bebida = new Chantilly(new Chocolate(new Leite(new CafeExpresso())));
        NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        System.out.println(bebida.getDescricao());
        System.out.println("Total: " + moeda.format(bebida.getPreco()));
    }
}
