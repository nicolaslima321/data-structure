class ListaEncadeada {
    
    public int total;
    public Node primeiro;
    public Node ultimo;


    public boolean posicaoExistenteEstaOcupada(int posicao) throws Exception {
        if (this.posicaoOcupada(posicao)) {
            Object currentElement = pega(posicao);
            return (currentElement != null);
        } else {
            throw new Exception("Posicao nao existente");
        }
    }

    public boolean posicaoOcupada(int posicao) {
        return ((posicao >= 0) && (posicao < this.total));
    }

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

    public void removeDoComeco() {
        if (this.total == 0) {
            return;
        }

        this.primeiro = this.primeiro.getNext();
        this.total--;

        if (this.total == 0) {
            this.ultimo = null;
        }
    }

    public void remove(int posicao) throws Exception {
        if (posicao > this.total || posicao < 0) {
            throw new Exception("Posicao invalida ou inexistente");
        }

        if (posicao == 1) {
            removeDoComeco();
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

    public boolean ehNumeroPrimo(Object numero) {
        int count = 0;
        int numeroInt = new Integer(numero.toString());

        for (int i = 1; i<=numeroInt; i++) {
            if (numeroInt%i == 0) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }

        return true;
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

    public void removeNumerosNaoPrimos() throws Exception {
        Object itemAtual = null;

        for (int i=0; i<=this.total; i++) {
            itemAtual = pega(i);
            if (!ehNumeroPrimo(itemAtual)) {
                System.out.println("Removendo "+i+"º item da lista, nao e numero primo");
                remove(i);
            }
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

    public ListaEncadeada copiarLista(ListaEncadeada listaDeOrigem) {
        ListaEncadeada listaCopiada = new ListaEncadeada();
        for(int i=0; i<=listaDeOrigem.total; i++) {
            listaCopiada.adiciona(listaDeOrigem.pega(1));
        }
        return listaCopiada;
    }

    public ListaEncadeada mesclarListas(ListaEncadeada lista1, ListaEncadeada lista2) {
        
        ListaEncadeada listaMesclada = new ListaEncadeada();
        int totalListaMesclada = lista1.total + lista2.total;

        for(int i=0; i<=lista1.total; i++) {
            Object conteudoLista1 = lista1.pega(i);
            listaMesclada.adiciona(conteudoLista1);
        }

        for(int j=lista1.total; j<=totalListaMesclada; j++) {
            Object conteudoLista2 = lista2.pega(j);
            listaMesclada.adiciona(conteudoLista2);
        }

        return listaMesclada;
    }

    public static void main(String args[]) {
        ListaEncadeada list = new ListaEncadeada();
        list.adiciona(2);
        list.adiciona(13);
        list.adiciona(4);
        list.adiciona(10);
        list.removeNumerosNaoPrimos();
    }
}
