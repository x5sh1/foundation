class heap{
	// constractor
	int[] nums;
	int pointer = 0;
	int cap;
	public heap(int cap){
		this.nums = new int[cap];
		this.cap = cap;
	}	

	// swap element up to appropriate position
	public void swim(int index){
		// judge the index is left or right child
		int parent;
		while(index >= 0){
			// if the index is even, it is right child
			if(index % 2 == 0){
				parent = (index - 2) / 2;
			}else{	// if the index is odd, it is left child
				parent = (index - 1) / 2;
			}
			// because it is min heap, if child is greater than parent then swap them
			if(nums[index] < nums[parent]){
				int temp = nums[index];
				nums[index] = nums[parent];
				nums[parent] = temp;
				// follow that number nums[index]
				index = parent;
			}else{
				return;
			}
		}
	}

	// swap element down to appropriate position
	public void sink(int index){
		// find two children
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int mini;
		while(index < cap){
			// the index has no children
			if(left >= cap){
				return;
			}
			// the index has two children
			if(right < cap){
				if(nums[left] > nums[right]){
					mini = right;
				}else{
					mini = left;
				}
			}else{
				mini = left;
			}
			if(nums[index] > nums[mini]){
				int temp = nums[index];
				nums[index] = nums[mini];
				nums[mini] = temp;
				// keep up with the number
				index = mini;
			}
		}
	}

	// insert
	public void insert(int num){
		nums[pointer] = num;
		swim(pointer);
		pointer++;
	}

	// update
	public void update(int oldIndex, int newV){
		nums[oldIndex] = newV;
		sink(oldIndex);
		swim(oldIndex);
	}

	// top
	public int top(){
		return nums[0];
	}

	// pop
	public int pop(){
		int result = nums[0];
		nums[0] = nums[pointer - 1];
		nums[pointer - 1] = 0;
		sink(0);
		pointer--;
		return result;
	}

	// is empty
	public boolean isEmpty(){
		return pointer == 0;
	}
}