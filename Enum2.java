public class Enum2 {
    public enum ClothingSize {
        SMALL("S", "Small size"),
        MEDIUM("M", "Medium size"),
        LARGE("L", "Large size"),
        XLARGE("XL", "Extra large size");
    
        private final String abbreviation;
        private final String description;
    
        ClothingSize(String abbreviation, String description) {
            this.abbreviation = abbreviation;
            this.description = description;
        }
    
        public String getAbbreviation() {
            return abbreviation;
        }
    
        public String getDescription() {
            return description;
        }
    }

    public static void main(String[] args) {
        for (ClothingSize size : ClothingSize.values()) {
            System.out.println("Size: " + size + 
                               ", Abbreviation: " + size.getAbbreviation() + 
                               ", Description: " + size.getDescription());
        }
    }
}
