class checkAccount {
public static void main(String[] args){
    System.out.println("This is a checkpoint");
    Account Kathy = new Account(500);
    Account Megan = new Account(100,Kathy);
    Megan.withdraw(700);
    System.out.println(Megan.getBalance());
    System.out.println(Kathy.getBalance());
  }
}
