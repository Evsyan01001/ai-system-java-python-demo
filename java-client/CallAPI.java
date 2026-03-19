import java.net.*;
import java.io.*;

public class CallAPI {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://127.0.0.1:8000/Predict?input_data=fake");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream())
        );

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Response: " + line);
        };
    }
}