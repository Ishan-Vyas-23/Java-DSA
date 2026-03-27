package Graphs.DisjointSet;
import OOPsLab.Lab_04.A;

import java.util.*;

public class DSU {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DSU(int n){
        for (int i = 0 ; i <= n ; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUltimateParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node,ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(int u , int v ){
        int ultimateU = findUltimateParent(u);
        int ultimateV= findUltimateParent(v);

        if(ultimateU == ultimateV)return;

        if(rank.get(ultimateU) < rank.get(ultimateV)){
            parent.set(ultimateU,ultimateV);
        }else if(rank.get(ultimateV) < rank.get(ultimateU)){
            parent.set(ultimateV,ultimateU);
        }else{
            parent.set(ultimateV,ultimateU);
            rank.set(ultimateU,rank.get(ultimateU)+1);
        }
    }

    public void unionBySize(int u , int v ){
        int ultimateU = findUltimateParent(u);
        int ultimateV= findUltimateParent(v);

        if(ultimateU == ultimateV)return;

        if(size.get(ultimateU) < size.get(ultimateV)){
            parent.set(ultimateU,ultimateV);
            size.set(ultimateV,size.get(ultimateU)+size.get(ultimateV));
        }else{
            parent.set(ultimateV,ultimateU);
            size.set(ultimateU,size.get(ultimateU)+size.get(ultimateV));
        }
    }

    public boolean isConnected(int x  ,int y){
        return findUltimateParent(x) == findUltimateParent(y);
    }

    public static void main(String[] args) {
        DSU disjoint = new DSU(7);
        disjoint.unionBySize(1,2);
        disjoint.unionBySize(2,3);
        disjoint.unionBySize(4,5);
        disjoint.unionBySize(6,7);
        disjoint.unionBySize(5,6);

        System.out.println(disjoint.isConnected(3,7));

        disjoint.unionBySize(3,7);

        System.out.println(disjoint.isConnected(3,7));
    }
}

