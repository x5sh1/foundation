class bitM{
	// determain a string has duplicated char
	public boolean isDup(String str) {
		int len = str.length();
		if(len <= 1) {
			return true;
		}
		// use 8 integer to repersent 256 bits
		// each bit represents a ascii code
		int[] map = new int[8];
		for(int index = 0; index < len; index++) {
			int temp = Integer.valueOf(str.charAt(index));
			int row = temp / 32;
			int col = temp % 32;
			// check the bit is 1 or 0
			// if the bit is 1, it means that the char appears
			// before
			if(((map[row] >> col) & 1) == 1) {
				return false;
			}else{
				// mark that bit to 1
				map[row] |= 1 << col;
			}
		}
		return true;
	}

	// reverse all bits of a number
	public int reverse(int a) {
		// a integer is 32 bits, then use two pointers
		int i = 0;
		int j = 31;
		int num = a;
		while(i <= j){
			// check if bits which at i and j are same or not
			if(((num >> i) & 1) != ((num >> j) & 1)) {
				num ^= 1 << i;
				num ^= 1 << j;
			}
			i++;
			j--;
		}
		return num;
	}

	public static void main(String[] args) {
		bitM t = new bitM();
		System.out.println(t.reverse(256));
	}
}