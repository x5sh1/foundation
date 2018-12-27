class bSearch2D{
	public String binary_search(int target, int[][] matrix){
		if(matrix == null){
			return "null";
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int length = row * col;
		int left = 0;
		int right = length - 1;
		while(left <= right){
			int mid = left + (right - left) / 2;
			// project 1 demension to 2 demension
			int i = mid / col;
			int j = mid % col;
			if(matrix[i][j] == target){
				return i + ", " + j;
			}else if(matrix[i][j] > target){
				right = mid - 1;
			}else{
				left = mid + 1;
			}
		}
		return "No target";
	}

	public static void main(String[] args){
		bSearch2D t = new bSearch2D();
		int target = 0;
		int[][] matrix = {
							{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12},
							{13,14,15,16}};
		System.out.println(t.binary_search(target, matrix));
	}
}