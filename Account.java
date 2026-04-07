public class Account {
    String strAccID;
    String strCustID;
    String strAccnum;
    String strAcctype;
    float balance;
    
    public Account(String custID,String Acctype){
        this.strCustID=custID;
        this.strAcctype=Acctype;
        
    }
    public void viewdetails(){
         IO.println(" Account Details \nCustomer ID : "+strCustID+"\nAccount ID : "+strAccID+"\nAccount Number : "+strAccnum+"\nAccount type : "+strAcctype+"\nBalance :"+balance+"\n");
    }

    public void deposit(){
        String amt=IO.readln("Enter your Amount to deposit : ");  
        Float amount=Float.parseFloat(amt);
        balance+=amount;
        IO.println(amt+" deposited in Acc "+strAccID+"\n");  
        Transaction newTransaction= new Transaction(strAccID,"credited" , balance);
        Bank.transactions.add(newTransaction);
        newTransaction.strTransID=String.valueOf(Bank.transactions.size());
        newTransaction.strTransaction_ref=String.valueOf(Bank.transactions.size());
    }

    public void withdraw(){
        String amt=IO.readln("Enter your Amount to withdraw : ");  
        Float amount=Float.parseFloat(amt);
        if(balance>=amount){
        balance-=amount;
        IO.println(amount+" withdrawn from Acc "+strAccID+"\n");
        Transaction newTransaction= new Transaction(strAccID,"debited" , balance);
        Bank.transactions.add(newTransaction);
        newTransaction.strTransID=String.valueOf(Bank.transactions.size());
        newTransaction.strTransaction_ref=String.valueOf(Bank.transactions.size());
        }
        else{
            IO.println("Insuffienct balance !!");
        }
    }
    
    public void transfer(){
        String toAccid=IO.readln("Enter Account ID to tranfer :");
                for(Account b:Bank.accounts){
                    if(b.strAccID.equals(toAccid)){
                        String amt=IO.readln("Enter your Amount to transfer : ");  
                        Float amount=Float.parseFloat(amt);
                        if(balance>=amount){
                        balance-=amount;
                        b.balance+=amount;

                        Transaction newTransaction= new Transaction(strAccID,"credited" , balance);
                        Bank.transactions.add(newTransaction);
                        newTransaction.strTransID=String.valueOf(Bank.transactions.size());
                        newTransaction.strTransaction_ref=String.valueOf(Bank.transactions.size());

                        Transaction newTransaction2= new Transaction(strAccID,"debited" , balance);
                        newTransaction2.strTransID=String.valueOf(Bank.transactions.size());
                        newTransaction2.strTransaction_ref=newTransaction.strTransaction_ref;
                        return;
                        }
                        else{
                            IO.println("Insuffient balance to transfer \n");
                            return;
                        }
                    }
                    
                }
                IO.println("Account not found . \n");
                return;
            }
            
        
        
 }
