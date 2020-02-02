import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int times = in.nextInt();

        while(times > 0){
            if(num % 10 > 0) {num--;}
            else {num /= 10;}

            times--;
        }

        System.out.print(num);
    }
}