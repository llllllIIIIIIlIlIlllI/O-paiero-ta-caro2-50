import java.util.ArrayList;
import java.util.List;

public class Historico {
    private List<Transacao> transacoes = new ArrayList<>();


    public void adicionarTransacao (Transacao transacao) {
        this.transacoes.add(transacao);
    }

    public List<String> listar() {
        List<String> historico = new ArrayList<>();
        if (this.transacoes.isEmpty()) {
            historico.add("Não há transações.");
            return historico;
        }

        for (Transacao t : this.transacoes) {
            String transacaoFormatada = t.toString();
            historico.add(transacaoFormatada);
        }

        return historico;
    }
}