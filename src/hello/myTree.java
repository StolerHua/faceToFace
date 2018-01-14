package hello;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    private int visited;
    Node []adjacent;
    public Node(){
        visited=0;
        adjacent = null;
    }
    public int getVisited(){
        return visited;
    }
    public void setVisited(int isvisit){
        visited = isvisit;
    }
}
public class myTree {

    private void visit(Node node){

    }

    private void dfsSearch(Node root){
        if (root==null){
            return;
        }

        visit(root);

        root.setVisited(1);
        for (Node n :root.adjacent
             ) {
            if (n.getVisited()==0){
                dfsSearch(n);
            }
        }
    }

    private void bfsSearch (Node root){
        Queue <Node> queue = new LinkedList<>();
        root.setVisited(1);
        visit(root);
        queue.offer(root);
        
        while(!queue.isEmpty()){
            Node r = queue.poll();
            for (Node n:r.adjacent
                 ) {
                if(n.getVisited()==0){
                    visit(n);
                    n.setVisited(1);
                    queue.offer(n);
                }
            }
        }
    }
}
