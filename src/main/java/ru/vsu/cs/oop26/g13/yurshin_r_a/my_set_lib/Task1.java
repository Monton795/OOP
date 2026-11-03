cd D:\untitled1\OOP-upload
package ru.vsu.cs.oop26.g13.yurshin_r_a.my_set_lib;

public class Task1 {

    static class Node {
        int value;
        Node next, prev;

        Node(int value) {
            this.value = value;
        }
    }
    static class DoublyList {
        Node head, tail;

        void add(int value) {

        }

        void remove(int value) {

        }

        void print() {

        }
    }
    static class CircularList {
        Node tail;

        void add(int value) {

        }

        void remove(int value) {

        }

        void print() {

        }
    }

    public static void main(String[] args) {
        DoublyList a = new DoublyList();
        CircularList b = new CircularList();

        for (int i : new int[]{10, 20, 30}) {
            a.add(i);
            b.add(i);
        }

        System.out.println("Двусвязный список:");
        a.print();

        System.out.println("Циклический список:");
        b.print();

        a.remove(20);
        b.remove(20);

        a.add(40);
        b.add(40);

        System.out.println("После удаления 20 и добавления 40:");
        a.print();
        b.print();
    }
}