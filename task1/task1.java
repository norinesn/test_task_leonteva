
class task1 {
	public static void main(String args[]){
		int n = Integer.parseInt(args[0]);
    	int m = Integer.parseInt(args[1]);
		int circle[] = new int[n];
		for(int i = 0; i < n; i++){
			circle[i] = i + 1; //заполняем массив
		}
	int current = 0;
    System.out.print("Path: ");
    do {
        System.out.print(circle[current]);
        current = (current + m - 1) % n;
    } while (current != 0);
	System.out.println("");
}
}





