public class ModNCounter extends Counter{
	int mod;
	public ModNCounter(int Mod){
	super();
	this.mod = Mod;
	}
	public int value(){
	return this.myCount%mod;	
}
}
