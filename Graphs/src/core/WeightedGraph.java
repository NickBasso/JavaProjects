package core;

import java.util.*;

public class WeightedGraph {

    static class Vertex{
        int index;
        String name;

        public Vertex(int index, String name){
            this.index = index;
            this.name = name;
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

    public ArrayList<Vertex> Vertices = new ArrayList<Vertex>();
    public ArrayList<Edge> Edges = new ArrayList<Edge>();
    public ArrayList<Vertex> Centers = new ArrayList<Vertex>();

    public long radius = MAX;
    public long diameter = MIN;

    public WeightedGraph(){
        this.vertices = 0;
        this.edges = 0;
    }

    public void drive(int vertices, int edges){
        final int V = vertices;
        final int E = edges;

        long distance[][] = new long[V+1][V+1];
        long eccentricity[] = new long[V+1];

        for(int i = 0; i <= V; i++){
            eccentricity[i] = MIN;

            for(int j = 0; j <= V; j++)
                distance[i][j] = MAX;
        }

        for(int i = 0; i < V; i++)
            for(int j = 0; j < V; j++)
                for(int k = 0; k < V; k++){
                    distance[k][j] = Math.min(distance[k][j], distance[k][i] + distance[i][j]);
                }

        for(int i = 0; i < V; i++)
            for(int j = 0; j < V; j++){
                eccentricity[i] = Math.max(eccentricity[i], distance[i][j]);
            }

        for(int i = 0; i < V; i++){
            radius = Math.min(radius, eccentricity[i]);
            diameter = Math.max(diameter, eccentricity[i]);
        }

        for(int i = 0; i < V; i++){
            if(eccentricity[i] == radius){
                Vertex vertex = new Vertex(i, Vertices.get(i).name);
                Centers.add(vertex);
            }
        }

    }
}
