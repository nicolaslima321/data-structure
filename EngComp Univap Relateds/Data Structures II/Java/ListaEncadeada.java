class ListaEncadeada {
    
    public int total;
    public Node primeiro;
    public Node ultimo;


    public boolean posicaoExistenteEstaOcupada(int posicao) {
        if (this.posicaoOcupada(posicao)) {
            Object currentNode = getPosicao(posicao);
            return (currentNode.getElement != null);
        } else {
            throw new Exception("Posicao nao existente");
        }
    }

    public boolean posicaoOcupada(int posicao) {
        return ((posicao >= 0) && (posicao < this.total));
    }

    public Object pega(int posicao) {
        if (posicao > this.total || posicao < 0) {
            throw new Exception("Posicao invalida ou inexistente");
        }

        Node node = this.primeiro;
        int posicaoAtual = 0;

        while ((node != null) && (posicaoAtual < posicao)) {
            node = node.getNext();
            posicaoAtual++;
        }

        return node.getElement();
    }

    public Node pegaCelula(int posicao) {
        if (posicao > this.total || posicao < 0) {
            throw new Exception("Posicao invalida ou inexistente");
        }

        Node node = this.primeiro;
        int posicaoAtual = 0;

        while ((node != null) && (posicaoAtual+1 < posicao)) {
            node = node.getNext();
            posicaoAtual++;
        }

        return node;
    }    

    public void removeDoComeco() {
        if (this.total == 0) {
            return;
        }
    }
    
}