class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        s = s.toLowerCase();
        while (i<j) {
            char a=s.charAt(i), b=s.charAt(j);
            if (!Character.isLetterOrDigit(a)) i++;
            else if (!Character.isLetterOrDigit(b)) j--;
            else if (a!=b) {System.gc();return false;}
            else {i++;j--;}
        }
        System.gc();
        return true;
    }
}
