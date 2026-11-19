
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        String otp = IntStream.generate(() -> (int)(Math.random() * 10))
                .limit(4)
                .mapToObj(num -> String.valueOf(num))
                .collect(Collectors.joining());

        System.out.println("OTP: " + otp);
    }
}
