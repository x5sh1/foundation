class apowb{
	public int pow(int a, int b){
		// base case
		if(b == 0){
			return 1;
		}
		// rule
		int half = pow(a, b / 2);
		if(b % 2 == 0){
			return half * half;
		}else{
			return half * half * a;
		}
	}
	public static void main(String[] args){
		apowb t = new apowb();
		int a = 2;
		int b = 9;
		System.out.println(t.pow(a, b));
	}
}