class Twitter {
    class Tweet implements Comparable<Tweet> {
        int id;
        int time;
        Tweet prev;

        Tweet(int id, int time, Tweet prev)
        {
            this.id = id;
            this.time = time;
            this.prev = prev;
        }

        @Override
        public int compareTo(Tweet other) {
            // Null safety check
            if (other == null) {
                throw new NullPointerException("Cannot compare with null");
            }

            // Safe comparison (avoids integer overflow)
            return Integer.compare(this.time, other.time);
        }
    }

    HashMap<Integer, Set<Integer>> followingsOf;
    HashMap<Integer, Tweet> lastTwtOf;
    int time;
    
    public Twitter() {
        followingsOf = new HashMap<>();
        lastTwtOf = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet lastTwt = lastTwtOf.get(userId);

        Tweet twt = new Tweet(tweetId, time, lastTwt);
        time++;

        lastTwtOf.put(userId, twt);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            Collections.reverseOrder()
        );
        List<Integer> feed = new ArrayList<>();

        if (lastTwtOf.containsKey(userId)) {
            pq.offer(lastTwtOf.get(userId));
        }
        if (followingsOf.containsKey(userId))
        {
            for (Integer user : followingsOf.get(userId))
            {
                Tweet lastTwt = lastTwtOf.get(user);
                if (lastTwt == null) continue;
                pq.offer(lastTwt);
            }
        }

        while (feed.size()<10 && !pq.isEmpty())
        {
            Tweet lastTwt = pq.poll();
            feed.add(lastTwt.id);
            if (lastTwt.prev != null) pq.offer(lastTwt.prev);
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> fset = followingsOf.get(followerId);
        if (fset == null) {
            fset = new HashSet<>();
            followingsOf.put(followerId, fset);
        }
        fset.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> fset = followingsOf.get(followerId);
        if (fset != null) fset.remove(followeeId);
    }
}
