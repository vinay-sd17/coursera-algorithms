package com.coursera.algorithms;

public class UnionTreeWeighted {

  private int[] inputs;

  private int[] sz;

  public UnionTreeWeighted(int n) {
    inputs = new int[n];
    sz = new int[n];

    for (int i = 0; i < n; i++) {
      inputs[i] = i;
      sz[i] = i;
    }
  }

  private int root(int i) {
    while (i != inputs[i]) {
      //flattened the tree with this 1 line, means all small root nodes point to parent root
      inputs[i] = inputs[inputs[i]];
      i = inputs[i];
    }
    return i;
  }

  private void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    
    if (i == j) {
      return;
    }

    if (sz[i] < sz[j]) {
      inputs[i] = j;
      sz[j] += sz[i];
    } else {
      inputs[j] = i;
      sz[i] += sz[j];
    }
  }

  private boolean isConnected(int p, int q) {
    return root(p) == root(q);
  }

  public static void main(String[] args) {
    UnionTreeWeighted obj = new UnionTreeWeighted(5);
    obj.union(1, 2);
    System.out.println("Is Connected: 1 & 2: " + obj.isConnected(1, 2));
    obj.union(1, 3);
    obj.union(2, 4);
    System.out.println("Is Connected: 1 & 4: " + obj.isConnected(1, 4));
    System.out.println("Is Connected: 0 & 4: " + obj.isConnected(0, 4));
  }
}
