package base;

import Algorithms.Graphs.KruskalMST;
import Algorithms.Graphs.PrimMST_AdjacencyList_BinaryHeap;
import Algorithms.Graphs.PrimMST_AdjacencyMatrix;

public class Main{

    public static boolean isPositiveNumeric(String a){
        return a.matches("\\d+");
    }

    public static void main(String[] args) throws Exception {
        /*KruskalMST Kruskal = new KruskalMST();
        Kruskal.drive();

        System.out.println();
        System.out.println();

        PrimMST_AdjacencyMatrix PrimMatrix = new PrimMST_AdjacencyMatrix();
        PrimMatrix.drive();

        System.out.println();
        System.out.println();

        PrimMST_AdjacencyList_BinaryHeap PrimListBinaryHeap = new PrimMST_AdjacencyList_BinaryHeap();
        PrimListBinaryHeap.drive();

        System.out.println();
        System.out.println();*/

        String a="aaa";
        System.out.println(isPositiveNumeric((a)));
    }
}
