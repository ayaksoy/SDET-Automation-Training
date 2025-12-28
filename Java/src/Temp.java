import java.util.Scanner;

public class Temp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        String separator = scan.next();
        int count = scan.nextInt();
        //Write your code here

        for (int i = 1; i <= count; i++) // i = 1 / i = 2 /i = 3/i = 4/ i = 5/i = 6
            if (i == count)
                System.out.print(word);
            else
                System.out.print(word + separator);
    }
}