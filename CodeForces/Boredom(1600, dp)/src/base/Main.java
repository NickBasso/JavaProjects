package base;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\_Works\\Java\\Projects\\_JavaProjects_GitHub\\CodeForces\\Boredom(1600, dp)\\input.txt");
        int n, i;
        int[] a;
        Scanner in = new Scanner(file);

        int j;
        a = new int[100001];

        n = in.nextInt();
        for (i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        for(i = 0; i < n; i++){
            System.out.println(a[i]);
        }

        Arrays.sort(a);

        for(i = 0; i < n; i++){
            System.out.println(a[i]);
        }
    }
}
