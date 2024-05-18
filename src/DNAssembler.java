import java.util.List;
import java.util.Scanner;

public class DNAssembler {
    public static void main(String[] args) {
        // 1. Create a prefix tree using the DNA alphabet A, C, G, T.
        Trie trie = new Trie();

        // 2. Create a function that inserts a DNA fragment into the tree.
        // Prompt the user to input DNA fragments
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter DNA fragments (press Enter after each fragment, type 'done' when finished):");
        String fragment = scanner.nextLine();
        while (!fragment.equals("done")) {
            trie.insert(fragment);
            System.out.println("DNA fragment inserted: " + fragment);
            System.out.println("Enter next DNA fragment (or 'done' to finish):");
            fragment = scanner.nextLine();
        }

        // Display the trie structure
        System.out.println("Trie structure after DNA fragment insertion:");
        System.out.println(trie);

        // 4. Create a function that extracts all paths from the tree which have a weight on the edge no less than a pre-defined parameter (consensus).
        System.out.println("GET CONTIG");
        System.out.print("Enter the weight for which you want to get the contig: ");
        int weight = Integer.parseInt(scanner.nextLine());

        // Get all contigs for the specified weight
        List<String> contigs = trie.getContig(weight);
        System.out.println("Contigs for weight " + weight + ": " + contigs);
    }
}

