// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer, Integer> freq = new HashMap();
//         for (int n : nums)
//         freq.put(n, freq.getOrDefault(n, 0)+1);
        
//         Set<Integer> keyset = freq.keySet();
//         int out[] = new int[k];
//         while (k>0) {
//             Integer[] keys = new Integer[keyset.size()];
//             keyset.toArray(keys);
//             out[k-1] = keys[0];
//             for (int j=1; j<keys.length; j++) {
//                 if (freq.get(keys[j]) > freq.get(out[k-1]))
//                 out[k-1] = keys[j];
//             }
//             keyset.remove(out[k-1]);
//             k--;
//         }
//         return out;
//     }
// }
//=============================================
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> freq = new HashMap<>();
//         for (int n : nums) {
//             freq.put(n, freq.getOrDefault(n, 0) + 1);
//         }
//         PriorityQueue<Integer> heap = new PriorityQueue<>(
//             (a, b) -> freq.get(a) - freq.get(b)
//         );
//         for (int num : freq.keySet()) {
//             heap.add(num);
//             if (heap.size() > k) {
//                 heap.poll();
//             }
//         }
//         int[] res = new int[k];
//         for (int i = 0; i < k; i++) {
//             res[i] = heap.poll();
//         }
//         return res;
//     }
// }
//=============================================

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : freq.keySet()) {
            int f = freq.get(num);
            if (bucket[f] == null) bucket[f] = new ArrayList<>();
            bucket[f].add(num);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = bucket.length - 1; i >= 0 && idx < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    res[idx++] = num;
                    if (idx == k) break;
                }
            }
        }

        return res;
    }
}