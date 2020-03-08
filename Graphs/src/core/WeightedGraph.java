package core;

import java.util.*;

public class WeightedGraph {

    class Vertex{
        int index;
        String name;

        public Vertex(int index, String name){
            this.index = index;
            this.name = name;
        }
    }

    class Edge{
        int from;
        int to;

        public Edge(int from, int to){
            this.from = from;
            this.to = to;
        }
    }

    /////////////////
    public final long MAX = Long.MAX_VALUE;
    public final long MIN = Long.MIN_VALUE;

    public int vertices = 0;
    public int edges = 0;

    public ArrayList<Vertex> Vertices = new ArrayList<Vertex>();
    public ArrayList<Long> Edges = new ArrayList<Long>();
    public ArrayList<Vertex> Centers = new ArrayList<Vertex>();

    public long radius = MAX;
    public long diameter = MIN;

    public WeightedGraph(){
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
