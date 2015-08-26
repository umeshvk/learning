package linklist;

/**
 * Created by umesh on 8/11/15.
 */
public class LinkListTest {

    public static boolean testReverse() {
        Node n3 = new Node(3, null);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);

        LinkList ll = new LinkList(n1);
        ll.reverse();
        return (ll.head.value == 3);
    }
}
