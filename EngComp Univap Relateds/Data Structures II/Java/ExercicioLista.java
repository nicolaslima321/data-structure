class ExercicioLista {
    
    public int total;
    public Node primeiro;
    public Node ultimo;

    public Object pega(int posicao) throws Exception {
        if (posicao > this.total || posicao < 0) {
            throw new Exception("Posicao invalida ou inexistente");
        }

        Node node = this.primeiro;
        int posicaoAtual = 0;

        for(int i=0; i<=posicao; i++) {
            node = node.getNext();
            posicaoAtual++;
        }

        return node.getItem();
    }

    public Node pegaCelula(int posicao) throws Exception {
        if (posicao > this.total || posicao < 0) {
            throw new Exception("Posicao invalida ou inexistente");
        }

        Node node = this.primeiro;
        int posicaoAtual = 0;

        for(int i=0; i<=posicao+1; i++) {
            node = node.getNext();
            posicaoAtual++;
        }

        return node;
    }    

    public void remove(int posicao) throws Exception {
        if (posicao > this.total || posicao < 0) {
            throw new Exception("Posicao invalida ou inexistente");
        }

        if (posicao == 1) {
            //removeDoComeco();
        } else {
            Node node = this.primeiro;
            int count = 0;

            for (int i=0; i<=posicao-1; i++) {
                node = node.getNext();
                count++;
            }

            Node noRemovido = node.getNext();
            node.setNext(noRemovido.getNext());
            this.total--;
        }
    }

    public void adiciona(Object item) {
        if (this.total == 0) {
            Node node = new Node(item);
            this.primeiro = node;
        } else {
            Node newNode = new Node(item);
            Node node = this.ultimo;
            node.setNext(newNode);
            this.ultimo = newNode;
        }
    }

    public Object busca(Object itemDesejado) throws Exception {
        Object itemAtual = null;

        for (int i=0; i<=this.total; i++) {
            itemAtual = pega(i);
            if (itemAtual == itemDesejado) {
                System.out.println("Elemento existente na posicao "+i+" da lista");
                return itemAtual;
            }
        }

        System.out.println("Elemento nao encontrado!");
        return null;
    }

    public void copiarParaVetor(ExercicioLista lista) throws Exception {
        Object vetor[] = new Object[this.total];
        for(int i=0; i<=this.total; i++) {
            vetor[i] = lista.pega(i);
        }
    }

    public boolean listasSaoIguais(ExercicioLista lista1, ExercicioLista lista2) throws Exception {
        if (lista1.total != lista2.total) {
            return false;
        }

        for(int i=0; i<=lista1.total; i++) {
            if (lista1.pega(i) != lista2.pega(1)) {
                return false;
            }
        }

        return true;
    }

    public boolean listaEstaEmOrdemCrescente(ExercicioLista lista) {
        int numeroAtual = 0;
        int menorNumero = 0;

        for(int i=0; i<=lista.total; i++) {
            numeroAtual = Integer.parseInt(lista.pega(i).toString());
            if (numeroAtual < menorNumero) {
                menorNumero = numeroAtual;
            } else {
                return false;
            }
        }

        return true;
    }

    public void removeNosDoTeclado(ExercicioLista lista) {
        for (int i=0; i<=lista.total; i++) {
            lista.remove(i);
        }
    }

    public boolean busca(Object itemDesejado) throws Exception {
        Object itemAtual = null;

        for (int i=0; i<=this.total; i++) {
            itemAtual = pega(i);
            if (itemAtual == itemDesejado) {
                System.out.println("Elemento existente na posicao "+i+" da lista");
                return true;
            }
        }

        System.out.println("Elemento nao encontrado!");
        return false;
    }



    // 9- Celula é a classe responsável por conter o conteúdo da minha estrutura, e conterá também uma propriedade referenciando a célula seguinte (No caso do exemplo abordado, porém existem referenciamentos posteriores e antecessores, como lista duplamente encadeada)

    public static void main(String args[]) {
    }
}