class ListaEncadeada {
    
    public int total;
    public Node primeiro;
    public Node ultimo;

    public boolean posicaoOcupada(int posicao) {
        return ((posicao >= 0) && (posicao < this.total));
    }

    public Object pega(int posicao) {
        if (posicao > this.total || posicao < 0) {
            System.out.println("Posicao invalida ou inexistente");
            return null;
        }

        Node node = this.primeiro;
        int posicaoAtual = 0;

        for(int i=0; i<posicao; i++) {
            node = node.getNext();
            posicaoAtual++;
        }

        return node.getItem();
    }

    public Node pegaCelula(int posicao) {
        if (posicao > this.total || posicao < 0) {
            System.out.println("Posicao invalida ou inexistente");
            return null;
        }

        Node node = this.primeiro;
        int posicaoAtual = 0;

        for(int i=0; i<posicao+1; i++) {
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

    public void removePosicao(int posicao) {
        if (posicaoOcupada(posicao){
            System.out.println("Posicao invalida ou nao existente");
            return;
        }
        if (posicao == 1) {
            this.removeComeco();
            return;
        }
        if (posicao == this.total) {
            this.removeFim();
            return;
        }
        Node previous = pega(posicao-1);
        Node noRemovido = pega(posicao);
        previous.setNext(noRemovido.getNext());
        this.total--;
    }

    public void removeFim() {
        if (posicaoOcupada(this.total-1){
            System.out.println("Posicao invalida ou nao existente");
            return;
        }
        if (this.total == 1)
            this.removeComeco();
        else {
            Node penultima = this.ultimo.getPrevious();
            this.ultimo = penultimo;
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

    public boolean ehImparMaior30(Object numero) {
        int numeroInt = new Integer(numero.toString());
        
        return ((numeroInt % 2) != 0) && (numeroInt > 30);
    }
    
    public void adicionaPosicao(int posicao, Object item) {
        if (posicao == 0) {
            adicionaNoComeco(item);
            return;
        }
        if (posicao == this.total)
            adicionaNoFinal(item);
        else {
            Node previous = pega(posicao-1);
            Node node = new Node(item, previous.getNext());
            previous.setNext(node);
            this.total++;
        }
    }

    public Object busca(Object itemDesejado) {
        Object itemAtual = null;

        for (int i=0; i<this.total; i++) {
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
        for(int i=0; i<listaDeOrigem.total; i++) {
            listaCopiada.adiciona(listaDeOrigem.pega(1));
        }
        return listaCopiada;
    }

    public ListaEncadeada mesclarListas(ListaEncadeada lista1, ListaEncadeada lista2) {
        
        ListaEncadeada listaMesclada = new ListaEncadeada();
        int totalListaMesclada = lista1.total + lista2.total;

        for(int i=0; i<lista1.total; i++) {
            Object conteudoLista1 = lista1.pega(i);
            listaMesclada.adiciona(conteudoLista1);
        }

        for(int j=lista1.total; j<totalListaMesclada; j++) {
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
        list.adiciona(10);
        list.removeNumerosNaoPrimos();
    }
}
