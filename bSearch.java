class bSearch{
	public int binary_search(int target, int[] nums){
		int left = 0;
		int right = nums.length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] > target){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return - 1;
	}

	public static void main(String[] args){
		bSearch t = new bSearch();
		int target = 0;
		int[] nums = {};
		System.out.println(t.binary_search(target, nums));
	}
}