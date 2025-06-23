import java.util.*;

// Custom class to hold element and its frequency
class FreqNumber implements Comparable<FreqNumber> {
    int element;  // The number from the array
    int freq;     // Its frequency

    // Constructor to initialize the object
    FreqNumber(int element, int freq) {
        this.element = element;
        this.freq = freq;
    }

    // Define how to compare FreqNumber objects for max heap
    @Override
    public int compareTo(FreqNumber that) {
        // Reverse order to create Max Heap based on frequency
        return that.freq - this.freq;
    }
}

public class Solution {

    // Main method to return top k frequent elements
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // If not in map, default to 0; add 1 to the count
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a max heap (priority queue) to store elements by frequency
        PriorityQueue<FreqNumber> pq = new PriorityQueue<>();

        // Step 3: Convert each map entry to a FreqNumber and insert into the heap
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            FreqNumber number = new FreqNumber(entry.getKey(), entry.getValue());
            pq.offer(number);
        }

        // Step 4: Poll top k elements from the heap
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().element;
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        int[] topK = sol.topKFrequent(nums, k);

        System.out.println("Top " + k + " frequent elements: " + Arrays.toString(topK));
    }
}
