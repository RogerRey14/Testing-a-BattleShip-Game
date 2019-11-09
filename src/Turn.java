public class Turn {
	private int num;
	
	public Turn() {
		num = 0;
	}

	public void next() {
		num = notCurrent();
	}

	public int current() {
		return num;
	}

	public int notCurrent() {
		return (num+1)%2;
	}

}
