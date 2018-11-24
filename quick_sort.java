class quick_sort{
	public static void q_sort(int[] nums, int left, int right){
		if(left >= right){
			return;
		}
		//partition
		int pivot = nums[left];
		int pointer = left;
		for(int i = left; i <= right; i++){
			if(nums[i] <= pivot){
				int temp = nums[pointer];
				nums[pointer] = nums[i];
				nums[i] = temp;
				pointer++;
			}
		}
		pointer--;
		int temp = nums[pointer];
		nums[pointer] = nums[left];
		nums[left] = temp;
		//sort
		q_sort(nums, left, pointer - 1);
		q_sort(nums, pointer + 1, right);
	}

	public static void main(String[] args){
		int[] a = {4,2,5,1,7,8,3,9,11,10,15,14,12,13,16};
		q_sort(a, 0, a.length - 1);
		for(int num:a){
			System.out.print(num + " ");
		}
		System.out.println();
	}
}