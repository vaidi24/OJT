import java.util.ArrayList;
//import java.util.List;

public class Bank {
   public static ArrayList<Customer> customers=new ArrayList<>();
   public static ArrayList<Account> accounts=new ArrayList<>();
   public static ArrayList<Transaction> transactions=new ArrayList<>();
    static void createCustomer(){
       String name=IO.readln("Enter your name : ");
       String dob=IO.readln("Enter your BirthDate : ");
       String Mobilenum=IO.readln("Enter your Mobile number : ");
       String Address=IO.readln("Enter your Address : ");
       String Pan=IO.readln("Enter your Pancard number : ");
       
       Customer newCustomer= new Customer(name,dob,Mobilenum,Address,Pan);
       customers.add(newCustomer) ;
       int custid=customers.size();
       newCustomer.strCustID=Mobilenum+custid;
       IO.println("\n\n Customer created successfully \nCustomer ID : "+newCustomer.strCustID+"\nName : "+name+"\nBirth date : "+dob+"\nMobile number : "+Mobilenum+"\nAddress : "+Address+"\nPan card number : "+Pan+"\n");
   }
   static void viewcustomer(){
        String custid=IO.readln("Enter your customer ID:");
        for(Customer c:customers){
            if(c.strCustID.equals(custid)){
                c.viewdetails();
                return;
            }
        }
        IO.println("Customer not found / Invalid customer ID\n");
   }
   static void customerModule(){
      String choice = IO.readln("Customer MENU \n1. Create Customer \n2. View Customer \n3. exit\nEnter your choice : ");
      switch (choice) {
        case "1":
            createCustomer();
            break;
        case "2":
            viewcustomer();
            break;
        case "3":
            System.exit(0);
        default:
            IO.print("invalid input");
            break;
      }
   }

   //account
   static void createAccount(){
        String custid=IO.readln("Enter your customer ID : ");
        for(Customer c:customers){
                if(c.strCustID.equals(custid)){
                String accType=IO.readln("Enter Account type (current / saving / fix) : ");
                Account newAccount=new Account(custid, accType);
                accounts.add(newAccount);
                newAccount.strAccID=String.valueOf(accounts.size());
                IO.println(" Account created successfully \nCustomer ID : "+custid+"\nAccount ID : "+newAccount.strAccID+"\nAccount type : "+accType+"\n");
                break;
                }
                else{
                    IO.println("Invalid customer ID");
                }
        }
    }
    static void viewAccount(){
       String accid=IO.readln("Enter your Account ID : ");
       for(Account a:accounts){
            if(a.strAccID.equals(accid)){
                IO.println(" Account created successfully \nCustomer ID : "+a.strCustID+"\nAccount ID : "+a.strAccID+"\nAccount type : "+a.strAcctype+"\nBalance : "+a.balance+"\n");
            }
        }
    }   
      
   static void accountModule(){
     String choice = IO.readln("Account MENU \n1. Create Account \n2. View Account details \n3. Deposit \n4. Withdraw \n5.Transfer \n6. exit\nEnter your choice : ");
     switch (choice) {
        case "1":
            createAccount(); 
            break;
        case "2":
            String accid=IO.readln("Enter your Account ID : ");
            for(Account a:Bank.accounts){
                if(a.strAccID.equals(accid)){
                   a.viewdetails();;
                }
                return;
            }
            IO.println("Account not found . \n");
            break;
        case "3":
            accid=IO.readln("Enter your Account ID : ");
            for(Account a:Bank.accounts){
                if(a.strAccID.equals(accid)){
                   a.deposit();
                }
                return;
            }
            IO.println("Account not found . \n");
            break;
        case "4":
            accid=IO.readln("Enter your Account ID : ");
            for(Account a:Bank.accounts){
                if(a.strAccID.equals(accid)){
                   a.withdraw();                  
                }
                return;

            }
            IO.println("Account not found . \n");
            break;
        case "5":
            accid=IO.readln("Enter your Account ID : ");
            for(Account a:Bank.accounts){
                if(a.strAccID.equals(accid)){
                    a.transfer();
                    return;
                }
            }
            IO.println("Account not found !");
            break;
        case "6":
            System.exit(0);
        default:
            break;
     }
   }
   //transaction
   static void transactionmodule(){
    String choice=IO.readln("\n\nTransaction module\n 1.Get full transaction history\n 2.Get credited transactions\n 3.Get debited transactions\nEnter you choice: ");
    switch(choice){
        case "1":
            String accid=IO.readln("Enter your Account ID : ");
            for(Account a:Bank.accounts){
                if(a.strAccID.equals(accid)){
                    for(Transaction t: Bank.transactions){
                        if(a.strAccID.equals(t.strAccID)){
                            IO.println("\nAccount ID: "+t.strAccID+" Transaction ID: "+t.strTransID+"  Transaction Type: "+t.strTransType+" Amount: "+t.amount+"\n");
                        }
                    }
                    return;
                }
            }
            IO.println("Account not found !");
            break;
        case "2":
            accid=IO.readln("Enter your Account ID : ");
                for(Account a:Bank.accounts){
                    if(a.strAccID.equals(accid)){
                        for(Transaction t: Bank.transactions){
                            if(a.strAccID.equals(t.strAccID) && t.strTransType.equalsIgnoreCase("credited")){
                                IO.println("\nAccount ID: "+t.strAccID+" Transaction ID: "+t.strTransID+"  Transaction Type: "+t.strTransType+" Amount: "+t.amount+"\n");
                            }
                        }
                        return;
                    }
                }
                IO.println("Account not found !");
                break;
        case "3":
            accid=IO.readln("Enter your Account ID : ");
            for(Account a:Bank.accounts){
                if(a.strAccID.equals(accid)){
                    for(Transaction t: Bank.transactions){
                        if(a.strAccID.equals(t.strAccID) && t.strTransType.equalsIgnoreCase("debited")){
                            IO.println("\nAccount ID: "+t.strAccID+" Transaction ID: "+t.strTransID+"  Transaction Type: "+t.strTransType+" Amount: "+t.amount+"\n"); // remove this and add function !!!!!!
                        }
                    }
                    return;
                }
            }
            IO.println("Account not found !");
            break;
        case "4":
            System.exit(0); 
        default:
            break;       
    }
   }
    public static void main(String[] args) {
        IO.println("welcome to bank management system ");
        while (true) {
          String choice = IO.readln("MAIN MENU \n1. Customer module \n2. Account module \n3.transaction module \n4. exit\nEnter your choice : ");
            switch (choice) {
                case "1":
                    customerModule();
                    break;
                case "2":
                    accountModule();
                    break;
                case "3":
                    transactionmodule();
                case "4":
                    System.exit(0);
                    break;
                default:
                    IO.println("Invalid choice");
                    break;
            }
        }
    }
}
