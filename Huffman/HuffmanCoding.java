import java.io.*;
import java.util.*;
import java.nio.file.*;

public class HuffmanCoding {

    // Node class for Huffman tree
    static class Node {
        int frequency;
        char character;
        Node left, right;

        // Constructor for leaf nodes
        public Node(int frequency, char character) {
            this.frequency = frequency;
            this.character = character;
        }

        // Constructor for internal nodes
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
        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.character, code.length() > 0 ? code : "0");
            return;
        }

        if (root.left != null) generateHuffmanCodes(root.left, code + "0", huffmanCodes);
        if (root.right != null) generateHuffmanCodes(root.right, code + "1", huffmanCodes);
    }

    // Encode the data using the Huffman codes
    public static String encode(String data, Map<Character, String> huffmanCodes) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : data.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        return encodedString.toString();
    }
    
    // Writes the encoded data to a binary file
    public static void writeEncodedFile(String encodedData, Map<Character, String> huffmanCodes, String filename) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            // Write the size of the dictionary
            out.writeInt(huffmanCodes.size());
            // Write each character and its corresponding Huffman code
            for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
                out.writeChar(entry.getKey());
                out.writeUTF(entry.getValue());
            }

            out.writeInt(encodedData.length());
            int bitIndex = 0;
            byte currentByte = 0;

            for (char bit : encodedData.toCharArray()) {
                currentByte <<= 1;
                if (bit == '1') currentByte |= 1;
                bitIndex++;

                if (bitIndex == 8) {
                    out.write(currentByte);
                    bitIndex = 0;
                    currentByte = 0;
                }
            }

            if (bitIndex > 0) {
                currentByte <<= (8 - bitIndex);
                out.write(currentByte);
            }
        }
    }

    // Reads the encoded file and decodes it back to the original data
    public static String readAndDecodeFile(String filename) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            int dictSize = in.readInt();
            Map<String, Character> reversedCodes = new HashMap<>();

            for (int i = 0; i < dictSize; i++) {
                char ch = in.readChar();
                String code = in.readUTF();
                reversedCodes.put(code, ch);
            }

            int encodedLength = in.readInt();
            StringBuilder encodedData = new StringBuilder();
            while (in.available() > 0) {
                int b = in.readUnsignedByte();
                encodedData.append(String.format("%8s", Integer.toBinaryString(b)).replace(' ', '0'));
            }

            encodedData.setLength(encodedLength);

            StringBuilder decodedString = new StringBuilder();
            StringBuilder currentCode = new StringBuilder();for (char bit : encodedData.toString().toCharArray()) {
                currentCode.append(bit);
                if (reversedCodes.containsKey(currentCode.toString())) {
                    decodedString.append(reversedCodes.get(currentCode.toString()));
                    currentCode.setLength(0);
                }
            }

            return decodedString.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
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