public class CatalogoProdutos {
    private class No {
        Produto produto;
        No esquerda;
        No direita;

        No(Produto produto) {
            this.produto = produto;
            this.esquerda = null;
            this.direita = null;
        }
    }

    private No raiz;

    public CatalogoProdutos() {
        this.raiz = null;
    }

    public void inserir(Produto produto) {
        raiz = inserirRecursivo(raiz, produto);
    }

    private No inserirRecursivo(No atual, Produto produto) {
        if (atual == null) {
            return new No(produto);
        }

        int comparacao = produto.compareTo(atual.produto);
        if (comparacao < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, produto);
        } else if (comparacao > 0) {
            atual.direita = inserirRecursivo(atual.direita, produto);
        }
        // Se comparacao == 0, o produto já existe, não inserir duplicado

        return atual;
    }

    public Produto buscar(String nome) {
        return buscarRecursivo(raiz, nome);
    }

    private Produto buscarRecursivo(No atual, String nome) {
        if (atual == null) {
            return null;
        }

        int comparacao = nome.compareTo(atual.produto.getNome());
        if (comparacao == 0) {
            return atual.produto;
        } else if (comparacao < 0) {
            return buscarRecursivo(atual.esquerda, nome);
        } else {
            return buscarRecursivo(atual.direita, nome);
        }
    }

    public void remover(String nome) {
        raiz = removerRecursivo(raiz, nome);
    }

    private No removerRecursivo(No atual, String nome) {
        if (atual == null) {
            return null;
        }

        int comparacao = nome.compareTo(atual.produto.getNome());
        if (comparacao < 0) {
            atual.esquerda = removerRecursivo(atual.esquerda, nome);
        } else if (comparacao > 0) {
            atual.direita = removerRecursivo(atual.direita, nome);
        } else {
            // Nó encontrado
            // Caso 1: Nó sem filhos
            if (atual.esquerda == null && atual.direita == null) {
                return null;
            }
            // Caso 2: Nó com apenas um filho
            if (atual.esquerda == null) {
                return atual.direita;
            }
            if (atual.direita == null) {
                return atual.esquerda;
            }
            // Caso 3: Nó com dois filhos
            // Encontrar o menor valor na subárvore direita (sucessor)
            Produto menorValor = encontrarMenor(atual.direita);
            atual.produto = menorValor;
            atual.direita = removerRecursivo(atual.direita, menorValor.getNome());
        }
        return atual;
    }

    private Produto encontrarMenor(No no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no.produto;
    }

    public void listarEmOrdem() {
        listarEmOrdemRecursivo(raiz);
    }

    private void listarEmOrdemRecursivo(No atual) {
        if (atual != null) {
            listarEmOrdemRecursivo(atual.esquerda);
            System.out.println(atual.produto);
            listarEmOrdemRecursivo(atual.direita);
        }
    }
}
