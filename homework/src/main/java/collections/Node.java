package collections;

public class Node {

    public int id;
    public String[] load = null;
    public Node next = null;

    public Node(int _id) {
        id = _id;
    }

    public Node(int _id, String[] _load) {
        load = new String[_load.length];
        for (int i = 0; i < _load.length; i++) {
            load[i] = _load[i];
        }
    }

}
