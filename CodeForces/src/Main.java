import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws Exception{
        File file = new File("D:\\!Works\\Java\\_JavaProjects_GitHub\\CodeForces\\src\\input");
        Scanner in = new Scanner(file);

        int n, k, i, j;

        n = in.nextInt();
        k = in.nextInt();

        String s = in.next();
        int[][] cc = new int['z' + 1][4 * 10^5 + 1];   // cc - count char
        int[] ci = new int['z' + 1];

        for(i = 0; i < s.length(); i++){
            cc[s.charAt(i)][ci[s.charAt(i)]] = i;
            ci[s.charAt(i)]++;
        }

        while()


    }
}

/*


    256 MB = 256 * 1024 * 1024 B = ‭268,435,456‬ B
    ‭268,435,456‬ B = ‭67,108,864‬ ints
    ‭67,108,864‬ = 67 * 10^6

    4 * 10^5 + 1 = 4 * 100000 + 1 = 400001
    123 * 400001 = ‭49,200,123‬

    Save indices of all character occurences
    [123][4 * 10^5 + 1]                                       123 = 'z' + 1;
 */