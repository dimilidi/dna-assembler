import java.util.HashMap;
import java.util.Map;

class Node {
    Map<Character, Node> children;
    int weight; // 3. For each edge of the tree, set a weight corresponding to the number of DNA fragments using that edge



    public Node() {
        children = new HashMap<>();
        weight = 0; // Initialize the weight for each node
    }

    @Override
    public String toString() {
        return "Node{" +
                "children=" + children +
                ", weight=" + weight +
                '}';
    }
}
