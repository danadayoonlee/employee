// Fig. 10.14: PayableInterfaceTest.java
// Payable interface test program processing Invoices and 
// Employees polymorphically.
package payable;

public class PayableInterfaceTest {
   public static void main(String[] args) {
	   Payable payable1; // = new Payable();
	   Invoice invoice1 = new Invoice("01234", "seat", 2, 375.00);
	   Invoice invoice2 = new Invoice("43210", "tire", 4, 500.00);
	   
	   SalariedEmployee salariedEmployee1 = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
	   HourlyEmployee hourlyEmployee1 = new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
	   CommissionEmployee commissionEmployee1 = new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, 0.6);
	   BasePlusCommissionEmployee basePlusCommissionEmployee1 = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, 0.4, 300);

	   // Interface polymorphism
	   payable1 = invoice1;
	   System.out.println(payable1);
	   System.out.println(payable1.getPaymentAmount()+"\n");
	   
	   payable1 = invoice2;
	   System.out.println(payable1);
	   System.out.println(payable1.getPaymentAmount()+"\n");
	   
	   payable1 = salariedEmployee1;
	   System.out.println(payable1);
	   System.out.println(payable1.getPaymentAmount()+"\n");
	   
	   payable1 = hourlyEmployee1;
	   System.out.println(payable1);
	   System.out.println(payable1.getPaymentAmount()+"\n");
	   
	   payable1 = commissionEmployee1;
	   System.out.println(payable1);
	   System.out.println(payable1.getPaymentAmount()+"\n");
	   
	   payable1 = basePlusCommissionEmployee1;
	   System.out.println(payable1);
	   System.out.println(payable1.getPaymentAmount()+"\n");
	   
      // create Payable array
      Payable[] payableObjects = new Payable[] {
         new Invoice("01234", "seat", 2, 375.00),
         new Invoice("43210", "tire", 4, 500.00),
         new SalariedEmployee("Lisa", "Barnes", "444-44-4444", 1200.00),         
         new HourlyEmployee("Alex", "Jones", "555-55-5555", 20.20, 40),
         new CommissionEmployee("Owen", "Cole", "666-66-6666", 5000, 0.2),
         new BasePlusCommissionEmployee("David", "Palmer", "777-77-7777", 3000, 0.1, 200)      
      };

      System.out.println(
         "Invoices and Employees processed polymorphically:"); 

      // generically process each element in array payableObjects
      for (Payable currentPayable : payableObjects) {
         // output currentPayable and its appropriate payment amount
         System.out.printf("%n%s ", 
            currentPayable.toString()); // could invoke implicitly
         
         if (currentPayable instanceof BasePlusCommissionEmployee) {
             // downcast Employee reference to 
             // BasePlusCommissionEmployee reference
             BasePlusCommissionEmployee employee = 
                (BasePlusCommissionEmployee) currentPayable;

             employee.setBaseSalary(1.10 * employee.getBaseSalary());

             System.out.printf(
                "\n**new base salary with 10%% increase is: $%,.2f**%n",
                employee.getBaseSalary());
          }
         
         if (currentPayable instanceof HourlyEmployee) {
             // downcast Employee reference to 
             // BasePlusCommissionEmployee reference
        	 HourlyEmployee employee = 
                (HourlyEmployee) currentPayable;

             employee.setWage(2 + employee.getWage());

             System.out.printf(
                "\n**new hourly wage with $2 increase is: $%,.2f**%n",
                employee.getWage());
          }
         
         System.out.printf(
                 "%npayment due: $%,.2f%n", currentPayable.getPaymentAmount());
      } 
   } 
}