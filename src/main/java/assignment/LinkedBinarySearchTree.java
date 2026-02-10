package assignment;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * LinkedBinarySearchTree for tree traversal lab
 *
 * @param <E>
 * @author Lachlan Plant
 */
public class LinkedBinarySearchTree<E extends Comparable<? super E>> implements Iterable<E> {

    private class Node<T> {
        T elem;
        Node<T> parent;
        Node<T> left;
        Node<T> right;

        public Node(T e, Node<T> p, Node<T> l, Node<T> r) {
            elem = e;
            parent = p;
            left = l;
            right = r;
        }
    }

    private Node<E> root;

    /** for storing nodes in traversing order in the tasks*/
    private ArrayList<E> orderedList;

    public ArrayList<E> getOrderedList() {
        return orderedList;
    }

    /**
     *
     */
    public LinkedBinarySearchTree() {
        root = null;
        orderedList = new ArrayList<>();
    }

    /**
     * Adds elem into BST
     *
     * @param elem The element to add
     */
    public void add(E elem) {
        if (root == null) {
            root = new Node<>(elem, null, null, null);
        } else {
            root = insert(elem, root, null);
        }
    }

    /**
     * Recursive BST insertion
     *
     * @param elem The element to add
     * @param curr The current element
     * @param from The element to add from
     * @return The inserted element
     */
    private Node<E> insert(E elem, Node<E> curr, Node<E> from) {
        if (curr == null) {
            curr = new Node<>(elem, from, null, null);
            return curr;
        }
        if (elem.compareTo(curr.elem) < 0) {
            curr.left = insert(elem, curr.left, curr);
        }
        if (elem.compareTo(curr.elem) > 0) {
            curr.right = insert(elem, curr.right, curr);
        }
        return curr;
    }


    /*****************************************************************
     *
     * Recursive Printing Functions
     *
     *
     *****************************************************************/

    /**
     * Caller method for preorder recursive traversing
     */
    public void startPreorderRecursive() {
        orderedList.clear();
         preorderRecursive(root);
    }

    /**
     * preorder tree traversal, prints(curr.elem + ", ")
     *
     * @param curr The current element
     */
    private void preorderRecursive(Node<E> curr) {
        if (curr == null) {
            return;
        }
        orderedList.add(curr.elem);
        preorderRecursive(curr.left);
        preorderRecursive(curr.right);
    }


    /**
     * Caller method for inorder recursive traversing
     */
    public void startInorderRecursive() {
        orderedList.clear();
        inorderRecursive(root);

    }

    /**
     * inorder tree traversal, prints(curr.elem + ", ")
     *
     * @param curr The current element
     */
    private void inorderRecursive(Node<E> curr) {
        if (curr == null) {
            return;
        }
        inorderRecursive(curr.left);
        orderedList.add(curr.elem);
        inorderRecursive(curr.right);
    }

    /**
     * Caller method for postorder recursive traversing
     */
    public void startPostorderRecursive() {
        orderedList.clear();
        postorderRecursive(root);
    }

    /**
     * postorder tree traversal, prints(curr.elem + ", ")
     *
     * @param curr The current element
     */
    private void postorderRecursive(Node<E> curr) {
        if (curr == null) {
            return;
        }
        postorderRecursive(curr.left);
        postorderRecursive(curr.right);
        orderedList.add(curr.elem);
    }


    /*****************************************************************
     * Iterator Functions
     *****************************************************************/


    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    public Iterator<E> inorderIterator() {
        return new InorderIterator();
    }

    public Iterator<E> preorderIterator() {
        return new PreorderIterator();
    }


    /*****************************************************************
     *
     * Iterators 
     *
     *
     *****************************************************************/


    /**
     * Tree Iterator using preorder traversal for ordering
     */
    private class PreorderIterator implements Iterator<E> {
        Node<E> next;

        public PreorderIterator() {
            next = root;
        }

        public boolean hasNext() {
            // Your code Extra task 1
            return false;
        }

        public E next() {
            // Your code Extra task 1
            E current = root.elem;
            return current;
        }

        public void remove() {
            // not implemented
        }
    }

    /**
     * Tree Iterator using inorder traversal for ordering
     */
    private class InorderIterator implements Iterator<E> {

        Node<E> next;

        public InorderIterator() {
            next = root;
            if (next != null) {
                while(next.left != null) {
                    next = next.left;
                }
            }
        }

        public boolean hasNext() {
            // Your code Extra task 2
            return false;
        }

        public E next() {
            // Your code Extra task 2
            E current = root.elem;
            return current;
        }

        public void remove() {
            // not implemented
        }
    }
}
