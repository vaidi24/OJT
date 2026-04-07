public class Transaction {
    String strTransID;
    String strAccID;
    String strTransType;
    float amount;
    String strTransaction_ref;

    Transaction(String strAccID,String strTransType,float amount){
        this.strAccID=strAccID;
        this.strTransType=strTransType;
        this.amount=amount;
        
    }
    
    // public void get_transaction_history(){
    //     String accid=IO.readln("Enter your Account ID : ");
    //         for(Account a:Bank.accounts){
    //             if(a.strAccID.equals(accid)){
    //                 for(Transaction t: Bank.transactions){
    //                     if(a.strAccID.equals(t.strAccID)){
    //                         IO.println("\nAccount ID: "+t.strAccID+" Transaction ID: "+t.strTransID+"  Transaction Type: "+t.strTransType+" Amount: "+t.amount+"\n");
    //                     }
    //                 }
    //                 return;
    //             }
    //         }
    //         IO.println("Account not found !");
    // }

    // public void get_credited_transaction(){
    //         String accid=IO.readln("Enter your Account ID : ");
    //             for(Account a:Bank.accounts){
    //                 if(a.strAccID.equals(accid)){
    //                     for(Transaction t: Bank.transactions){
    //                         if(a.strAccID.equals(t.strAccID) && t.strTransType.equalsIgnoreCase("credited")){
    //                             IO.println("\nAccount ID: "+t.strAccID+" Transaction ID: "+t.strTransID+"  Transaction Type: "+t.strTransType+" Amount: "+t.amount+"\n");
    //                         }
    //                     }
    //                     return;
    //                 }
    //             }
    //             IO.println("Account not found !");
    //     }

    //  public void get_debited_transaction(){
    //     String accid=IO.readln("Enter your Account ID : ");
    //         for(Account a:Bank.accounts){
    //             if(a.strAccID.equals(accid)){
    //                 for(Transaction t: Bank.transactions){
    //                     if(a.strAccID.equals(t.strAccID) && t.strTransType.equalsIgnoreCase("debited")){
    //                         IO.println("\nAccount ID: "+t.strAccID+" Transaction ID: "+t.strTransID+"  Transaction Type: "+t.strTransType+" Amount: "+t.amount+"\n");
    //                     }
    //                 }
    //                 return;
    //             }
    //         }
    //         IO.println("Account not found !");
    // }

    
}
