class Twitter {
    class Tweet implements Comparable<Tweet> {
        int id;
        int time;

        Tweet(int id, int time)
        {
            this.id = id;
            this.time = time;
        }
        @Override
        public int hashCode() {
            return id;
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
    HashMap<Integer, List<Tweet>> tweetsOf;
    int time;
    
    public Twitter() {
        followingsOf = new HashMap<>();
        tweetsOf = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(tweetId, time);
        time++;

        List<Tweet> twts = tweetsOf.get(userId);
        if (twts == null) {
            twts = new ArrayList<>();
            tweetsOf.put(userId, twts);
        }
        twts.add(t);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        if (tweetsOf.containsKey(userId)) {
            List<Tweet> utwts = tweetsOf.get(userId);
            for (int i=utwts.size()-1; i>=0 && i>=utwts.size()-10; i--)
                pq.offer(utwts.get(i));
        }

        if (followingsOf.containsKey(userId)) {
            for (Integer followee : followingsOf.get(userId))
            {
                if (!tweetsOf.containsKey(followee)) continue;

                List<Tweet> utwts = tweetsOf.get(followee);
                for (int i=utwts.size()-1; i>=0 && i>=utwts.size()-10; i--)
                {
                    pq.offer(utwts.get(i));
                    if (pq.size() > 10) pq.poll();
                }
            }
        }

        List<Integer> feed = new ArrayList<>();
        while (!pq.isEmpty()) feed.add(0, pq.poll().id);
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
