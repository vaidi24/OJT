import java.util.Scanner;
class Customer{
public String name;
public int age;
public long mnumber;
public int balance=0;
public String[] transaction=new String[100];

public int j=0;
Customer(String name,int age,long mnumber)
{
    
    this.name=name;
    this.age=age;
    this.mnumber=mnumber;
  
}

}
public class Bank {
   public static int i =0;
   public static Scanner scanner =new Scanner(System.in);
   static Customer[] customer=new Customer[100];

    static void createacc(){
        //int totalacc=100;
           System.out.println("Fill the detail to create you account \n Name:");  //name input
            String name=scanner.next();
            System.out.println("Age:");                                            //age input
            int age=scanner.nextInt();
            if(age<18){
               System.out.println(name+" your age is invalid . Age must be above 18 !");
               System.out.println("Age:");
               age=scanner.nextInt();
            }
            System.out.println("Mobile number:");                             //num input
            int mnumber=scanner.nextInt();
            customer[i]=new Customer(name, age, mnumber);                         //making object of customer[]
            System.out.println("Account created successfully for "+name+"!!\n Remember your Account number is "+i+"\n\n");
            i++;   
        }
    static void deposit(){
        System.out.println("Enter account number:");
        int accno=scanner.nextInt();
        System.out.println("Enter amount to deposit:");
        int amount=scanner.nextInt();
        customer[accno].balance+=amount;
        String transaction="Amount "+amount+" deposited successfully in account number "+accno+" Name "+customer[accno].name;
        System.out.println(transaction);
        add_transaction(accno, transaction);
        System.out.println("updated balance is "+customer[accno].balance);

    }
    static void withdraw(){
       System.out.println("Enter account number:");
        int accno=scanner.nextInt();
        System.out.println("Enter amount to withdraw:");
        int amount=scanner.nextInt();
        customer[accno].balance-=amount;
        String transaction="Amount "+amount+" withdraw successfully from account number "+accno+" Name "+customer[accno].name;
        System.out.println(transaction);
        add_transaction(accno, transaction);
       // System.out.println("Amount "+amount+" withdraw successfully from account number "+accno+" Name "+customer[accno].name); 
        System.out.println("updated balance is "+customer[accno].balance);
    }
    static void checkbalance(){
        System.out.println("Enter account number:");
        int accno=scanner.nextInt();
        System.out.println("Your current balance is "+customer[accno].balance);
    }
    static void transfer(){
        System.out.println("Enter your account number:");
        int accno1=scanner.nextInt();
        System.out.println("Enter amount to transfer:");
        int amount=scanner.nextInt();
        System.out.println("Enter receiver account number:");
        int accno2=scanner.nextInt();
        customer[accno1].balance-=amount;
        customer[accno2].balance+=amount;
        String transaction="Amount "+amount+" transferred successfully from account number "+accno1+" Name "+customer[accno1].name+"\n to account number "+accno2+" Name "+customer[accno2].name;
        System.out.println(transaction); 
        add_transaction(accno1, transaction);
        add_transaction(accno2, transaction);

        System.out.println("Your updated balance is "+customer[accno1].balance);
    }
    static void add_transaction(int accno,String transaction)
    {
        customer[accno].transaction[customer[accno].j]=transaction;
        customer[accno].j++;

    }
    static void show_transaction()
    {
        System.out.println("Enter account number:");
        int accno=scanner.nextInt();
        int n=0;
        System.out.println("Transaction history of Account number "+accno);
        while(n!=customer[accno].j)
        {
          System.out.println(customer[accno].transaction[n]);
          n++;
        }
    }
    public static void main(String[] args)
    {   
         
        Scanner scanner =new Scanner(System.in);
        
        System.out.println("Welcome to Bank Applicaton");
        
        int choice;
        
        do{

          System.out.println("Main menu \n 1. Create Account \n 2. Deposit \n 3. Withdraw \n 4. Check Balance \n 5. Transfer \n 6. Show transaction history \n 7. Exit \nEnter your choice:-");
          choice=scanner.nextInt();
          if(choice==1)
            {
                createacc();                                                         
           }
           else if(choice==2)
           {
               deposit();
           }
           else if(choice==3)
           {
               withdraw();
           }
           else if(choice==4)
           {
               checkbalance();
           }
          else if(choice==5)
           {
               transfer();
           }
           else if(choice==6)
           {
            show_transaction();
           }
          
        }while(choice!=7);
      
        scanner.close();
    }
}
