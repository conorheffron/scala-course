package specmethods

class BankAccount(private var mBalance:Int) {
  def deposit(amount:Int):Unit = {
    require(amount>=0, "Can't make negative deposit.")
    // Logging here
    mBalance += amount
  }

  def withdraw(amount:Int):Unit = {
    require(amount>=0, "Can't make negative withdrawl.")
    require(amount<=mBalance, "Can't withdraw more money than you have.")
    // Logging here
    mBalance -= amount
  }
  
  def balance = mBalance
  
  def balance_=(amount:Int):Unit = {
    if(amount<balance) withdraw(balance-amount)
    else deposit(amount-balance)
  }
}

object NotBankAccount extends App {
  val account = new BankAccount(0)
  println(account.balance)
  account.balance = 100
}