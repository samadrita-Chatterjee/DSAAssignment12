package in.ineuron;

import java.util.*;
class Node {
        int num;
        Node next;
        Node(int val) {
            num = val;
            next = null;
        }
}
class CheckPalindrom{
static Node insertNode(Node head,int val) {
    Node newNode = new Node(val);
    if(head == null) {
        head = newNode;
        return head;
    }
    
    Node temp = head;
    while(temp.next != null) temp = temp.next;
    
    temp.next = newNode;
    return head;
}

static Node reverse(Node ptr) {
    Node pre=null;
    Node nex=null;
    while(ptr!=null) {
        nex = ptr.next;
        ptr.next = pre;
        pre=ptr;
        ptr=nex;
    }
    return pre;
}

static boolean isPalindrome(Node head) {
    if(head==null||head.next==null) return true;
        
    Node slow = head;
    Node fast = head;
        
    while(fast.next!=null&&fast.next.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
    }
        
    slow.next = reverse(slow.next);
    slow = slow.next;
    Node dummy = head;
        
    while(slow!=null) {
        if(dummy.num != slow.num) return false;
        dummy = dummy.next;
        slow = slow.next;
    }
    return true;
}

public static void main(String args[]) {
    Node head = null;
    head=insertNode(head,1);
    head=insertNode(head,2);
    head=insertNode(head,3);
    head=insertNode(head,2);
    head=insertNode(head,1);
    if(isPalindrome(head)==true)
    System.out.println("True"); 
    else
    System.out.println("False");
    
}
}
