class closest{
	public int find(int target, int[] nums){
		if(nums.length == 0){
			return -1;
		}
		int left = 0;
		int right = nums.length - 1;
		while(left < right - 1){
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){
				return target;
			}else if(nums[mid] > target){
				right = mid;
			}else{
				left = mid;
			}
		}
		if(Math.abs(target - nums[left]) > Math.abs(target - nums[right])){
			return nums[right];
		}else{
			return nums[left];
		}
	}
}