package linklist;

/**
 * Created by umesh on 8/11/15.
 */
public class LinkList {
    Node head;

    public LinkList(Node head) {
        this.head = head;
    }

    public void reverse() {
        Node t = head;
        Node prev = null;
        while(t != null) {
            Node t1 = t.next;
            t.next = prev;
            prev = t;
            t = t1;
        }

        head = prev;
    }

}
