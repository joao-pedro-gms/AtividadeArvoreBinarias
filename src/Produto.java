public class Produto implements Comparable<Produto> {
    private int codigo;
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(int codigo, String nome, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int compareTo(Produto outro) {
        return this.nome.compareTo(outro.nome);
    }

    @Override
    public String toString() {
        return String.format("Cód: %d, Nome: %s, Preço: R$ %.2f, Estoque: %d",
                codigo, nome, preco, quantidadeEstoque);
    }
}
