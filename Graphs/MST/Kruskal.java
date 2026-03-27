package Graphs.MST;
import java.util.*;

public class Kruskal {

//https://www.geeksforgeeks.org/problems/minimum-spanning-tree-kruskals-algorithm/1
     //working version of Kruskal Algorithm to Minimum Spanning Tree using a Disjoint Set Data Structure
    static int kruskalMST(int vertices, int[][] edges) {

        int[] parent = new int[vertices+1];
        int[] size = new int[vertices+1];

        for(int i = 0 ; i <= vertices ; i++){
            parent[i] = i ;
            size[i] = 1;
        }

        Arrays.sort(edges , (a,b) -> a[2] - b[2] );

        int wt = 0 ;
        for(int [] edge : edges){
            if(findUltimateParent(edge[0],parent,size) != findUltimateParent(edge[1],parent,size) ){
                wt += edge[2];
                unionBySize(edge[0],edge[1],parent,size);
            }
        }

        return wt;
    }

    static public int findUltimateParent(int node, int[] parent , int[] size){
        if(node == parent[node]){
            return node;
        }
        int ultimateParent = findUltimateParent(parent[node],parent,size);
        parent[node] = ultimateParent;
        return ultimateParent;
    }
    static public void unionBySize(int u , int v , int[] parent , int[] size){
        int ultimateU = findUltimateParent(u,parent,size);
        int ultimateV= findUltimateParent(v,parent,size);

        if(ultimateU == ultimateV)return;

        if(size[ultimateU] < size[ultimateV]){
            parent[ultimateU] = ultimateV;
            size[ultimateV] += size[ultimateU];
        }else{
            parent[ultimateV] = ultimateU;
            size[ultimateU] += size[ultimateV];
        }
    }
}
