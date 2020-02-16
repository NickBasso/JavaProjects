package base;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
	    File file = new File("src/base/input.txt");
	    Scanner in = new Scanner(file);

	    int n = in.nextInt();

	    int i, j, t, x1, x2;
		int[] a = new int[100010];

		for(i = 0; i < n; i++){
			a[i] = in.nextInt();
		}

		Arrays.sort(a, 0, n);


    }
}
