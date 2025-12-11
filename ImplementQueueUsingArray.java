import java.util.*;

class CircularQueue {
    int front, rear, capacity;
    int[] queue;

    // Constructor to initialize the queue
    CircularQueue(int size) {
        front = 0;
        rear = -1;
        capacity = size;
        queue = new int[capacity];
    }

    // Function to insert an element at the rear of the queue
    void enqueue(int data) {
        // Check if the queue is full
        if (rear == capacity - 1) {
            System.out.println("Queue is full");
            return;
        }

        // Insert element at the rear
        queue[++rear] = data;
    }

    // Function to remove an element from the front of the queue
    void dequeue() {
        // Check if the queue is empty
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        // Shift all elements from front to rear to the left by one position
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }

        // Decrement the rear
        rear--;
    }

    // Function to display queue elements
    void display() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        // Traverse from front to rear and print elements
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " <- ");
        }
        System.out.println();
    }

    // Function to print the front element of the queue
    void frontElement() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front Element is: " + queue[front]);
    }

    public static void main(String[] args) {
        // Create a queue with a capacity of 4
        CircularQueue queue = new CircularQueue(4);

        // Display queue elements
        queue.display();

        // Insert elements into the queue
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Display queue elements
        queue.display();

        // Attempt to enqueue an element into a full queue
        queue.enqueue(60);

        // Display queue elements
        queue.display();

        // Dequeue elements
        queue.dequeue();
        queue.dequeue();

        System.out.println("After two deletions:");

        // Display queue elements
        queue.display();

        System.out.println("After inserting one more element:");
        queue.enqueue(60);

        // Display queue elements
        queue.display();

        // Display the front element of the queue
        queue.frontElement();
    }
}
