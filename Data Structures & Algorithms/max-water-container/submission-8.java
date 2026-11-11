class Solution {
    public int maxArea(int[] heights) {
        // Arrays.sort(heights);
        int n = heights.length;
        int left = 0;
        int right = n-1;
        int width=0, height=0, curr_area=0;
        int maxarea = Integer.MIN_VALUE;

        while(left<right)
        {
            height = Math.min(heights[left],heights[right]);
            width = right - left;
            curr_area = height * width;
            maxarea = Math.max(maxarea , curr_area);
            System.out.println(curr_area);
            if(heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return maxarea;
    }
}
