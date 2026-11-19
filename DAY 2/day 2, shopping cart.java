
import java.util.function.Predicate;

class ShoppingCart {

    public static void main(String[] args) {

        String name = "Rahul";
        int age = 20;
        double price = 2500;

        // Predicate to check age eligibility
        Predicate<Integer> eligibility = a -> a >= 18;

        System.out.println("Customer Name: " + name);
        System.out.println("Customer Age: " + age);
        System.out.println("Product Price: " + price);

        // Check eligibility and place order
        if (eligibility.test(age)) {
            System.out.println("You are eligible to place the order.");
            System.out.println("Order placed successfully!");
            System.out.println("Total Amount: " + price);
        } else {
            System.out.println("You are not eligible to place the order.");
        }
    }
}
