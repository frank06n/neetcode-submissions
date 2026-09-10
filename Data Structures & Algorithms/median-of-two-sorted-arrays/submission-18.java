class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A,B;
        if (nums1.length>nums2.length)
        {B=nums1; A=nums2;}
        else
        {B=nums2; A=nums1;}

        int tot = A.length+B.length;
        int half = (tot+1)/2;

        // if (A.length==0) 
        //     return tot%2==0 ? (B[tot/2-1]+B[tot/2])/2.0 : B[tot/2];

        // // check pattern - A then B or B then A
        // boolean atb = A[A.length-1] <= B[0], bta = B[B.length-1] <= A[0];
        // if (atb || bta)
        // {
        //     if (tot%2==1) return atb ? B[tot/2-A.length] : B[tot/2];
        //     if (A.length == B.length)
        //     {
        //         int sum = atb ? (A[A.length-1] + B[0]) : (B[B.length-1] + A[0]);
        //         return sum/2.0;
        //     }
        //     int ix = atb ? (half-A.length-1) : tot/2-1;
        //     int sum = B[ix] + B[ix+1];
        //     return sum/2.0;
        // }

        int l=0, r=A.length, m=0,n=0;
        while (l<=r)
        {
            m = (l+r)/2;
            n = half-m;

            // System.out.printf("M:%d N:%d Am:%d Bn:%d\n",m,n,A[m],B[n]);

            // if (m==0 || m==A.length || n==0 || n==B.length) break;

            if (m > 0 && n < B.length && A[m-1] > B[n])
                r = m-1; // m decrease
            else if (n > 0 && m < A.length && A[m] < B[n-1])
                l = m+1; // m increase
            else
                break;
            
        }
        System.out.printf("xx M:%d N:%d Am:%d Bn:%d\n",m,n,tot,0);

        if (m==0)
        {
            if (tot%2==1) return B[tot/2];
            //A[0] > B[n-1]
            if (A.length>0 && n==B.length) return (A[0] + B[n-1])/2.0;
            return (B[tot/2-1]+B[tot/2])/2.0;
        }
        else if (n==0)
        {
            if (tot%2==1) return A[tot/2];
            //B[0] > A[m-1]
            if (B.length>0 && m==A.length) return (B[0] + A[m-1])/2.0;
            return (A[tot/2-1]+A[tot/2])/2.0;
        }

        int x = Math.max(A[m-1], B[n-1]);
        int y = (n == B.length) ?
                A[m] :
                (m == A.length) ?
                B[n] :
                Math.min(A[m], B[n]);
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