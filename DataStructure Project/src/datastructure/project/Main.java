
package datastructure.project;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        grocery store = new grocery("zed grocery");
        System.out.println("-------------------------------------------------");
        System.out.println(".    zed store is happy to be visited by you    .");
        int choice = 0;
        do {
            try {
                System.out.println("-------------------------------------------------");
                System.out.println(".                our services                   .");
                System.out.println(".  1. Display items                             .");
                System.out.println(".  2. Add items                                 .");
                System.out.println(".  3. Remove items                              .");
                System.out.println(".  4. orders Queue                              .");
                System.out.println(".  5. get next order                            .");
                System.out.println(".  6. current order                             .");
                System.out.println(".  7. Exit                                      .");
                System.out.println("-------------------------------------------------");

                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        store.displayItems();
                        break;
                    case 2:
                        store.addItems();
                        break;
                    case 3:
                        store.removeItem();
                        break;
                    case 4:
                        store.OrdersQueue();
                        break;
                    case 5:
                        store.getNextOrder();
                        break;
                    case 6:
                        store.currentOrder();
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
                System.out.println();

            } catch (InputMismatchException ex) {
                System.err.println("Invalid input");
                input.next();
            }
        } while (choice != 7);

        System.err.println("  thank you   ");
        System.err.println("<3 good bye <3");
    }

}