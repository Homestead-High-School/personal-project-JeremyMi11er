public class LetterInventory {

        private int[] counts;
        private int size;
    
        //default contructor
        public LetterInventory() {
            this("");
        }
    
        // Constructs an inventory (a count) of the alphabetic letters in
        // the given string, ignoring the case of letters and ignoring any
        // non-alphabetic characters.
        public LetterInventory(String data) {
            size = data.length();
            data = data.toLowerCase();
            counts = new int[26];
            for(int j = 0; j<data.length(); j++){
                if(data.charAt(j) > 122 || data.charAt(j) < 97){
                    size--;
                }
                else{
                counts[data.charAt(j) - 'a']++;
                }
                
            }
        }
    
        // Returns a count of how many of the given letter (case-insensitive)
        // are in this inventory. If a nonalphabetic character is passed, your
        // method should throw an IllegalArgumentException.
        public int get(char letter) {
            letter = Character.toLowerCase(letter);
            letterCheck(letter);
            return counts[letter - 'a'];
        }
    
        // Sets the count for the given letter (case-insensitive) to the given value.
        // If a non-alphabetic character is passed or if value is negative, your method
        // should throw an IllegalArgumentException.
    
        public void set(char letter, int value) {
            letter = Character.toLowerCase(letter);
            letterCheck(letter);
            size-=counts[letter - 'a'];
            counts[letter - 'a'] = value;
            size+=value;
        }
    
        // Returns the sum of all of the counts in this inventory. This operation should
        // be “fast” in the sense that it should store the size rather than computing it
        // each time the method is called.
        public int size() {
            return size;
        }
    
        // Returns true if this inventory is empty (all counts are 0). This operation
        // should be “fast” in the sense that it shouldn’t loop over the array each time
        // the method is called.
        public boolean isEmpty() {
            return size==0;
        }
    
        // Returns a String representation of the inventory with all the letters in
        // lowercase, in sorted order, and surrounded by square brackets. The number of
        // occurrences of each letter should match its count in the inventory. For
        // example, an inventory of 4 a’s, 1 b, 1 `, and 1 m would be represented as
        // “[aaaablm]”
        public String toString() {
            String s = "[";
            for(int i = 0; i<26; i++){
                for(int j = 0; j<counts[i]; j++){
                    s+= (char)(i+97);
                }
            }
            s+="]";
            return s;
        }
    
        // Constructs and returns a new LetterInventory object that represents the sum
        // of this LetterInventory and the other given LetterInventory. The counts for
        // each letter should be added together. The two LetterInventory objects being
        // added together (this and other) should not be changed by this method. Below
        // is an example of how the add method might be called:
        // 1 LetterInventory inventory1 = new LetterInventory("George W. Bush");
        // 2 LetterInventory inventory2 = new LetterInventory("Hillary Clinton");
        // 3 LetterInventory sum = inventory1.add(inventory2);
        // The first inventory would correspond to [beegghorsuw], the second would
        // correspond to [achiilllnnorty] and the third would correspond to
        // [abceegghhiilllnnoorrstuwy].
        public LetterInventory add(LetterInventory other) {
            LetterInventory a = new LetterInventory();
            for(int i = 0; i<26; i++){
                a.set((char)(i+97),this.counts[i] + other.counts[i]);
            }
            return a;
        }
    
        /*
         * Below is an example of how the subtract method might be called:
         * 1 LetterInventory inventory1 = new LetterInventory("Hello world!");
         * 2 LetterInventory inventory2 = new LetterInventory("owl");
         * 3 LetterInventory difference = inventory1.subtract(inventory2);
         */
        public LetterInventory subtract(LetterInventory other) {
            LetterInventory a = new LetterInventory();
            for(int i = 0; i<26; i++){
                a.set((char)(i+97),this.counts[i] - other.counts[i]);
                if(a.counts[i]<0){
                    return null;
                }
            }
            return a;
    }
    
        //helper method: checks if the input is a valid letter
        private void letterCheck(char letter){
            if(letter > 122 || letter<97){
                throw new IllegalArgumentException();
            }
        }
    }
    

