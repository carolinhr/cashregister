package machine;

import food.Apple;
import food.Sandwich;
import transactions.Payment;

    public class Register {

        private static int registerCounter = 0;
        private static final String REGISTERCODE = "US-FL-032020-";
        private static final double DOLLARVALUE = 1.00;
        private static final double QUARTERVALUE = 0.25;
        private static final double DIMEVALUE = 0.10;
        private static final double NICKELVALUE = 0.05;
        private static final double PENNYVALUE = 0.01;

        //----------------------------------------------------------
        String registerID;
        int numberOfOneDollarBills;
        int numberOfQuarters;
        int numberOfDimes;
        int numberOfNickels;
        int numberOfPennies;
        double currentTotal;


        public Register(int numberOfOneDollarBills,
                        int numberOfQuarters,
                        int numberOfDimes,
                        int numberOfNickels,
                        int numberOfPennies) {

            registerCounter++;

            // set registerID to REGISTERCODE + registerCounter
            registerID = REGISTERCODE + registerCounter;


            currentTotal = 0.0;

            this.numberOfOneDollarBills = numberOfOneDollarBills;
            this.numberOfQuarters = numberOfQuarters;
            this.numberOfDimes = numberOfDimes;
            this.numberOfNickels = numberOfNickels;
            this.numberOfPennies = numberOfPennies;
        }

        private double cashValue() {

            double total = numberOfOneDollarBills * DOLLARVALUE +
                    numberOfQuarters * QUARTERVALUE +
                    numberOfDimes * DIMEVALUE +
                    numberOfNickels * NICKELVALUE +
                    numberOfPennies * PENNYVALUE;

            return total;
        }

        public void cashInfo(String personal) {
            if (personal.equals("Manager")) {
                System.out.println("==========================================");
                System.out.println("Register Cash Info");
                System.out.println("==========================================");
                System.out.println("Access Level:\t\t\t\t Valid");
                System.out.printf("Cash in the Register:\t\t $%-15.2f\n", cashValue());
                System.out.printf("Dollars:\t\t\t\t\t %-15d\n", numberOfOneDollarBills);
                System.out.printf("Quarters:\t\t\t\t\t %-15d\n", numberOfQuarters);
                System.out.printf("Dimes:\t\t\t\t\t\t %-15d\n", numberOfDimes);
                System.out.printf("Nickels:\t\t\t\t\t %-15d\n", numberOfNickels);
                System.out.printf("Pennies:\t\t\t\t\t %-15d\n", numberOfPennies);
                System.out.printf("\n");
                System.out.printf("\n");
            } else {
                System.out.println("==========================================");
                System.out.println("Register Cash Info");
                System.out.println("==========================================");
                System.out.println("Access Level:\t\t\t\t Not Valid by " + personal);
                System.out.println();
            }
        }

        private void giveChange(double price, Payment payment) {
            numberOfOneDollarBills += payment.getNumberOfOneDollarBills();
            numberOfQuarters += payment.getNumberOfQuarters();
            numberOfDimes += payment.getNumberOfDimes();
            numberOfNickels += payment.getNumberOfNickels();
            numberOfPennies += payment.getNumberOfPennies();

            double neededChange = payment.paymentValue() - price;

            int neededChangeWhole = (int) Math.round(neededChange * 100);
            System.out.printf("Needed Change:\t\t\t\t $%-15.2f\n", neededChange);

            int CDollar = neededChangeWhole / 100;
            neededChangeWhole -= CDollar * 100;

            // figure out the quarters to give back
            int CQuarter = neededChangeWhole / 25;

            // update the remaining change to give back
            neededChangeWhole -= CQuarter * 25;

            // figure out the dimes to give back
            int CDime = neededChangeWhole / 10;

            // update the remaining change to give back
            neededChangeWhole -= CDime * 10;

            // figure out the nickels to give back
            int CNickel = neededChangeWhole / 5;

            // update the remaining change to give back
            neededChangeWhole -= CNickel * 5;

            // figure out the pennies to give back
            int CPenny = neededChangeWhole;


            // give the change back
            // remove the dollars, quarters, dimes, nickels, pennies
            // from the register
            numberOfOneDollarBills -= CDollar;
            numberOfQuarters -= CQuarter;
            numberOfDimes -= CDime;
            numberOfNickels -= CNickel;
            numberOfPennies -= CPenny;

            // output to the console the change:
            // dollars, quarters, dimes, nickels, pennies

            System.out.printf("Dollars:\t\t\t\t\t %-15d\n", CDollar);
            System.out.printf("Quarters:\t\t\t\t\t %-15d\n", CQuarter);
            System.out.printf("Dimes:\t\t\t\t\t\t %-15d\n", CDime);
            System.out.printf("Nickels:\t\t\t\t\t %-15d\n", CNickel);
            System.out.printf("Pennies:\t\t\t\t\t %-15d\n", CPenny);
            System.out.printf("\n");


        }

        public void buyApple(Apple apple, Payment payment) {
            System.out.println("==========================================");
            System.out.println("Register Buy Apple");
            System.out.println("==========================================");
            System.out.printf("Apple Price:\t\t\t\t $%-15.2f\n", apple.price());
            System.out.printf("Payment:\t\t\t\t\t $%-15.2f\n", payment.paymentValue());
            if (payment.paymentValue() < apple.price()) {
                System.out.printf("You need:\t\t\t\t\t $%-15.2f\n", apple.price() - payment.paymentValue());
                System.out.println("");
                System.out.println("Sorry but you do not have enough money to buy the Apple");
                System.out.println("==========================================");
                System.out.printf("\n");
            } else {
                giveChange(0.47, payment);
            }
        }


        public void buySandwich(Sandwich sandwich, Payment payment) {
            System.out.println("==========================================");
            System.out.println("Register Buy Sandwich");
            System.out.println("==========================================");
            System.out.printf("Sandwich Price:\t\t\t\t $%-15.2f\n", sandwich.getPrice());
            System.out.printf("Payment:\t\t\t\t\t $%-15.2f\n", payment.paymentValue());
            if (payment.paymentValue() < sandwich.getPrice()) {
                System.out.printf("You need: \t\t\t\t\t $%-15.2f\n", sandwich.getPrice() - payment.paymentValue());
                System.out.println(" ");
                System.out.println("Sorry but you do not have enough money to buy the Sandwich");
                System.out.println("==========================================");
                System.out.println("\n");
            } else {
                giveChange(sandwich.getPrice(), payment);
            }

            }
        }



