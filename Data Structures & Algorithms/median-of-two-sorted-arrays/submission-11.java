class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A,B;
        if (nums1.length>nums2.length)
        {B=nums1; A=nums2;}
        else
        {B=nums2; A=nums1;}

        int tot = A.length+B.length;
        int half = (tot+1)/2;

        if (A.length==0) 
            return tot%2==0 ? (B[tot/2-1]+B[tot/2])/2.0 : B[tot/2];

        // check pattern - A then B or B then A
        boolean atb = A[A.length-1] < B[0], bta = B[B.length-1] < A[0];
        if (atb || bta)
        {
            if (tot%2==1) return atb ? B[half-A.length] : B[tot/2];
            if (A.length == B.length)
            {
                int sum = atb ? (A[A.length-1] + B[0]) : (B[B.length-1] + A[0]);
                return sum/2.0;
            }
            int ix = atb ? (half-A.length-1) : tot/2-1;
            int sum = B[ix] + B[ix+1];
            return sum/2.0;
        }

        int l=0, r=A.length-1, m=0,n=0;
        while (l<=r)
        {
            m = (l+r)/2;
            n = half-(m+1)-1;

            // System.out.printf("M:%d N:%d Am:%d Bn:%d\n",m,n,A[m],B[n]);

            if (n+1 < B.length && A[m] > B[n+1])
                r = m-1; // m decrease
            else if (m+1 < A.length && A[m+1] < B[n])
                l = m+1; // m increase
            else
                break;
            
        }
        // System.out.printf("xx M:%d N:%d Am:%d Bn:%d\n",m,n,A[m],B[n]);

        int x = Math.max(A[m], B[n]);
        int y = (n+1 == B.length) ?
                A[m+1] :
                (m+1 == A.length) ?
                B[n+1] :
                Math.min(A[m+1], B[n+1]);
        if (tot%2==0)
        {
            return (x + y)/2.0;
        }
        else
        {
            return x;
        }
    }
}