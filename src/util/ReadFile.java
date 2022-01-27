package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    public static ArrayList<String> read(String txt) throws IOException {
        System.out.println("<Data_"+txt+"_File>");
        BufferedReader reader = new BufferedReader(new FileReader("./resources/Data_"+txt+".txt"));
        String str;
        ArrayList<String> key = new ArrayList<>();
        while ((str = reader.readLine()) != null) {
            System.out.println(str);
            key.add(str);
        }
        reader.close();

        return key;
    }

}
