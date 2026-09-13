class MedianFinder {
    int length;
    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    public MedianFinder() {
        length = 0;
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if (minPq.isEmpty())
        {
            minPq.offer(num);
            length++;
            // System.out.println("addNum: " + num + ", sz= " + minPq.size() + ", L= " + length);
            return;
        }

        if (num > minPq.peek())
        {
            minPq.offer(num);
            length++;
            // System.out.println("addNum: " + num + " -> min, L= " + length);
            while (minPq.size() > 1+length/2) {
                // System.out.println(".. min.size: " + minPq.size());
                // System.out.println(".. max <- min: " + minPq.peek());
                maxPq.offer(minPq.poll());
            }
        }
        else
        {
            maxPq.offer(num);
            length++;
            // System.out.println("addNum: " + num + " -> max, L= " + length);
            while (minPq.size() < 1+length/2) {
                // System.out.println(".. min.size: " + minPq.size());
                // System.out.println(".. max -> min: " + maxPq.peek());
                minPq.offer(maxPq.poll());
            }
        }
    }
    
    public double findMedian() {
        // System.out.println("findMedian: L= " + length + ", min= " + minPq.peek());

        if (length%2 == 1) return minPq.peek();
        int a = minPq.poll();
        double ans = (a + minPq.peek())/2.0;
        minPq.offer(a);
        return ans;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */