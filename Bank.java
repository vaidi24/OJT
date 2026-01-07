import java.util.Scanner;
class Customer{
public String name;
public int age,mnumber;
public int balance=0;
public static int i=0;
Customer(String name,int age,int mnumber)
{
    
    this.name=name;
    this.age=age;
    this.mnumber=mnumber;
    
}

}
public class Bank {
    static void createacc{
            int i=0;
            int totalacc=100;
            Customer[] customer=new Customer[totalacc];
            Scanner scanner =new Scanner(System.in);
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
            System.out.println("Account created successfully for "+name+"!!\n Remember your Account number is \n\n"+i);
            i++;                                                                 //incrementing array index 
        }
    public static void main(String[] args)
    {   
         
        Scanner scanner =new Scanner(System.in);
        
        System.out.println("Welcome to Bank Applicaton");
        
        int choice,i=0;
        do{
          System.out.println("Main menu \n 1. Create Account \n 2. Deposit \n 3. Withdraw \n 4. Check Balance \n 5. Exit \nEnter your choice:-");
          choice=scanner.nextInt();
          if(choice==1)
            {
            createacc();
           }
        }while(choice!=5);
      
        scanner.close();
    }
}
