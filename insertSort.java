class insertSort{
	public static void sort(int[] nums){
		if(nums == null){
			return;
		}
		int length = nums.length;
		for(int i = 1; i < length; i++){
			int key = nums[i];
			int j = i;
			while(j - 1 >= 0 && nums[j - 1] > key){
				nums[j] = nums[j - 1];
				nums[j - 1] = key;
				j--;
			}
		}
	}

	public static void main(String[] args){
		int[] a = {11,15,10,4,2,6,5,1,7,9,8,3,13,12,14};
		sort(a);
		for(int num:a){
			System.out.print(num + " ");
		}
		System.out.println();
	}
}