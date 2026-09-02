package in.bhavanishankar.trappingRain;

public class Solution {

    public int[] getForwardMaxArray(int[] height){
        int[] maxHeightArr = new int[height.length];
        maxHeightArr[0] = -1;
        for (int i=1; i<height.length;++i) {
            maxHeightArr[i] = Math.max(maxHeightArr[i-1],Math.max(height[i-1],height[i]));
        }

        return maxHeightArr;
    }

    public int[] getReverseMaxArray(int[] height){
        int[] maxHeightArr = new int[height.length];
        maxHeightArr[height.length-1] = -1;
        for (int i=height.length-2; i>=0;--i) {
            maxHeightArr[i] = Math.max(maxHeightArr[i+1],Math.max(height[i+1],height[i]));
        }

        return maxHeightArr;
    }

    public int trap(int[] height) {
        int[] forwardMax = getForwardMaxArray(height);
        int[] reverseMax = getReverseMaxArray(height);

        int trappedWater = 0;
        for (int i=1;i<height.length-1;++i) {
            trappedWater += (Math.min(forwardMax[i],reverseMax[i]))-height[i];
        }

        return trappedWater;
    }
}