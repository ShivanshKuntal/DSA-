
class Node{
    int data;
    Node next;
    Node(int data, Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
};
public class LLusingArray{
    private static Node LLfromArr(int[] arr){
        Node head= new Node(arr[0]);
        Node nextNode=head;
        for (int i=1;i<arr.length;i++){
            Node temp= new Node(arr[i]);
            nextNode.next=temp;
            nextNode=nextNode.next;
        }
        return head;
    }
    private static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

   
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9};
        Node head=LLfromArr(arr);
        
        printLinkedList(head);
    }
}