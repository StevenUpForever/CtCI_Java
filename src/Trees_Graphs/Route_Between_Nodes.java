package Trees_Graphs;

import PublicClass.GraphNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Route_Between_Nodes {

    /*
    Given a directed graph, design an algorithm to  find out whether there is a route between two nodes.
     */

    boolean route(GraphNode root, GraphNode a, GraphNode b) {
        if (a == b) return true;
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(root);
        root.visited = true;
        boolean visitedOne = false;
        if (root == a || root == b) visitedOne = true;
        while (!queue.isEmpty()) {
            GraphNode pop = queue.poll();
            for (GraphNode node: pop.neighbors) {
                if (!node.visited) {
                    if (node == a || node == b) {
                        if (visitedOne) return true;
                        visitedOne = true;
                    }
                    queue.offer(node);
                    node.visited = true;
                }
            }
        }
        return false;
    }

}
