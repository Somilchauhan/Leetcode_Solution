public class solution {

    // This class implements a simple queue using an array

    public class QueueArray {
        private int[] arr;
        private int front;
        private int rear;
        private int capacity;
        private int size;

        public QueueArray(int capacity) {
            this.capacity = capacity;
            this.arr = new int[capacity];
            this.front = -1;
            this.rear = -1;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void enqueue(int item){
            if(isFull()){
                System.out.println("Queue is full. Cannot enqueue " + item);
                return;
            }
            if (isEmpty()) {
                front = rear = 0;
                arr[rear] = item;
            }
            else{
                rear = (rear + 1) % capacity;
                arr[rear] = item;
            }
            size++;
            System.out.println("Enqueued: " + item);
        }

        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1; // or throw an exception
            }
            int item = arr[front];
            if(front == rear){ // Queue has only one element
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            size--;
            return item;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot peek.");
                return -1; // or throw an exception
            }
            return arr[front];
        }

        public int size(){
            return size;
        }
    }
    
    public class QueueLinkedList{
        private class Node{
            int value;
            Node next;
            Node(int value){
                this.value = value;
                this.next = null;
            }
        }

        private Node front;
        private Node rear;
        private int n = 0;

        public QueueLinkedList() {
            this.front = null;
            this.rear = null;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public void enqueue(int value){
            Node newNode = new Node(value);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            n++;
            System.out.println("Enqueued: " + value);
        }

        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty. Cannot dequeue.");
                return -1;
            }else{
                int value = front.value;
                if(front == rear) { // Queue has only one element
                    front = rear = null;
                } else {
                    front = front.next;
                }
                n--;

                return value;
            }
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty. Cannot peek.");
                return -1;
            }
            return front.value;
        }

        public int size() {
            return n;
        }

        public void clear() {
            front = rear = null;
            n = 0;
            System.out.println("Queue cleared.");
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            Node current = front;
            System.out.print("Queue: ");
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }

        public void reverse() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot reverse.");
                return;
            }
            Node prev = null;
            Node current = front;
            rear = front; // Update rear to the current front
            while (current != null) {
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            front = prev; // Update front to the last processed node
            System.out.println("Queue reversed.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Queue Implementation in Java using Array");

        solution sol = new solution();
        QueueArray queue = sol.new QueueArray(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front item is: " + queue.peek());
        System.out.println("Queue size is: " + queue.size());
        System.out.println("Dequeued item: " + queue.dequeue());
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        System.out.println("Front item is: " + queue.peek());
        queue.enqueue(70); // This should print that the queue is full
        System.out.println("Queue size is: " + queue.size());


        System.out.println("\nQueue Implementation in Java using Linked List");
        QueueLinkedList linkedListQueue = sol.new QueueLinkedList();
        linkedListQueue.enqueue(10);
        linkedListQueue.enqueue(20);
        linkedListQueue.enqueue(30);
        linkedListQueue.display();
        System.out.println("Front item is: " + linkedListQueue.peek());
        System.out.println("Queue size is: " + linkedListQueue.size());
        System.out.println("Dequeued item: " + linkedListQueue.dequeue());
        linkedListQueue.enqueue(40);
        linkedListQueue.enqueue(50);

        linkedListQueue.display();
        System.out.println("Front item is: " + linkedListQueue.peek());
    }
}
