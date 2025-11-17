public class Main {
    public static void main(String[] args) {
        // 1. Instanciar o CatalogoProdutos
        CatalogoProdutos catalogo = new CatalogoProdutos();

        // 2. Inserir pelo menos 8 produtos distintos na árvore
        System.out.println("=== INSERINDO PRODUTOS NO CATÁLOGO ===\n");
        catalogo.inserir(new Produto(101, "Mouse Gamer", 150.00, 30));
        catalogo.inserir(new Produto(102, "Teclado Mecânico", 350.00, 50));
        catalogo.inserir(new Produto(103, "Monitor LED 24\"", 800.00, 15));
        catalogo.inserir(new Produto(104, "Webcam HD", 250.00, 25));
        catalogo.inserir(new Produto(105, "Headset Gamer", 200.00, 40));
        catalogo.inserir(new Produto(106, "Mousepad RGB", 80.00, 60));
        catalogo.inserir(new Produto(107, "Cadeira Gamer", 1200.00, 10));
        catalogo.inserir(new Produto(108, "SSD 500GB", 400.00, 35));

        // 3. Exibir todos os produtos em ordem alfabética
        System.out.println("=== LISTAGEM DE PRODUTOS (Ordem Alfabética) ===\n");
        catalogo.listarEmOrdem();

        // 4. Realizar a busca por um produto existente
        System.out.println("\n=== BUSCA POR PRODUTO EXISTENTE ===\n");
        String nomeBuscado = "Teclado Mecânico";
        Produto produtoEncontrado = catalogo.buscar(nomeBuscado);
        if (produtoEncontrado != null) {
            System.out.println("Produto encontrado: " + produtoEncontrado);
        } else {
            System.out.println("Produto não encontrado!");
        }

        // 5. Tentar buscar por um produto inexistente
        System.out.println("\n=== BUSCA POR PRODUTO INEXISTENTE ===\n");
        String nomeInexistente = "Notebook";
        Produto produtoInexistente = catalogo.buscar(nomeInexistente);
        if (produtoInexistente != null) {
            System.out.println("Produto encontrado: " + produtoInexistente);
        } else {
            System.out.println("Produto '" + nomeInexistente + "' não foi encontrado no catálogo!");
        }

        // 6. Remover um dos produtos (nó com dois filhos)
        // "Monitor LED 24\"" terá dois filhos se inserirmos na ordem acima
        System.out.println("\n=== REMOVENDO PRODUTO ===\n");
        String nomeRemover = "Monitor LED 24\"";
        System.out.println("Removendo produto: " + nomeRemover);
        catalogo.remover(nomeRemover);

        // 7. Listar os produtos novamente
        System.out.println("\n=== LISTAGEM APÓS REMOÇÃO (Ordem Alfabética) ===\n");
        catalogo.listarEmOrdem();
    }
}
