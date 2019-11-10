package pt.ulusofona.lp2.fandeisiaGame;

public class Ordenacao {
    static private int partition(Creature[] creatures, int left, int right) {
        // vamos escolher o pivot como sendo o elemento mais à direita
        Creature pivot = creatures[right];
        int leftIdx = left;
        int rightIdx = right - 1; // exclude the pivot
        while (leftIdx <= rightIdx) {
            // se o left fôr maior que o pivot e o right fôr maior que o pivot, então troca
            if (creatures[leftIdx].getId() > pivot.getId() && creatures[rightIdx].getId() < pivot.getId()) {
                Creature temp = creatures[leftIdx];
                creatures[leftIdx] = creatures[rightIdx];
                creatures[rightIdx] = temp;
            }
            // se o left fôr menor que o pivot, avança
            if (creatures[leftIdx].getId() <= pivot.getId()) {
                leftIdx++;
            }
            // se o right fôr maior que o pivot, recua
            if (creatures[rightIdx].getId() >= pivot.getId()) {
                rightIdx--;
            }
        }
        // troca pivot com left
        creatures[right] = creatures[leftIdx];
        creatures[leftIdx] = pivot;
        return leftIdx;
    }

    static private Creature[] ordenar(Creature[] creatures, int left, int right) {
        if (left < right) {
            int posicaoPivot = partition(creatures, left, right - 1);

            creatures = ordenar(creatures, left, posicaoPivot);
            creatures = ordenar(creatures, posicaoPivot + 1, right);
        }
        return creatures;
    }

    static public Creature[] ordenarCreatureById(Creature[] creatures) {
        return ordenar(creatures, 0, creatures.length);
    }
}
