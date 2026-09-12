class Twitter {
    class Tweet {
        int id;
        int uid;
        Tweet prev;

        Tweet(int id, int uid, Tweet prev)
        {
            this.id = id;
            this.uid = uid;
            this.prev = prev;
        }
        boolean visibleTo(int uid)
        {
            if (this.uid == uid) return true;
            Set<Integer> fset = followersOf.get(this.uid);
            return fset != null && fset.contains(uid);
        }
    }

    HashMap<Integer, Set<Integer>> followersOf;
    Tweet tail;
    
    public Twitter() {
        tail = null;
        followersOf = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet t = new Tweet(tweetId, userId, tail);
        tail = t;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        Tweet twt = tail;
        while (twt != null)
        {
            if (twt.visibleTo(userId)) feed.add(twt.id);
            twt = twt.prev;
            if (feed.size() == 10) break;
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> fset = followersOf.get(followeeId);
        if (fset == null) {
            fset = new HashSet<>();
            followersOf.put(followeeId, fset);
        }
        fset.add(followerId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> fset = followersOf.get(followeeId);
        if (fset != null) fset.remove(followerId);
    }
}
