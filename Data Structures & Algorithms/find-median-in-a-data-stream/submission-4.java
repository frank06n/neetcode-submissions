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
            return;
        }

        if (num > minPq.peek())
        {
            minPq.offer(num);
            length++;
            while (minPq.size() > (1+length)/2) {
                maxPq.offer(minPq.poll());
            }
        }
        else
        {
            maxPq.offer(num);
            length++;
            while (minPq.size() < (1+length)/2) {
                minPq.offer(maxPq.poll());
            }
        }
    }
    
    public double findMedian() {
        if (length%2 == 1) return minPq.peek();
        return (minPq.peek() + maxPq.peek())/2.0;
    }
}
