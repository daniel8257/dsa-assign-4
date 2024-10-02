// package LinkedList;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    // Node class representing each element in the linked list
    public class Node {
        public int value;
        public Node next;
    }

    // Create a linked list
    public Node createLinkedList(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.value = nodeValue;
        node.next = null;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert into a linked list
    public void insertInLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createLinkedList(nodeValue);
            return;
        } else if (location == 0) { // Inserting at the beginning
            node.next = head;
            head = node;
        } else if (location >= size) { // Inserting at the end
            tail.next = node;
            node.next = null;
            tail = node;
        } else { // Inserting at a specific location
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traverse a linked list
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.print("\n");
    }

    // Search for a node
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node: " + tempNode.value + " at location: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // Delete a node from the linked list
    public void deleteNode(int location) {
        if (head == null) {
            System.out.println("The linked list does not exist.");
            return;
        } else if (location == 0) { // Deleting the first node
            head = head.next;
            size--;
            if (size == 0) {
                tail = null; // If the list becomes empty
            }
        } else if (location >= size) { // Deleting the last node
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head) { // If only one node is present
                head = tail = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else { // Deleting a node from the middle
            Node tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    // Delete the entire linked list
    public void deleteLinkedList() {
        head = null;
        tail = null;
        size = 0;
        System.out.println("The linked list has been deleted.");
    }

    // Main method for demonstration
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.createLinkedList(5);
        list.insertInLinkedList(10, 1);
        list.insertInLinkedList(20, 2);
        list.insertInLinkedList(30, 3);

        System.out.println("Linked List after insertion:");
        list.traverseLinkedList();

        list.searchNode(20);

        list.deleteNode(2);
        System.out.println("Linked List after deleting node at index 2:");
        list.traverseLinkedList();

        list.deleteLinkedList();
    }
}
