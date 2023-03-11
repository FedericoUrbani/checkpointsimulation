import java.io.*;
import java.util.*;

public class GenMap {
    public void inizialiParole(String fileIn, String fileOut) {


        try {
            FileReader fr = new FileReader(fileIn);
            BufferedReader br = new BufferedReader(fr);
            LinkedHashMap<Character, String> resultFile = new LinkedHashMap<>();
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                for (String a : parts) {
                    System.out.println(a.charAt(0));
                    if (resultFile.containsKey(a.charAt(0))) {
                        String app= resultFile.get(a.charAt(0));
                        resultFile.put(a.charAt(0),app+",'"+a+"'");
                    } else {
                        resultFile.put(a.charAt(0),"'"+a+"'" );
                    }

                }

            }
            System.out.println(resultFile);
            FileWriter fw = new FileWriter(fileOut);
            resultFile.forEach((key, value) -> {
                try {
                    fw.write("{'" + key + "':(" + value+")}\n");

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            fw.flush();
            fw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}