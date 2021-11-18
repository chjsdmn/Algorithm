package com.algdat.uke39;

public class DobbeltLenketListe {
    public static void main(String[] args) {
        DobbeltLenketListe values = new DobbeltLenketListe();
        values.add_first(3);
        values.print();
        //Forventer utskrift 3,

        values.add_first(1);
        values.print();
        //Forventer utskrift 1, 3,

        values.add_first(7);
        values.print();
        //Forventer utskrift 7, 1, 3

        values.add_last(9);
        values.print();
        //Forventer utskrift 7, 1, 3, 9

        values.insert(1, 8);
        values.print();
    }

    static class Node {
        int value;
        Node next;
        Node pre;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.pre = null;
        }

        Node(int value, Node pre, Node next) {
            this.value = value;
            this.next = next;
            this.pre = pre;
        }
    }

    Node head;
    Node tail;
    int lengde;

    DobbeltLenketListe() {
        this.head = null;
        this.tail = null;
        this.lengde = 0;
    }

    public void print() {
        Node p = tail;
        for (int i = 0; i < lengde; i++) {
            System.out.print(p.value + " ");
            p = p.pre;
        }
        System.out.println();
        Node q = head;
        while (q != null) {
            System.out.print(q.value + " ");
            q = q.next;
        }
        System.out.println();
    }

    int add_first(int value) {
        Node n = new Node(value);
        if (head == null && tail == null) {
            head = n;
            tail = n;
            lengde += 1;
        } else {
            Node m = head;
            head = n;
            m.pre = n;
            n.next = m;
            lengde += 1;
        }
        return lengde;
    }

    int add_last(int value) {
        Node n = new Node(value);
        if (head == null && tail == null) {
            head = n;
            tail = n;
            lengde += 1;
        } else {
            Node m = tail;   //必须设置这个变量赋值给tail，否则加不进去！！
            tail = n;
            m.next = n;
            n.pre = m;
            lengde += 1;
        }
        return lengde;
    }

    void insert(int index, int value) {
        if (index == 0) {
            add_first(value);
        } else if (index == lengde - 1) {
            add_last(value);
        } else {
            Node n = new Node(value);
            Node m = head;
            for (int i = 0; i < index; i++) {
                m = m.next;
            }
            Node l = m.pre;
            l.next = n;
            n.next = m;
            m.pre = n;
            n.pre = l;
            lengde += 1;
        }
    }

    /*void remove(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            Node q = null;  //Søk fra starten hvis index før halvveis
            if (index < size / 2) {
                q = head;
                for (int i = 0; i < index; ++i) {
                    q = q.next;
                }
            }//Søk fra slutten hvis index over halvveis
            else {
                q = tail;
                for (int i = size - 1; i > index; --i) {
                    q = q.prev;
                }
            }//Finn de to nabonodene
            Node p = q.prev;
            Node r = q.next;
            p.next = r;  //Sett pekere til naboer
            r.prev = p;
            --size; //Oppdater størrelse
        }
    }*/
    /*void remove(char value) {
        Node q = head; //Søk fra starten, vi skal fjerne første "value"
        for (int i = 0; i < size; ++i) {
            if (q.value == value) {
                break;
            }
            else {
                q = q.next;
            }
        }//Finn nabonoder
        Node p = q.prev;
        Node r = q.next;
        p.next = r; //Sett pekere til naboer
        r.prev = p;
        --size;  //Oppdater størrelse
    }*/
}
