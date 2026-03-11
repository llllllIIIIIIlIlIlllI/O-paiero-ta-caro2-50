package aula0903noia;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Vendas> venda = new ArrayList<>();
        Cliente c1 = new Cliente("Caio", "000.000.000-44");
        Produtos camisa = new Produtos("Camisa", 25.00, 2, 10);
        Vendas v1 = new Vendas(c1, camisa);

        for (Vendas vendaa : venda);
    }
}
