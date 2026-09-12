class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n==0) return tasks.length;

        int freq[] = new int[26];
        int lu[] = new int[26];

        for (char task : tasks)
            freq[task - 'A'] += 1;
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
            (a,b) -> freq[b] - freq[a]
        );

        for (int i=0; i<26; i++)
            if (freq[i] > 0)
                pq.offer(i);

        Queue<Integer> hold = new ArrayDeque<Integer>(n+1);

        int z=0;
        while (pq.size() > 0 || hold.size() > 0)
        {
            int i = hold.size() > 0 ? hold.peek() : -1;
            int j = pq.size() > 0 ? pq.peek() : -1;

            // head of "hold" queue != -1 AND
            // it has passed cooldown time AND
            // pq head NOT takes priority, since pq head freq less
            if (
                (i!=-1) &&
                (z-lu[i] >= n) &&
                (j==-1 || freq[i] > freq[j])
            )
            {
                // System.out.print( "h_" +(char)('A'+i) + " ");
                hold.poll();
                freq[i]--;
                lu[i] = ++z;
                if (freq[i] > 0) hold.offer(i);
            }
            else if (j!=-1)
            {
                // System.out.print( "p_" +(char)('A'+j) + " ");
                pq.poll();
                freq[j]--;
                lu[j] = ++z;
                if (freq[j] > 0) hold.offer(j);
            }
            else
            {
                // System.out.print( "i_ ");
                z++;
            }
        }

        return z;
    }
}
