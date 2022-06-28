package br.com.gustavo.riposati;

import lombok.Data;

@Data
public class Node {
    private int key;
    private Node left;
    private Node right;

    public Node(int key){
        this.key = key;
    }
}
