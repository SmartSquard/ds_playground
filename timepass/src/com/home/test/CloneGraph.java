package com.home.test;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    public static void main(String arg[]) {
        List<String> list = Arrays.asList("sdasd","b","abc","adef");
        Collections.sort(list, Comparator.comparingInt(String::length));
        System.out.println(list);
    }

    public Node cloneGraph(Node node) {
        if(node == null || node.neighbors == null || node.neighbors.size() == 0) {
            return node;
        }
        LinkedList<Node> queue = new LinkedList<>();
        Map<Node, Node> visited= new HashMap<Node, Node>();
        Node root = new Node(node.val);
        visited.put(node, root);
        queue.add(node);
        while(!queue.isEmpty()) {
            Node temp = queue.remove();
            for(Node neighbour : temp.neighbors) {
                if(!visited.containsKey(neighbour)) {
                    visited.put(neighbour, new Node(node.val));
                    queue.add(neighbour);
                }
                visited.get(temp).neighbors.add(visited.get(neighbour));
            }
        }
        return visited.get(node);
    }
}
