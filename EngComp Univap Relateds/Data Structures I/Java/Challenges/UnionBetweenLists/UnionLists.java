import java.util.*;

public class UnionLists {

    public static void main (String args[]) {
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

        // Somando a quantidade de posições das duas listas
        int totalSize = (list1.size() + list2.size());

        // A soma das duas listas deve resultar em uma lista de 15 posições
        ArrayList<Integer> list3 = new ArrayList<Integer>();

        for(int i=0; i<=list1.size()-1; i++) {
            list3.add(list1.get(i));
        }

        for(int j=0; j<=list2.size()-1; j++) {
            list3.add(list2.get(j));
        }

        for(int k=0; k<=totalSize-1; k++) {
            System.out.println("Lista 3 (Uniao 1 e 2) elemento da posição " + k + ":" + list3.get(k));
        }
    }
}