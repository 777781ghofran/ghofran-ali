import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AllExercises {

    public static void main(String[] args) {
        // Exercise 1: Pseudorandom Numbers
        System.out.println("Exercise 1: Pseudorandom Numbers");
        int a = 12, b = 5, n = 100, cur = 92;
        for (int i = 0; i < 5; i++) {
            cur = (a * cur + b) % n;
            System.out.println(cur);
        }

        // Exercise 2: Remove Random Entries
        System.out.println("\nExercise 2: Remove Random Entries");
        int[] array = {1, 2, 3, 4, 5};
        removeRandomEntries(array);

        // Exercise 3: Caesar Cipher for Other Languages (Explanation)
        System.out.println("\nExercise 3: Caesar Cipher for Other Languages");
        System.out.println("To adapt the Caesar cipher for non-English alphabets, modify the character set and ensure the shift respects the alphabet size.");

        // Exercise 4: TicTacToe Flaw Fix (Explanation)
        System.out.println("\nExercise 4: TicTacToe Flaw Fix");
        System.out.println("Modify the putMark method to check if the game is already won before placing a mark, and throw IllegalStateException if so.");

        // Exercise 5: Shallow vs Deep Equality
        System.out.println("\nExercise 5: Shallow vs Deep Equality");
        System.out.println("Shallow equality checks if references are the same. Deep equality checks if contents are the same.");
        System.out.println("For 2D arrays, shallow equality checks references of sub-arrays, while deep equality checks all elements.");

        // Exercise 6: Array Copy Examples
        System.out.println("\nExercise 6: Array Copy Examples");
        int[] original = {1, 2, 3, 4, 5};
        int[] backup1 = original.clone();
        int[] backup2 = Arrays.copyOf(original, original.length);
        int[] backup3 = new int[original.length];
        System.arraycopy(original, 0, backup3, 0, original.length);
        System.out.println("Backup1: " + Arrays.toString(backup1));
        System.out.println("Backup2: " + Arrays.toString(backup2));
        System.out.println("Backup3: " + Arrays.toString(backup3));

        // Exercise 7: Find Repeated Element
        System.out.println("\nExercise 7: Find Repeated Element");
        int[] A = {1, 2, 3, 4, 2};
        System.out.println("Repeated element: " + findRepeatedElement(A));

        // Exercise 8: Find Five Repeated Elements
        System.out.println("\nExercise 8: Find Five Repeated Elements");
        int[] B = {1, 2, 3, 4, 5, 6, 2, 3, 4, 5, 6};
        System.out.println("Repeated elements: " + Arrays.toString(findFiveRepeatedElements(B)));

        // Exercise 9: Scoreboard Add and Remove
        System.out.println("\nExercise 9: Scoreboard Add and Remove");
        Scoreboard scoreboard = new Scoreboard(5);
        scoreboard.add(new GameEntry("Alice", 100));
        scoreboard.add(new GameEntry("Bob", 200));
        scoreboard.remove(0);
        System.out.println("Scoreboard: " + scoreboard);

        // Exercise 10: Non-Random Looking Values
        System.out.println("\nExercise 10: Non-Random Looking Values");
        System.out.println("For a=1, b=0, n=1000, the sequence will not look random.");

        // Exercise 11: Product of Array Elements
        System.out.println("\nExercise 11: Product of Array Elements");
        int[] randomArray = new int[100];
        Random r = new Random();
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = r.nextInt(10);
        }
        long product = 1;
        for (int num : randomArray) {
            product *= num;
        }
        System.out.println("Product of array elements: " + product);

        // Exercise 12: Shuffle Array
        System.out.println("\nExercise 12: Shuffle Array");
        int[] shuffleArray = {1, 2, 3, 4, 5};
        shuffle(shuffleArray);
        System.out.println("Shuffled array: " + Arrays.toString(shuffleArray));

        // Exercise 13: Multiplayer Game Tracking
        System.out.println("\nExercise 13: Multiplayer Game Tracking");
        System.out.println("Use a 2D array or adjacency matrix to track meetings and determine the winner.");

        // Exercise 14: Add 3D Arrays
        System.out.println("\nExercise 14: Add 3D Arrays");
        int[][][] array1 = {{{1, 2}, {3, 4}}, {{5, 6}, {7, 8}}};
        int[][][] array2 = {{{9, 8}, {7, 6}}, {{5, 4}, {3, 2}}};
        int[][][] result = addThreeDimensionalArrays(array1, array2);
        System.out.println("Result of 3D array addition: " + Arrays.deepToString(result));
    }

    // Exercise 2: Remove Random Entries
    public static void removeRandomEntries(int[] array) {
        Random random = new Random();
        while (array.length > 0) {
            int index = random.nextInt(array.length);
            System.out.println("Removed: " + array[index]);
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array = Arrays.copyOf(array, array.length - 1);
        }
    }

    // Exercise 7: Find Repeated Element
    public static int findRepeatedElement(int[] A) {
        Set<Integer> distinctElements = new HashSet<>();
        for (int num : A) {
            if (distinctElements.contains(num)) {
                return num;
            }
            distinctElements.add(num);
        }
        return -1; // No repeated element found
    }

    // Exercise 8: Find Five Repeated Elements
    public static int[] findFiveRepeatedElements(int[] B) {
        Set<Integer> distinctElements = new HashSet<>();
        int[] repeatedElements = new int[5];
        int count = 0;
        for (int num : B) {
            if (distinctElements.contains(num)) {
                repeatedElements[count++] = num;
                if (count == 5) break;
            }
            distinctElements.add(num);
        }
        return repeatedElements;
    }

    // Exercise 9: Scoreboard Class
    static class Scoreboard {
        private GameEntry[] board;
        private int numEntries;

        public Scoreboard(int capacity) {
            board = new GameEntry[capacity];
        }

        public void add(GameEntry e) {
            if (numEntries < board.length) {
                board[numEntries++] = e;
            }
        }

        public GameEntry remove(int i) {
            if (i < 0 || i >= numEntries) {
                throw new IndexOutOfBoundsException("Invalid index: " + i);
            }
            GameEntry temp = board[i];
            board[i] = board[numEntries - 1];
            board[numEntries - 1] = null;
            numEntries--;
            return temp;
        }

        @Override
        public String toString() {
            return Arrays.toString(board);
        }
    }

    static class GameEntry {
        private String name;
        private int score;

        public GameEntry(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + ": " + score;
        }
    }

    // Exercise 12: Shuffle Array
    public static void shuffle(int[] A) {
        Random random = new Random();
        for (int i = A.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    // Exercise 14: Add 3D Arrays
    public static int[][][] addThreeDimensionalArrays(int[][][] array1, int[][][] array2) {
        if (array1.length != array2.length || array1[0].length != array2[0].length || array1[0][0].length != array2[0][0].length) {
            throw new IllegalArgumentException("Arrays must have the same dimensions");
        }
        int[][][] result = new int[array1.length][array1[0].length][array1[0][0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < result[0][0].length; k++) {
                    result[i][j][k] = array1[i][j][k] + array2[i][j][k];
                }
            }
        }
        return result;
    }
}