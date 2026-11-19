
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> p = a -> a >= 75;

        System.out.println(p.test(95));
        System.out.println(p.test(45));
    }
}
