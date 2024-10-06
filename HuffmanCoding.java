import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

class Node implements Comparable<Node> {
    char character;     //Character stored in the node
    int frequency;      // Frequency of the character
    Node left;
    Node right;

    public Node(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;  // Compare nodes based on frequency
    }
}

public class HuffmanCoding {
    private Map<Character, String> huffmanCodes = new HashMap<>();  // Map to store Huffman codes
    private Node root;      // Root of the Huffman Tree

    private void buildHuffmanTree(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Priority queue for building the tree
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new Node(entry.getKey(), entry.getValue()));
        }

        while (priorityQueue.size() > 1) {
            Node left = priorityQueue.poll();
            Node right = priorityQueue.poll();
            Node newNode = new Node('\0', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;
            priorityQueue.add(newNode);
        }

        root = priorityQueue.poll(); 
    }

    // Generate Huffman codes
    private void generateCodes(Node node, String code) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.character, code);
            return;
        }
        generateCodes(node.left, code + "0");
        generateCodes(node.right, code + "1");
    }
    
    // Encode the given text
    public String encode(String text) {
        buildHuffmanTree(text);
        generateCodes(root, "");
        
        StringBuilder encodedString = new StringBuilder();
        for (char c : text.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        return encodedString.toString();
    }
    
    // Decode the encoded string
    public String decode(String encodedString) {
        StringBuilder decodedString = new StringBuilder();
        Node current = root;

        for (char bit : encodedString.toCharArray()) {
            current = (bit == '0') ? current.left : current.right;

            if (current.left == null && current.right == null) {
                decodedString.append(current.character);
                current = root; 
            }
        }

        return decodedString.toString();
    }

    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        
        String text = "I love sunshine";
        String encoded = huffmanCoding.encode(text);
        System.out.println("Encoded: " + encoded);
        
        String decoded = huffmanCoding.decode(encoded);
        System.out.println("Decoded: " + decoded);
    }
}
