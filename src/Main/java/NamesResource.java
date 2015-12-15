package Main.java;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Helen on 14.12.2015.
 */
public class NamesResource {
    public static final String NAMES_FILENAME = "/main/resources/Nimekiri.txt";

    //Ü. Luisk

    public ArrayList<String> readFromFileLineByLine (){
        ArrayList<String> names = new ArrayList<String>();
        try {
            InputStream is = this.getClass().getResourceAsStream(NAMES_FILENAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                names.add(strLine.trim());
            }
            br.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return names;
        }
    }

    public void saveWinnerToFile(String winner) {
        // TODO save
        System.out.println(winner);
    }
}

