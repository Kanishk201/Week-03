package inputstreamreader.bytetocharstream;

import java.io.*;

public class ByteToCharStream {
    public static void byteToChar() {

        String filePath = "file.txt";


        try (
                FileInputStream fileInputStream = new FileInputStream(filePath);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error: Unsupported encoding.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: The specified file was not found.");
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred.");
        }
    }
}
