package core;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;

public class WeightedGraph {

    public static boolean EdgeExists(String from, String to){
        return Edges.stream().filter(o -> o.getFrom().equals(from) && o.getTo().equals(to)).findFirst().isPresent();
    }

    public static boolean VerticesContainsName(String name){
        return Vertices.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent();
    }

    public static int getVertexIndex(String str){
        for(int i = 0; i < Vertices.size(); i++){
            if(Vertices.get(i).name.equals(str)){
                return Vertices.get(i).index;
            }
        }

        return 0;
    }

    static class Vertex{
        int index;
        String name;

        public Vertex(int index, String name){
            this.index = index;
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
        public int getIndex(){
            return this.index;
        }
    }

    static class Edge{
        String from;
        String to;
        long weight;

        public Edge(String from, String to, long weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public String getFrom() {
            return this.from;
        }
        public String getTo() { return this.to; }
        public long getWeight(){ return this.weight; }
    }

    /////////////////
    public static long MAX = Long.MAX_VALUE;
    public static long MIN = Long.MIN_VALUE;

    public static int vertices;
    public static int edges;

    public static ArrayList<Vertex> Vertices = new ArrayList<Vertex>();
    public static ArrayList<Edge> Edges = new ArrayList<Edge>();
    public static ArrayList<Vertex> Centers = new ArrayList<Vertex>();

    public static long radius = MAX;
    public static long diameter = MIN;

    public WeightedGraph(){
        this.vertices = 0;
        this.edges = 0;
    }
    /////////////////

    public static void drive(){
        long distance[][] = new long[vertices+1][vertices+1];
        long eccentricity[] = new long[vertices+1];

        String stringDistance[][] = new String[vertices+1][vertices+1];
        String stringGraphCenters[][] = new String[vertices+1][vertices+1];

        calculateMinimalDistances(distance, eccentricity);
        findGraphCenters(distance, eccentricity);
        printCentersToConsole(distance, eccentricity);

        convertDistancesTable(distance, stringDistance);
        Main.printDistancesTable(stringDistance);

        convertGraphCentersTable(eccentricity, Centers, stringGraphCenters);
        Main.printGraphCentersTable(stringGraphCenters);
    }

    public static void calculateMinimalDistances(long distance[][], long eccentricity[]){
        final int V = vertices;
        final int E = edges;

        for(int i = 1; i <= V; i++){
            eccentricity[i] = MIN/2;

            for(int j = 1; j <= V; j++)
                distance[i][j] = MAX/2;

            distance[i][i] = 0;
        }

        for(int i = 0; i < Edges.size(); i++){
            int indexFrom = getVertexIndex(Edges.get(i).from);
            int indexTo = getVertexIndex(Edges.get(i).to);

            distance[indexFrom][indexTo] = Edges.get(i).weight;
            distance[indexTo][indexFrom] = Edges.get(i).weight;
        }

        for(int i = 1; i <= V; i++)
            for(int j = 1; j <= V; j++)
                for(int k = 1; k <= V; k++){
                    distance[k][j] = Math.min(distance[k][j], distance[k][i] + distance[i][j]);
                }
    }

    public static void findGraphCenters(long distance[][], long eccentricity[]){
        for(int i = 1; i <= vertices; i++){
            for(int j = 1; j <= vertices; j++){
                eccentricity[i] = Math.max(eccentricity[i], distance[i][j]);
            }
        }

        for(int i = 1; i <= vertices; i++){
            radius = Math.min(radius, eccentricity[i]);
            diameter = Math.max(diameter, eccentricity[i]);
        }

        for(int i = 0; i < Vertices.size(); i++){
            if(eccentricity[i + 1] == radius){
                Vertex vertex = new Vertex(i + 1, Vertices.get(i).name);
                Centers.add(vertex);
            }
        }
    }

    public static void printCentersToConsole(long distance[][], long eccentricity[]){
        System.out.println("Minimal distances between all pairs of vertices:");
        for(int i = 1; i <= vertices; i++){
            for(int j = 1; j <= vertices; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Radius: " + radius);
        System.out.println("Diameter: " + diameter);

        System.out.println("All-vertex eccentricity:");
        for(int i = 0; i < Vertices.size(); i++){
            System.out.println(Vertices.get(i).name + " " + Vertices.get(i).index + " " + eccentricity[i + 1]);
        }

        System.out.println("Centers:");
        for(int i = 0; i < Centers.size(); i++){
            System.out.println(Centers.get(i).name + " " + Centers.get(i).index + " | eccentricity = " + eccentricity[Centers.get(i).index]);
        }

        System.out.println("Edges:");
        for(int i = 0; i < Edges.size(); i++){
            System.out.println("from " + Edges.get(i).from + " to " + Edges.get(i).to + " -> " + Edges.get(i).weight);
        }
    }

    public static void convertDistancesTable(long[][] distance, String[][] stringDistance){
        stringDistance[0][0] = "Node-to-Node";
        for(int i = 1; i <= vertices; i++){
            stringDistance[0][i] = Vertices.get(i - 1).name;
            stringDistance[i][0] = Vertices.get(i - 1).name;

            for(int j = 1; j <= vertices; j++){
                stringDistance[i][j] = Long.toString(distance[i][j]);
            }
        }
    }

    public static void convertGraphCentersTable(long[] eccentricity, ArrayList<Vertex> Centers, String[][] stringGraphCenters){
        stringGraphCenters[0][0] = "№";
        stringGraphCenters[0][1] = "Node";
        stringGraphCenters[0][2] = "Eccentricity";

        for(int i = 0; i < Centers.size(); i++){
            stringGraphCenters[i+1][0] = Long.toString(i+1);

            stringGraphCenters[i+1][1] = Centers.get(i).name;
            stringGraphCenters[i+1][2] = Long.toString(eccentricity[i+1]);
        }
    }
}
