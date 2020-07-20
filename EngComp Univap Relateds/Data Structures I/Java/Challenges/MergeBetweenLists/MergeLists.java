import java.util.*;

public class MergeLists {

    public boolean indexExists(ArrayList<Integer> list, int index) {
        // Retorna se o index atual é menor ou igual ao tamanho da lista, ou seja, se a posição existe
        return index <= (list.size()-1);
    }

    public static void main (String args[]) {
        // Instanciando a classe para ter acesso ao metodo indexExists 
        MergeLists mergeListsInstance = new MergeLists();

        // Lista de 9 posições
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(134);
        list1.add(55);
        list1.add(74);
        list1.add(134);
        list1.add(154);
        list1.add(24);
        list1.add(14);
        list1.add(1);

        // Lista de 6 posições
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(7);
        list2.add(4);
        list2.add(9);
        list2.add(24);
        list2.add(1);
        list2.add(54);

        // Realiza um ternário (If simplificado) para obter qual lista é a maior
        int biggestSize = (list1.size() > list2.size()) ? list1.size() : list2.size();
        System.out.println("Lista com maior quantidade: " + biggestSize);

        // A soma das duas listas deve resultar na soma do conteudo de cada posição
        ArrayList<Integer> list3 = new ArrayList<Integer>();

        for(int i=0; i<=list1.size()-1; i++) {
            if(mergeListsInstance.indexExists(list1, i) && mergeListsInstance.indexExists(list2, i)) {
                int sumList = list1.get(i) + list2.get(i);
                list3.add(sumList);
            } else if(mergeListsInstance.indexExists(list1, i)) {
                list3.add(list1.get(i));
            } else if(mergeListsInstance.indexExists(list2, i)) {
                list3.add(list2.get(i));
            }

            System.out.println("Lista 3 (Mesclagem 1 e 2) elemento da posição " + i + ":" + list3.get(i));
        }
    }
}