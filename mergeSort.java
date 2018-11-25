class mergeSort{
	public static void merge(int[] nums, int left, int midl, int midr, int right){
		int length = right - left + 1;
		int[] result = new int[length];
		int pointer1 = left;
		int pointer2 = midr;
		int index = 0;
		while(pointer1 <= midl && pointer2 <= right){
			if(nums[pointer1] <= nums[pointer2]){
				result[index] = nums[pointer1];
				pointer1++;
			}else{
				result[index] = nums[pointer2];
				pointer2++;
			}
			index++;
		}
		int start = pointer1;
		int end = midl;
		if(start > end){
			start = pointer2;
			end = right;
		}
		for(int i = start; i <= end; i++){
			result[index] = nums[i];
			index++;
		}
		for(int i = 0; i < length; i++){
			nums[i  + left] = result[i];
		}
	}

	public static void sort(int[] nums, int left, int right){
		if(left >= right){
			return;
		}
		int mid = left + (right - left) / 2;
		sort(nums, left, mid);
		sort(nums, mid + 1, right);
		merge(nums, left, mid, mid + 1, right);
	}

	public static void main(String[] args){
		int[] a = {5,10,15,6,1,2,9,8,7,14,12,11,13,3,4};
		sort(a, 0 , a.length - 1);
		for(int num:a){
			System.out.print(num + " ");
		}
		System.out.println();
	}
}