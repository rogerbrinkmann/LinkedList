
public class LinkedList<T> {

    ListNode first;
    ListNode last;
    ListNode current;

    public class ListNode {
        private ListNode next;
        private T obj;

        public ListNode(T obj, ListNode next) {
            this.obj = obj;
            this.next = next;
        }

        public void setNextNode(ListNode next) {
            this.next = next;
        }

        public ListNode getNextNode() {
            return this.next;
        }

        public T getContent() {
            return this.obj;
        }

        public void setContent(T obj) {
            this.obj = obj;
        }
    }

    public boolean isEmpty() {
        if (this.first == null && this.last == null) {
            return true;
        }
        return false;
    }

    public boolean hasAccess() {
        if (this.current == null) {
            return false;
        }
        return true;
    }

    public void append(T obj) {
        ListNode newNode = new ListNode(obj, null);
        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            last.setNextNode(newNode);
            last = newNode;
        }
    }

    public void insert(T obj) {
        ListNode newNode = new ListNode(obj, null);
        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else if (hasAccess()) {
            ListNode previous = this.getPrevious(current);
            newNode.setNextNode(previous.getNextNode());
            previous.setNextNode(newNode);
        } else {
            newNode.setNextNode(first);
            first = newNode;
        }
    }

    public void remove(){
        if (this.current == this.first){
            current = first.getNextNode();
            first = first.getNextNode();
        }
        else if (this.current == this.last){
            this.getPrevious(this.last).setNextNode(null);
        }else{

            this.getPrevious(current).setNextNode(current.getNextNode());
            current = current.getNextNode();
        }
    }

    public void next() {
        current = current.getNextNode();
    }

    public void toFirst() {
        current = first;
    }

    public void toLast() {
        current = last;
    }

    private ListNode getPrevious(ListNode cur) {
        ListNode node = first;
        while (node.getNextNode() != cur) {
            node = node.getNextNode();
        }
        return node;
    }
}
