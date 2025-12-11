/*class LL{
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
    public Node head;

    //insert at first 
    public void addFirst(String data){
        Node newNode = new Node(data);

        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;

    }
    //insert at last
    public void addLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;

        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }
    //delete first
    public void deleteFirst(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        head=head.next;
    }

    public void deleteLast(){
        if(head==null){
            System.out.println("empty");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node seclast=head;
        Node last=head.next;
        while(last.next!=null){
            last=last.next;
            seclast=seclast.next;

        }
        seclast.next=null;
    }
    //traversal and print
    public void printList(){
        if(head==null){
            System.out.println("empty list");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.println(currNode.data+" ");
            currNode=currNode.next;
        }}

        public  static void  main(String[]args){
            LL list = new LL();
            list.addFirst("a");
            list.addFirst("b");
            list.addFirst("c");
            list.addFirst("d");
            list.addFirst("e");
            list.addLast("1");
            list.addLast("1");
            list.addLast("1");
            list.printList();


        }

    }*/

    class LL {
        class Node {
            String data;
            Node next;
            Node(String data) {
                this.data = data;
                this.next = null;
            }
        }
        public Node head;
    
        // Insert at the beginning
        public void addFirst(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
    
        // Insert at the end
        public void addLast(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
    
        // Insert after a specified node
        public void insertAfter(String prevData, String data) {
            Node currNode = head;
            while (currNode != null && !currNode.data.equals(prevData)) {
                currNode = currNode.next;
            }
            if (currNode == null) {
                System.out.println("Previous node not found.");
                return;
            }
            Node newNode = new Node(data);
            newNode.next = currNode.next;
            currNode.next = newNode;
        }
    
        // Delete the first node
        public void deleteFirst() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            head = head.next;
        }
    
        // Delete the last node
        public void deleteLast() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            if (head.next == null) {
                head = null;
                return;
            }
            Node seclast = head;
            Node last = head.next;
            while (last.next != null) {
                last = last.next;
                seclast = seclast.next;
            }
            seclast.next = null;
        }
    
        // Delete a node after a specified node
        public void deleteAfter(String prevData) {
            Node currNode = head;
            while (currNode != null && !currNode.data.equals(prevData)) {
                currNode = currNode.next;
            }
            if (currNode == null || currNode.next == null) {
                System.out.println("Node not found or no node exists after the specified node.");
                return;
            }
            currNode.next = currNode.next.next;
        }
    
        // Traversal and print the list
        public void printList() {
            if (head == null) {
                System.out.println("Empty list");
                return;
            }
            Node currNode = head;
            while (currNode != null) {
                System.out.print(currNode.data + " ");
                currNode = currNode.next;
            }
            System.out.println();
        }
    
        // Search for a node in the list
        public boolean search(String data) {
            Node currNode = head;
            while (currNode != null) {
                if (currNode.data.equals(data)) {
                    return true;
                }
                currNode = currNode.next;
            }
            return false;
        }
    
        public static void main(String[] args) {
            LL list = new LL();
            list.addFirst("a");
            list.addFirst("b");
            list.addFirst("c");
            list.addFirst("d");
            list.addFirst("e");
            list.addLast("1");
            list.addLast("2");
            list.addLast("3");
    
            // Test the insertAfter method
            list.insertAfter("c", "x");
    
            // Test the deleteAfter method
            list.deleteAfter("b");
    
            // Print the list
            list.printList();
    
            // Test the search method
            System.out.println("Search for 'a': " + list.search("a"));
            System.out.println("Search for 'z': " + list.search("z"));
    
            // Test deleteFirst and deleteLast methods
            list.deleteFirst();
            list.deleteLast();
            list.printList();
        }
    }
    


