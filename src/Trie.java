import java.util.ArrayList;
import java.util.List;
import java.util.Map;


class Trie {
    private static final String ALPHABET = "ACGT"; // Define the DNA alphabet
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String fragment) {
        Node node = root;
        for (char base : fragment.toCharArray()) {
            // Validate the character
            if (ALPHABET.indexOf(base) == -1) {
                throw new IllegalArgumentException("Invalid character in DNA sequence: " + base);
            }

            // Traverse or create child node for each character
            if (!node.children.containsKey(base)) {
                node.children.put(base, new Node());
            }
            node = node.children.get(base);
            // Increment the weight of the node
            node.weight++;
        }
    }

    public List<String> getContig(int weight) {
        List<String> result = new ArrayList<>();
        collectContigs(root, new StringBuilder(), weight, result);
        return result;
    }

    // Recursive function to collect contigs
    private void collectContigs(Node node, StringBuilder prefix, int weight, List<String> result) {
        if (node.weight == weight) {
            result.add(prefix.toString());
        }
        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            prefix.append(entry.getKey());
            collectContigs(entry.getValue(), prefix, weight, result);
            prefix.deleteCharAt(prefix.length() - 1); // Backtrack
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toStringHelper(root, "", sb, ' ');
        return sb.toString();
    }

    // Helper method for toString
    private void toStringHelper(Node node, String indent, StringBuilder sb, char base) {
        sb.append(indent).append("{base=\"").append(base).append("\", weight=").append(node.weight).append(", children={\n");
        for (Map.Entry<Character, Node> entry : node.children.entrySet()) {
            toStringHelper(entry.getValue(), indent + "  ", sb, entry.getKey());
        }
        sb.append(indent).append("}}\n");
    }
}


