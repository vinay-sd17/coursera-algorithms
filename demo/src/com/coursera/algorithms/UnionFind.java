package com.coursera.algorithms;

//Week 1 - Union Find Example
public class UnionFind {

  private int[] inputs;

  public UnionFind(int n) {
    inputs = new int[n];

    for (int i = 0; i < n; i++) {
      inputs[i] = i;
    }
  }

  private void union(int p, int q) {
    int pid = inputs[p];
    int qid = inputs[q];
    for (int i = 0; i < inputs.length; i++) {
      if (inputs[i] == pid) {
        inputs[i] = qid;
      }
    }
  }

  private boolean isConnected(int p, int q) {
    return inputs[p] == inputs[q];
  }

  public static void main(String[] args) {
    UnionFind obj = new UnionFind(5);
    obj.union(1,2);
    System.out.println("Is Connected: 1 & 2: " + obj.isConnected(1, 2));
    obj.union(1,3);
    obj.union(2,4);
    System.out.println("Is Connected: 1 & 4: " + obj.isConnected(1, 4));
    System.out.println("Is Connected: 0 & 4: " + obj.isConnected(0, 4));
  }

}
