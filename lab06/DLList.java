public class DLList {
    DLNode sentinel;
    int size;

    public class DLNode {
        Object item;
        DLNode prev, next;

        public DLNode(Object item, DLNode prev, DLNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Construct a new DLList with a sentinel that points to itself.
     */
    public DLList() {
        sentinel = new DLNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Insert into the end of this list
     * @param o Object to insert
     */
    public void insertBack(Object o) {
        DLNode n = new DLNode(o, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size++;
    }


    /**
     * Get the value at position pos. If the position does not exist, return null (the item of
     * the sentinel).
     * @param position to get from
     * @return the Object at the position in the list.
     */
    public Object get(int position) {
        DLNode curr = sentinel.next;
        while (position > 0 && curr != sentinel) {
            curr = curr.next;
            position--;
        }
        return curr.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("DLList(");
        DLNode curr = sentinel.next;
        while (curr != sentinel) {
            s.append(curr.item.toString());
            if (curr.next != sentinel) s.append(", ");
            curr = curr.next;
        }
        s.append(')');
        return s.toString();
    }

    /* Fill these in! */

    /**
     * Insert a new node into the DLList.
     * @param o Object to insert
     * @param position position to insert into. If position exceeds the size of the list, insert into
     *            the end of the list.
     */
    public void insert(Object o, int position) {
        // fill me in
        if (position>=size) {
            position = size;
        } else {
            ;
        }
            DLNode iter = sentinel;
            iter = iter.next;
            int count = 0;
            while (count != position) {
                count++;
                iter = iter.next;
            }
            DLNode n = new DLNode(o,iter.prev,iter);
            n.prev.next = n;
            n.next.prev = n;
            size++;
    }

    /**
     * Insert into the front of this list. You should can do this with a single call to insert().
     * @param o Object to insert
     */
    public void insertFront(Object o) {
        // fill me in
        DLNode n = new DLNode(o,sentinel,sentinel.next);
        n.prev.next = n;
        if (n.next ==null) {
            ;
        } else {
            n.next.prev = n;
        }
        size++;
    }

    /**
     * Remove all copies of Object o in this list
     * @param o Object to remove
     */
    public void remove(Object o) {
        // fill me in
        DLNode iter = sentinel.next;
        while (iter != null && iter != sentinel) {
            if (iter.item.equals(o)) {
                iter.prev.next = iter.next;
                if (iter.next == null) {
                    iter = iter.next;
                } else {
                    DLNode tmp = iter.next;
                    iter.next.prev = iter.prev;
                    iter = tmp;
                }
                size--;
            }
            else {
                iter = iter.next;
            }
        }
    }

    /**
     * Remove a DLNode from this list. Does not error-check to make sure that the node actually
     * belongs to this list.
     * @param n DLNode to remove
     */
    public void remove(DLNode n) {
        // fill me in
        DLNode iter = sentinel.next;
        while (iter != null && iter != sentinel) {
            if (iter.equals(n)) {
                iter.prev.next = iter.next;
                if (iter.next == null) {
                    iter = iter.next;
                } else {
                    DLNode tmp = iter.next;
                    iter.next.prev = iter.prev;
                    iter = tmp;
                }
                size--;
            }
            else {
                iter = iter.next;
            }
        }
    }


    /**
     * Duplicate each node in this linked list destructively.
     */
    public void doubleInPlace() {
        // fill me in
        DLNode it = sentinel.next;
        DLNode new_sentinel = new DLNode(null,null,null);
        
    }

    /**
     * Reverse the order of this list destructively.
     */
    public void reverse() {
        // fill me in
        DLNode reverse_it = sentinel.next;
        DLNode new_sentinel = new DLNode(null,null,null);
        //DLNode prev = new_sentinel;
        while (reverse_it != null) { // reversely iterate current list
              DLNode n = new DLNode(reverse_it.item, new_sentinel.prev, new_sentinel);
            n.prev.next = n;
            n.next.prev = n;
            reverse_it = reverse_it.next;
        }
        this.sentinel = new_sentinel;
    }

    public static void main(String[] args) {
        // you can add some quick tests here if you would like
    }
}
