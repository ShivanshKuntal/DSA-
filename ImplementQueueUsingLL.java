class Node {
    int value;
    Node nextNode;

    Node(int value) {
        this.value = value;
        this.nextNode = null;
    }
}

// Class to implement queue operations using a linked list
class ImplementQueueUsingLL {

    // Pointers to the front and the rear of the linked list
    Node front, rear;

    // Constructor to initialize the front and rear
    ImplementQueueUsingLL() {
        front = rear = null;
    }

    // Function to check if the queue is empty
    boolean isEmpty() {
        // If the front is null, then the queue is empty
        return front == null;
    }

    // Function to add an element to the queue
    void enqueue(int value) {
        // Create a new linked list node
        Node newNode = new Node(value);

        // If queue is empty, the new node is both the front and rear
        if (rear == null) {
            front = rear = newNode;
            return;
        }

        // Add the new node at the end of the queue and change rear
        rear.nextNode = newNode;
        rear = newNode;
    }

    // Function to remove an element from the queue
    void dequeue() {
        // If queue is empty, return
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }

        // Move front one node ahead
        front = front.nextNode;

        // If front becomes null, then change rear to null
        if (front == null) {
            rear = null;
        }
    }

    // Function to get the front element of the queue
    int getFront() {
        // Checking if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return front.value;
    }

    // Function to get the rear element of the queue
    int getRear() {
        // Checking if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return rear.value;
    }
}

// Driver code to test the queue implementation
public class Main {
    public static void main(String[] args) {
        ImplementQueueUsingLL queue = new ImplementQueueUsingLL();

        // Enqueue elements into the queue
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println("Queue Front: " + queue.getFront());
        System.out.println("Queue Rear: " + queue.getRear());

        // Dequeue elements from the queue
        queue.dequeue();
        queue.dequeue();

        // Enqueue more elements into the queue
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Dequeue an element from the queue
        queue.dequeue();

        System.out.println("Queue Front: " + queue.getFront());
        System.out.println("Queue Rear: " + queue.getRear());
    }
}

