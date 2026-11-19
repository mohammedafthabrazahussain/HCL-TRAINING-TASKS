
public class Main {
    public static void main(String[] args) {

        int[] salary = {30000, 45000, 60000, 75000, 40000};

        System.out.println("Employees earning more than 50000:");

        for (int i = 0; i < salary.length; i++) {
            if (salary[i] > 50000) {
                System.out.println(salary[i]);
            }
        }
    }
}
