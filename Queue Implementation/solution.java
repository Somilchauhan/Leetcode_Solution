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
    }
}
