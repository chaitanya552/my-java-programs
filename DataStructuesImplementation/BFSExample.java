
/*
 * https://java2blog.com/depth-first-search-in-java/
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFSExample
{
    static Queue<Node> queue = new LinkedList<Node>();

    public static void main(final String[] args)
    {
        // TODO Auto-generated method stub
        final Node node40 = new Node(40);
        final Node node10 = new Node(10);
        final Node node20 = new Node(20);
        final Node node30 = new Node(30);
        final Node node60 = new Node(60);
        final Node node50 = new Node(50);
        final Node node70 = new Node(70);

        node40.addneighbours(node10);
        node40.addneighbours(node20);
        node10.addneighbours(node30);
        node20.addneighbours(node10);
        node20.addneighbours(node30);
        node20.addneighbours(node60);
        node20.addneighbours(node50);
        node30.addneighbours(node60);
        node60.addneighbours(node70);
        node50.addneighbours(node70);
        final BFSExample b = new BFSExample();
        // b.BFSImplement(node40);
        b.dfsUsingStack(node40);

    }

    private static void BFSImplement(final Node node)
    {
        queue.add(node);
        node.visited = true;

        while (!queue.isEmpty()) {
            System.out.println(queue.peek().data);
            final Node element = queue.peek();
            queue.remove();

            for (final Node neighb : element.neighbours) {

                if ((neighb != null) && (neighb.visited == false)) {
                    neighb.visited = true;
                    queue.add(neighb);
                }
            }
        }
    }

    // Iterative DFS using stack
    public void dfsUsingStack(final Node node)
    {
        final Stack<Node> stack = new Stack<Node>();

        stack.add(node);
        node.visited = true;
        while (!stack.isEmpty()) {
            final Node element = stack.pop();
            System.out.print(element.data + " ");

            final List<Node> neighbours = element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                final Node n = neighbours.get(i);
                if ((n != null) && !n.visited) {
                    stack.add(n);
                    n.visited = true;

                }
            }
        }
    }

    static class Node
    {
        int data;
        boolean visited;
        List<Node> neighbours;

        Node(final int data)
        {
            this.data = data;
            neighbours = new ArrayList<>();

        }

        public void addneighbours(final Node neighbourNode)
        {
            neighbours.add(neighbourNode);
        }

        public List<Node> getNeighbours()
        {
            return neighbours;
        }

        public void setNeighbours(final List<Node> neighbours)
        {
            this.neighbours = neighbours;
        }
    }
}
