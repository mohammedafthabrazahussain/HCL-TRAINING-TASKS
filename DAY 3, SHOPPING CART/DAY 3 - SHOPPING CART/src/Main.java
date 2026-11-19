
import java.util.Scanner;

public class Main {

    interface Welcome {
        void display();
    }

    interface GST {
        double calculate(double price);
    }

    interface Bill {
        double calculate(double price, int quantity);
    }

    interface Discount {
        double calculate(double amount);
    }

    interface FinalAmount {
        double calculate(double amount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Welcome w = () -> System.out.println("Welcome to Shopping Application!");
        w.display();

        System.out.print("Enter product price: ");
        double price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        GST gst = p -> p * 0.10;
        double gstAmount = gst.calculate(price);
        System.out.println("GST Amount (10%): " + gstAmount);

        Bill bill = (p, q) -> p * q;
        double totalBill = bill.calculate(price, quantity);
        System.out.println("Total Bill: " + totalBill);

        Discount discount = amount -> amount * 0.10;
        double discountAmount = discount.calculate(totalBill);
        System.out.println("Discount (10%): " + discountAmount);

        FinalAmount finalAmount = amount -> {
            double discountValue = discount.calculate(amount);
            double payable = amount - discountValue;
            return payable;
        };

        double finalBill = finalAmount.calculate(totalBill);
        System.out.println("Final Payable Amount: " + finalBill);

        sc.close();
    }
}
