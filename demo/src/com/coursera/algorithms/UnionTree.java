package com.coursera.algorithms;

public class UnionTree {

  private int[] inputs;

  public UnionTree(int n) {
    inputs = new int[n];

    for (int i = 0; i < n; i++) {
      inputs[i] = i;
    }
  }

  private int root(int i) {
    while (i != inputs[i]) {
      i = inputs[i];
    }
    return i;
  }

  private void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    inputs[i] = j;
  }

  private boolean isConnected(int p, int q) {
    return root(p) == root(q);
  }

  public static void main(String[] args) {
    UnionTree obj = new UnionTree(5);
    obj.union(1,2);
    System.out.println("Is Connected: 1 & 2: " + obj.isConnected(1, 2));
    obj.union(1,3);
    obj.union(2,4);
    System.out.println("Is Connected: 1 & 4: " + obj.isConnected(1, 4));
    System.out.println("Is Connected: 0 & 4: " + obj.isConnected(0, 4));
  }

}
