/* ****************************************************************************************
 * Faculdade de Engenharias Arquitetura e Urbanismo (FEAU) (Univap)
 * Curso: Engenharia da Computação - Data de Entrega: 28/09/2020
 * Autor: Nicolas Pedroso Lima
 *
 * Turma: 8UNA Disciplina: Algoritmos Estrutura de Dados - II
 * Avaliação parcial referente ao 1 - Bimestre
 * Observação: "Main" está direto na classe ListaEncadeada
 *
 * ListaEncadeada.java
 * ***************************************************************************************/

import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

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

    public void remove(int posicao) {
        if (posicao > this.total || posicao < 0) {
            System.out.println("Posicao invalida ou inexistente");
            return;
        }

        if (posicao == 1) {
            removeDoComeco();
        } else {
            Node node = this.primeiro;
            int count = 0;

            for (int i=0; i<posicao; i++) {
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
            this.ultimo = node;
        } else {
            Node newNode = new Node(item);
            Node node = this.ultimo;
            node.setNext(newNode);
            this.ultimo = newNode;
        }
        
        this.total++;
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

    public double media(CandidatoEntrada notasCandidato) {
        double n1 = notasCandidato.getNota1();
        double n2 = notasCandidato.getNota2();
        double n3 = notasCandidato.getNota3();

        return (n1 + n2 + n3) / 3;
    }

    public double mediana(CandidatoEntrada notasCandidato) {
        double mediana;

        double[] notas = new double[3];

        notas[0] = notasCandidato.getNota1();
        notas[1] = notasCandidato.getNota2();
        notas[2] = notasCandidato.getNota3();

        Arrays.sort(notas);
        mediana = notas[1];

        return mediana;
    }

    public double variancia(CandidatoEntrada notasCandidato) {
        double media = media(notasCandidato);
        double n1 = notasCandidato.getNota1();
        double n2 = notasCandidato.getNota2();
        double n3 = notasCandidato.getNota3();

        double variancia = ((Math.pow((n1 - media), 2)/3) + (Math.pow((n2 - media), 2)/3) + (Math.pow((n3 - media), 2)/3));

        return variancia;
    }

    public double desvioPadrao(CandidatoSaida resultadoCandidato) {
        return Math.sqrt(resultadoCandidato.getVariancia());
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o numero de participantes:");
        int numeroDeParticipantes = Integer.parseInt(scanner.nextLine());
        
        ListaEncadeada listCandidatos = new ListaEncadeada();
        ListaEncadeada listResultados = new ListaEncadeada();
        
        for(int i=0; i<numeroDeParticipantes; i++) {

            //Lógica Entrada
            CandidatoEntrada candidato = new CandidatoEntrada();
            
            System.out.println("Insira seu nome: ");
            String nome = scanner.nextLine();
            candidato.setNome(nome);
            
            System.out.println("Insira a 1º nota: ");
            double nota1 = Double.parseDouble(scanner.nextLine());
            candidato.setNota1(nota1);
            
            System.out.println("Insira a 2º nota: ");
            double nota2 = Double.parseDouble(scanner.nextLine());
            candidato.setNota2(nota2);

            System.out.println("Insira a 3º nota: ");
            double nota3 = Double.parseDouble(scanner.nextLine());
            candidato.setNota3(nota3);

            System.out.println("Adicionando candidato " + nome + " na lista de candidatos");
            listCandidatos.adiciona(candidato);

            // Lógica Resultados
            CandidatoSaida resultado = new CandidatoSaida();
            
            resultado.setNome(candidato.getNome());

            double mediana = listCandidatos.mediana(candidato);
            resultado.setMediana(mediana);

            double media = listCandidatos.media(candidato);
            resultado.setMedia(media);

            double variancia = listCandidatos.variancia(candidato);
            resultado.setVariancia(variancia);

            double desvioPadrao = listCandidatos.desvioPadrao(resultado);
            resultado.setDesvpadrao(desvioPadrao);

            System.out.println("Adicionando resultado " + nome + " na lista de resultados");
            listResultados.adiciona(resultado);
        }

        String candidatoMenorVariancia = "";

        // Valor = 1000 pois precisava-se de um valor máximo para que a primeira interação da condição fosse atendida
        // Para que assim, as próximas possam atender a condição e descobrir o contedor da menor variância
        double menorVariancia = 1000;

        for(int i=0; i<numeroDeParticipantes; i++) {
            CandidatoSaida candidato = (CandidatoSaida) listResultados.pega(i);
            
            if (candidato.getVariancia() < menorVariancia) {
                menorVariancia = candidato.getVariancia();
                candidatoMenorVariancia = candidato.getNome();
            }

            System.out.println(candidato.toString());
        }

        System.out.println(candidatoMenorVariancia + " e candidato(a) contratado(a), por apresentar maior regularidade. Variancia = " + menorVariancia);

    }
}
