class stringHandle{
	// cahr removal
	public String charRemoval(String str, char removeC){
		// two pointer.
		int length = str.length();
		int slow = 0;
		int fast = 0;
		// count the number of target char
		int counter = 0;
		if(length == 0){
			return "";
		}
		char[] charArr = str.toCharArray();
		for(; fast < length; fast++){
			if(charArr[fast] != removeC){
				charArr[slow] = charArr[fast];
				slow++;
				counter++;
			}
		}
		String result = "";
		for(int index = 0; index < counter; index++){
			result += String.valueOf(charArr[index]);
		}
		return result;
	}

	// remove duplicated space ___a_b_c__
	public String spaceRemoval(String str){
		if(str.length() == 0){
			return null;
		}
		int slow = 0;
		int fast = 0;
		boolean first = false;
		char[] charArr = str.toCharArray();
		while(true){
			if(fast == str.length()){
				break;
			}
			// skip all space before word
			while(fast < str.length() && charArr[fast] == ' '){
				fast++;
			}
			if(first){
				// if the word is not the first, sperate it with others
				charArr[slow] = ' ';
				slow++;
			}
			while(fast < str.length() && charArr[fast] != ' '){
				charArr[slow] = charArr[fast];
				slow++;
				fast++;
			}
			first = true;
		}
		String res = "";
		for(int index = 0; index < slow; index++){
			res += String.valueOf(charArr[index]);
		}
		return res;
	}

	// replacement student - > stuXXt, stuXXt -> student
	public String replacement(String str, String s1, String s2){
		int s1L = s1.length();
		int s2L = s2.length();
		// reduce the length of str
		char[] arrs = str.toCharArray();
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		if(s1L > s2L){
			int slow = 0;
			int fast = 0;

			for(; fast < arrs.length; fast++){
				// partten is found
				if(helper(arr1, arrs, fast)){
					int len = arr2.length;
					int counter = 0;
					int temp = fast;
					while(counter < len){
						arrs[temp] = arr2[counter];
						arrs[slow] = arrs[temp];
						slow++;
						temp++;
						counter++;
					}
					fast += s1L - 1;
				}else{
					arrs[slow] = arrs[fast];
					slow++;
				}
			}
				String res = "";
				for(int index = 0; index < slow; index++){
					res += String.valueOf(arrs[index]);
				}
				return res;
		
		}
		return "";
	}

	public boolean helper(char[] target, char[] str, int start){
		if(target.length > str.length - start){
			return false;
		}
		for(int index = 0; index < target.length; index++){
			if(target[index] != str[start]){
				return false;
			}
			start++;
		}
		return true;
	}

	// reversal, abc -> cba
	public String reversal(String str){
		if(str.length() == 0){
			return str;
		}
		int left = 0;
		int right = str.length() - 1;
		char[] arr = str.toCharArray();
		while(left <= right){
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		String result = "";
		for(int index = 0; index < str.length(); index++){
			result += String.valueOf(arr[index]);
		}
		return result;
	}

	// reversal a sentence. go get it - > it get go
	public String reSentence(String str){
		String res = "";
		int left = 0;
		for(int index = 0; index < str.length(); index++){
			if(str.charAt(index) == ' '){
				res += reversal(str.substring(left, index)) + " ";
				left = index + 1;
			}
		}
		res += reversal(str.substring(left, str.length()));
		return reversal(res);
	}

	// string shuffling A1B2C3D4 -> ABCD1234
	public String shuff(String str){
		if(str.length() == 0){
			return str;
		}
		if(str.length() == 1){
			return str;
		}
		int length = str.length();
		int amountOfChunk = length / 2;
		int mid = amountOfChunk / 2 * 2;
		char[] left = shuff(str.substring(0, mid)).toCharArray();
		char[] right = shuff(str.substring(mid, length)).toCharArray();
		String result = "";
		// merge left and right. alphabet > digit. Then return result.
	}

	// string shuffling ABCD1234.
	// seperate str into 4 chunks, 0, 1, 2, 3, then revers C1 and C2
	

	public static void main(String[] args){
		stringHandle t = new stringHandle();
		String res = t.reSentence("go get it");
		System.out.println(res);
	}
}