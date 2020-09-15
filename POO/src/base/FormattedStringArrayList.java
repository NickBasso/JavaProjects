/*
    this class extracts strings from a file,
    where all data is stored in a single line
    in the following pattern:
    "name", "another name", "yet another name", "Luis".
    Strings from which commas and quotes are removed
    are saved in an ArrayList class object.
*/

package base;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.isLetter;

public class FormattedStringArrayList{
    private ArrayList<String> strings;
    private Scanner scan;
    private String filePath;

    public FormattedStringArrayList(String filePath) throws FileNotFoundException, IOException {
        this.strings = new ArrayList<>();
        this.scan = new Scanner(System.in);
        this.filePath = filePath;

        this.getFormattedStrings();
    }

    public void getFormattedStrings(){
        InputStream is = null;

        try {
            is = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = null;

        try {
            line = buf.readLine();
            System.out.println(line);

            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < line.length() - 1; i++){

                if(line.charAt(i) == '"' && line.charAt(i + 1) == ','){
                    strings.add(sb.toString());
                    sb.delete(0, sb.length());
                } else if(isLetter(line.charAt(i))){
                    sb.append(line.charAt(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStringByIndex(int index){
        return this.strings.get(index);
    }

    public int getSize(){
        return this.strings.size();
    }
}
