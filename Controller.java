
package app;
import food.Sandwich;
import machine.Register;
import food.Apple;
import transactions.Payment;

public class Controller {

    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("COP 2210 - Project 1 Output");
        System.out.println("Carolin Heredia");
        System.out.println("6237318");
        System.out.println("U02 ");
        System.out.println("===============================================");
        System.out.println("\n");

        // create a Register
        Register register = new Register(15, 20, 10, 20, 50);

        // check register cash as a "Manager"
        // call the cashInfo method on the register object with input "Manager"
        register.cashInfo("Manager");

        // check register cash as a "Staff"
        // call the cashInfo method on the register object with input "Staff"
        register.cashInfo("Staff");


// create an Apple variable named grannySmith with
// type = "Granny Smith"
// weight = 140
// pricePreUnitWeight = 1.51. <- this is the correct numbers
        Apple grannySmith = new Apple("Granny Smith", 1.51, 140);
        grannySmith.displayInfo();
        Payment applePayment1 = new Payment(10, 0, 0, 0, 47);
        applePayment1.displayInfo();
        register.buyApple(grannySmith, applePayment1);

        register.cashInfo("Manager");

        Apple macintosh = new Apple("Macintosh", 1.70, 150);
        macintosh.displayInfo();
        Payment applePayment2 = new Payment(0, 2, 0, 0, 0);
        applePayment2.displayInfo();
        register.buyApple(macintosh, applePayment2);
        register.cashInfo("Manager");

        Sandwich sandwich = new Sandwich(true, true, true);
        sandwich.displayInfo();
        Payment sandwichPayment1 = new Payment(5, 2, 1, 1, 2);
        sandwichPayment1.displayInfo();
        register.buySandwich(sandwich, sandwichPayment1);
        register.cashInfo("Manager");

        //Payment SAMEPAYMENT = new Payment(10,0,0,0,0);

        boolean meat = true;
        boolean cheese = true;
        boolean veggies = true;

        System.out.println("");

        for (int i = 0; i <= 7; i++) {
            //Sandwich finalSandwich = new Sandwich(meat, cheese, veggies);

            if (i <= 3) {
                meat = true;
            } else {
                meat = false;
            }
            //if (i % 2 == 0) {
            if(i == 2 || i == 3 || i == 6 || i == 7) {
                    cheese = false;
            } else {
                cheese = true;
            }
            if (i % 2 == 0) {
                veggies = true;
            } else {
                veggies = false;
            }
                Sandwich finalSandwich = new Sandwich(meat, cheese, veggies);
                finalSandwich.displayInfo();
                Payment finalPayment = new Payment(10, 0, 0, 0, 0);
                finalPayment.displayInfo();
                register.buySandwich(finalSandwich, finalPayment);
                register.cashInfo("Manager");

        }
    }
}

