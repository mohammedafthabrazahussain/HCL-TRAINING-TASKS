
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {

    interface Welcome {
        void showMessage();
    }

    interface GST {
        double getGST(double price);
    }

    interface Bill {
        double getTotal(double price, int qty);
    }

    interface Discount {
        double getDiscount(double amount);
    }

    interface FinalAmount {
        double getFinal(double amount);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Welcome msg = () -> System.out.println("Welcome to Online Shopping!");
        msg.showMessage();

        System.out.print("Enter item price: ");
        double price = input.nextDouble();

        System.out.print("Enter item quantity: ");
        int qty = input.nextInt();

        GST tax = p -> p * 10 / 100;
        double gst = tax.getGST(price);

        Bill total = (p, q) -> p * q;
        double billAmount = total.getTotal(price, qty);

        Discount offer = a -> a * 10 / 100;
        double discount = offer.getDiscount(billAmount);

        FinalAmount result = a -> {
            double reducedAmount = offer.getDiscount(a);
            return a - reducedAmount;
        };

        double payable = result.getFinal(billAmount);

        List<Double> amounts = Arrays.asList(
            gst, billAmount, discount, payable
        );

        System.out.println("\nShopping Bill Details:");

        amounts.stream().forEach(a ->
            System.out.println(a)
        );

        System.out.println("\nGST Amount: " + gst);
        System.out.println("Total Bill Amount: " + billAmount);
        System.out.println("Discount Amount: " + discount);
        System.out.println("Final Payable Amount: " + payable);

        input.close();
    }
}
