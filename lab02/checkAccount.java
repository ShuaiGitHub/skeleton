public class checkAccount {

  public static void main(String[] args){
    Account Kathy(500);
    Account Megan(100,Kathy);
    Megan.withdraw(120);
    System.out.println(Megan.getBalance());
    System.out.println(Kathy.getBalance());
  }
}
