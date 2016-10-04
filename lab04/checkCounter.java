public class checkCounter{
	public static void main (String args[]) {
	ModNCounter a = new ModNCounter(4);
	a.increment();
	a.increment();
	a.increment();
	System.out.println(a.value());
}
}
