import java.io.*;
import java.util.*;
import java.nio.file.*; 

public class HuffmanCoding {

    // Node class for Huffman tree
    static class Node {
        int frequency;
        char character;
        Node left, right;

        public Node(int frequency, char character) {
            this.frequency = frequency;
            this.character = character;
            this.left = this.right = null;
        }

        public Node(int frequency, Node left, Node right) {
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }
    }

    // Comparator for priority queue to build the Huffman Tree
    static class NodeComparator implements Comparator<Node> {
        public int compare(Node node1, Node node2) {
            return node1.frequency - node2.frequency;
        }
    }

    // Build the Huffman Tree and return the root node
    public static Node buildHuffmanTree(Map<Character, Integer> frequencies) {
        // Special case: Only one unique character
        if (frequencies.size() == 1) {
            char uniqueChar = frequencies.keySet().iterator().next();
            return new Node(frequencies.get(uniqueChar), uniqueChar);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            pq.add(new Node(entry.getValue(), entry.getKey()));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(left.frequency + right.frequency, left, right);
            pq.add(parent);
        }

        return pq.poll();
    }

    // Generate Huffman codes for each character
    public static void generateHuffmanCodes(Node root, String code, Map<Character, String> huffmanCodes) {
        if (root == null) return;

        if (root.character != '\0') {
            huffmanCodes.put(root.character, code);
        }

        generateHuffmanCodes(root.left, code + "0", huffmanCodes);
        generateHuffmanCodes(root.right, code + "1", huffmanCodes);
    }

    // Encode the data using the Huffman codes
    public static String encode(String data, Map<Character, String> huffmanCodes) {
        if (huffmanCodes.size() == 1) {
            return data.replaceAll(".", "0");  
        }

        StringBuilder encodedString = new StringBuilder();
        for (char c : data.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        return encodedString.toString();
    }

    // Decode the encoded data using the Huffman tree
    public static String decode(String encodedData, Node root) {
        if (root.character != '\0' && root.left == null && root.right == null) {
            return encodedData.replaceAll("0", String.valueOf(root.character)); 
        }

        StringBuilder decodedString = new StringBuilder();
        Node currentNode = root;

        for (char bit : encodedData.toCharArray()) {
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;

            if (currentNode.left == null && currentNode.right == null) {
                decodedString.append(currentNode.character);
                currentNode = root;
            }
        }

        return decodedString.toString();
    }

    // Write Huffman encoded data to a file
    public static void writeEncodedFile(String encodedData, Map<Character, String> huffmanCodes, String filename) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            // Write dictionary size (number of unique characters)
            out.writeInt(huffmanCodes.size());

            // Write each character and its corresponding Huffman code
            for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                out.writeChar(entry.getKey());
                out.writeUTF(entry.getValue());
            }

            // Write the encoded data
            out.writeUTF(encodedData);
        }
    }

    // Read the encoded file and decode it
    public static String readAndDecodeFile(String filename) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            int dictSize = in.readInt();
            Map<String, Character> reversedCodes = new HashMap<>();

            for (int i = 0; i < dictSize; i++) {
                char ch = in.readChar();
                String code = in.readUTF();
                reversedCodes.put(code, ch);
            }

            String encodedData = in.readUTF();
            StringBuilder decodedString = new StringBuilder();
            StringBuilder currentCode = new StringBuilder();

            if (dictSize == 1) {
                return encodedData.replaceAll("0", String.valueOf(reversedCodes.values().iterator().next()));
            }

            for (char bit : encodedData.toCharArray()) {
                currentCode.append(bit);

                if (reversedCodes.containsKey(currentCode.toString())) {
                    decodedString.append(reversedCodes.get(currentCode.toString()));
                    currentCode.setLength(0);
                }
            }

            return decodedString.toString();
        }
        
    }

    // Main method to run from command line
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Usage: java HuffmanCoding <encode|decode> <input_file> <output_file>");
            return;
        }

        String mode = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        if (mode.equals("encode")) {
            String inputData = new String(Files.readAllBytes(Paths.get(inputFile)));
            Map<Character, Integer> frequencyMap = new HashMap<>();
            for (char c : inputData.toCharArray()) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }

            Node root = buildHuffmanTree(frequencyMap);
            Map<Character, String> huffmanCodes = new HashMap<>();
            generateHuffmanCodes(root, "", huffmanCodes);

            String encodedData = encode(inputData, huffmanCodes);
            writeEncodedFile(encodedData, huffmanCodes, outputFile);
            System.out.println("File encoded successfully.");

        } else if (mode.equals("decode")) {
            String decodedData = readAndDecodeFile(inputFile);
            Files.write(Paths.get(outputFile), decodedData.getBytes());
            System.out.println("File decoded successfully.");
        } else {
            System.out.println("Invalid mode. Use 'encode' or 'decode'.");
        }
    }
}
