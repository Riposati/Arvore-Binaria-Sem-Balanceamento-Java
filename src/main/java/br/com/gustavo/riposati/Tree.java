package br.com.gustavo.riposati;

import lombok.Data;

@Data
public class Tree {
    private Node root;
    public static int flag = 0;
    public static int biggest = 0;

    public Node insertNode(int key, Node root) {

        if (root == null) {
            root = new Node(key);
        } else {

            if (root.getKey() < key) {
                root.setRight(insertNode(key, root.getRight()));
            } else if (root.getKey() > key)
                root.setLeft(insertNode(key, root.getLeft()));
        }
        return root;
    }

    public void inOrder(Node root) {
        if (root != null) {
            if (root.getKey() == biggest) {
                inOrder(root.getLeft());
                System.out.print(root.getKey());
                inOrder(root.getRight());

            } else {
                inOrder(root.getLeft());
                System.out.print(root.getKey() + " ");
                inOrder(root.getRight());
            }
        }
    }

    public static void preOrder(Node root) {
        if (root != null) {
            if (flag == 0) {
                System.out.print(root.getKey());
                flag = 1;
            } else {
                System.out.print(" " + root.getKey());
            }
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void postOrder(Node root, Node keepRoot) {

        if (root != null) {
            if (root.getKey() == keepRoot.getKey()) {
                postOrder(root.getLeft(), keepRoot);
                postOrder(root.getRight(), keepRoot);
                System.out.print(root.getKey());
            } else {
                postOrder(root.getLeft(), keepRoot);
                postOrder(root.getRight(), keepRoot);
                System.out.print(root.getKey() + " ");
            }
        }
    }

    public boolean searchNode(int key, Node root) {
        Node node = root;

        while (node != null && node.getKey() != key) {

            if (node.getKey() > key)
                node = node.getLeft();
            else
                node = node.getRight();
        }

        if (node != null) {
            System.out.println(key + " existe");
            return true;
        } else {
            System.out.println(key + " nao existe");
            return false;
        }
    }

    public Node removeNode(int key, Node root) {

        if (root == null) {
            return null;
        }

        if (root.getKey() < key) {
            root.setRight(removeNode(key, root.getRight()));
        } else if (root.getKey() > key)
            root.setLeft(removeNode(key, root.getLeft()));

        else {

            if (root.getLeft() == null && root.getRight() == null)

                root = null;

            else if (root.getLeft() == null)

                root = root.getRight();

            else if (root.getRight() == null)

                root = root.getLeft();

            else {

                Node rootAux = root.getLeft();

                while (rootAux.getRight() != null) {
                    rootAux = rootAux.getRight();
                }
                int rootOldKey = root.getKey();
                root.setKey(rootAux.getKey());
                rootAux.setKey(rootOldKey);
                root.setLeft(removeNode(rootOldKey, root.getLeft()));
            }
        }

        return root;
    }

    public int treeMaximum(Node root) {

        while (root.getRight() != null) {

            root = root.getRight();
        }
        return root.getKey();
    }
}
