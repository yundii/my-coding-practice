// 11. Container With Most Water
// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

// Constraints
// 1. the range of height, can the height be negative number?
// 2. the range of size n, can n less than 2?

// edge cases
// 1. heights are all 0
// 2. all heights are the same

// basic idea
// to find the max area: (j-i) * min(hight[i], hight[j]) 
// use two pointers, start from the max distance, each time calculate the current area, update the max area then move pointer.
// how to move pointer: move the smaller line, we potentially find a more taller line to store more water

public class Container {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        int currArea;
        while (left < right) {
            if (height[left] < height[right]) {
                currArea = (right-left) * height[left];
                left++;
            }else {
                currArea = (right-left) * height[right];
                right--;
            }
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Container solution = new Container();
        // case 1
        int[] height1 = new int[]{0, 0, 0, 0};
        System.out.println(solution.maxArea(height1));

        // case 2
        int[] height2 = new int[]{0, 2, 3, 6};
        System.out.println(solution.maxArea(height2));

        // case 3 
        int[] height3 = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(height3));
    }
    
}
