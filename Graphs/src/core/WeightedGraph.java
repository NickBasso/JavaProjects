package core;

import java.util.*;

public class WeightedGraph {

    public static boolean VerticesContainsName(String name){
        return Vertices.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent();
    }

    public static long getVertexIndex(String name){
        for(int i = 0; i < Vertices.size(); i++){
            if(Vertices.get(i).name.equals(name)){
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

        public long getIndex(){
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
    }

    /////////////////
    public final long MAX = Long.MAX_VALUE;
    public final long MIN = Long.MIN_VALUE;

    public int vertices;
    public int edges;

    public static ArrayList<Vertex> Vertices = new ArrayList<Vertex>();
    public ArrayList<Edge> Edges = new ArrayList<Edge>();
    public ArrayList<Vertex> Centers = new ArrayList<Vertex>();

    public long radius = MAX;
    public long diameter = MIN;

    long distance[][] = new long[vertices+1][vertices+1];
    long eccentricity[] = new long[vertices+1];

    public WeightedGraph(){
        this.vertices = 0;
        this.edges = 0;
    }
    /////////////////

    public void drive(int vertices, int edges){
        calculateMinimalDistances();
        findGraphCenters();
    }

    public void calculateMinimalDistances(){
        final int V = vertices;
        final int E = edges;

        for(int i = 0; i <= V; i++){
            eccentricity[i] = MIN;

            for(int j = 0; j <= V; j++)
                distance[i][j] = MAX;
        }

        for(int i = 0; i < Edges.size(); i++){
            distance[(int) getVertexIndex(Edges.get(i).from)][(int) getVertexIndex(Edges.get(i).to)] = Edges.get(i).weight;
        }

        for(int i = 0; i < V; i++)
            for(int j = 0; j < V; j++)
                for(int k = 0; k < V; k++){
                    distance[k][j] = Math.min(distance[k][j], distance[k][i] + distance[i][j]);
                }
    }

    public void findGraphCenters(){
        for(int i = 0; i < vertices; i++){
            for(int j = 0; j < vertices; j++){
                eccentricity[i] = Math.max(eccentricity[i], distance[i][j]);
            }
        }

        for(int i = 0; i < vertices; i++){
            radius = Math.min(radius, eccentricity[i]);
            diameter = Math.max(diameter, eccentricity[i]);
        }

        for(int i = 0; i < vertices; i++){
            if(eccentricity[i] == radius){
                Vertex vertex = new Vertex(i, Vertices.get(i).name);
                Centers.add(vertex);
            }
        }
    }
}
