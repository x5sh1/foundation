class complete{

	public boolean isComplete(treeNode node){
		if(node == null){
			return true;
		}
		Stack<node> stack = new Stack<>();
		stack.push(node);
		boolean isNull = false;
		while(!stack.isEmpty()){
			treeNode temp = stack.pop();
			if(isNull && temp != null){
				return false;
			}
			if(temp == null){
				isNull = true;
			}else{
				stack.push(temp.left);
				stack.push(temp.right);
			}
		}	
		return true;
	}
}