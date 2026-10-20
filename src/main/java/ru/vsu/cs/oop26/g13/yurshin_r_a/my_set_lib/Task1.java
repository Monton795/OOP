package ru.vsu.cs.oop26.g13.yurshin_r_a.my_set_lib;


public class Task1 {

    static class Node {
        int value;
        Node next, prev;

        Node(int value) {
            this.value = value;
        }
    }

    static class DoublyList { // двусвяз список
        Node head, tail;

        void add(int value) { // добавление элемента в конец
            Node n = new Node(value);
            if (head == null) {
                head = tail = n;
            } else {
                tail.next = n;
                n.prev = tail;
                tail = n;
            }
        }

        void remove(int value) { // удаление элемент по значению
            Node n = head;
            while (n != null) {
                if (n.value == value) {
                    if (n.prev == null) head = n.next;
                    else n.prev.next = n.next;

                    if (n.next == null) tail = n.prev;
                    else n.next.prev = n.prev;
                    return;
                }
                n = n.next;
            }
        }

        void print() {
            for (Node n = head; n != null; n = n.next)
                System.out.print(n.value + " ");
            System.out.print("| Назад: ");
            for (Node n = tail; n != null; n = n.prev)
                System.out.print(n.value + " ");
            System.out.println();
        }
    }

    static class CircularList { // циклич список
        Node tail;

        void add(int value) {
            Node n = new Node(value);
            if (tail == null) {
                tail = n;
                n.next = n;
            } else {
                n.next = tail.next;
                tail.next = n;
                tail = n;
            }
        }

        void remove(int value) {
            if (tail == null) return;

            Node prev = tail;
            Node n = tail.next;

            do {
                if (n.value == value) {
                    if (n == prev) tail = null;
                    else {
                        prev.next = n.next;
                        if (n == tail) tail = prev;
                    }
                    return;
                }
                prev = n;
                n = n.next;
            } while (n != tail.next);
        }

        void print() {
            if (tail == null) {
                System.out.println("Пусто");
                return;
            }

            Node n = tail.next;
            do {
                System.out.print(n.value + " ");
                n = n.next;
            } while (n != tail.next);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoublyList a = new DoublyList();
        CircularList b = new CircularList();

        for (int i : new int[]{10, 20, 30}) {
            a.add(i); // двусвяз
            b.add(i); // циклич
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