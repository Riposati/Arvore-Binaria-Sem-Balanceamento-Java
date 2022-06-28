package br.com.gustavo.riposati;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Tree tree = new Tree();
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        String keys= "";

        while ((keys = in.readLine()) != null && keys.length() != 0) {

            String[] keyAux = keys.split(" ");

            if (keyAux.length == 1) {

                switch(keyAux[0]){

                    case "INFIXA":
                        Tree.biggest = tree.treeMaximum(tree.getRoot());
                        tree.inOrder(tree.getRoot());
                        System.out.print("\n");
                        break;

                    case "PREFIXA":
                        Tree.preOrder(tree.getRoot());
                        Tree.flag = 0;
                        System.out.print("\n");
                        break;

                    case "POSFIXA":
                        tree.postOrder(tree.getRoot(), tree.getRoot());
                        System.out.print("\n");
                        break;

                    default:
                        break;
                }

            } else {

                if (keyAux[0].equals("I")) {
                    tree.setRoot(tree.insertNode(Integer.parseInt(keyAux[1]), tree.getRoot()));
                } else if (keyAux[0].equals("P")) {
                    tree.searchNode(Integer.parseInt(keyAux[1]), tree.getRoot());
                } else if (keyAux[0].equals("R")) {
                    tree.setRoot(tree.removeNode(Integer.parseInt(keyAux[1]), tree.getRoot()));
                }
            }
        }
    }
}