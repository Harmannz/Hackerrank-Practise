import java.util.*;

public class Solution {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    
    public Solution(String magazine, String note) {
        // create a hash map of word counts for magazine and note
        this.magazineMap = new HashMap<>();
        this.noteMap = new HashMap<>(); 
        setup(magazine, note);
    }
    

    private void setup(String magazine, String note) {
        String key;
        int count;
        String[] magazineWords = magazine.split(" ");
        String[] noteWords = note.split(" ");
    
        for(int i = 0; i < magazineWords.length; i++){
            key = magazineWords[i];
            count = this.magazineMap.containsKey(key) ? this.magazineMap.get(key) : 0;
            this.magazineMap.put(magazineWords[i], ++count);
        }
        for(int i = 0; i < noteWords.length; i++){
            key = noteWords[i];
            count = this.noteMap.containsKey(key) ? this.noteMap.get(key) : 0;
            this.noteMap.put(noteWords[i], ++count);
        }
    }
    
    public boolean solve() {
        // for each entry in notemap, see if value of magazinemap is >= if so then return true otherwise false        
        for(Map.Entry<String, Integer> entry : noteMap.entrySet()){
            if(!magazineMap.containsKey(entry.getKey()) ||  magazineMap.get(entry.getKey()) < entry.getValue()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
