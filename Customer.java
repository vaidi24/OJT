//import java.time.*;
public class Customer {
   String strCustID;
   String strName;
   String strdob;
   String strMobilenum;
   String strAddress;
   String strPan;

   Customer(String Name, String dob, String Mobilenum,String Address,String Pan){
    
      this.strName=Name;
      this.strdob=dob;
      this.strMobilenum=Mobilenum;
      this.strAddress=Address;
      this.strPan=Pan;

   }
   
   public void viewdetails(){
      IO.println("\n\nCustomer Details \nCustomer ID : "+strCustID+"\nName : "+strName+"\nBirth date : "+strdob+"\nMobile number"+strMobilenum+"\nAddress : "+strAddress+"\nPan card number : "+strPan+"\n");
   }
   
}
