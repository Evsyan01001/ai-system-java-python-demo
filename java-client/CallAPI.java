import java.net.*;
import java.io.*;

public class CallAPI {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://127.0.0.1:8000/predict?input_data=fake");
        String filePath = args[0]; // Get the file path from command line arguments

	    String boundary = "----WebKitFormBoundary7MA4YWxkTrZu0gW";

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        // Set the request method to POST
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        // Set the Content-Type header to multipart/form-data with the boundary
        conn.setRequestProperty(
            "Content-Type", 
            "multipart/form-data; boundary=" + boundary);

        // Write the multipart form data to the output stream
        OutputStream os = conn.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"), true);

        // Write the file part
        writer.append("--" + boundary).append("\r\n");
        writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"test.txt\"\r\n");
        writer.append("Content-Type: text/plain\r\n\r\n");
        writer.flush();

        FileInputStream inputStream = new FileInputStream(filePath);
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }
        os.flush();
        inputStream.close();

        writer.append("\r\n").flush();
        writer.append("--" + boundary + "--").append("\r\n");
        writer.close();

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream())
        );

        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Response: " + line);
        };
    }
}
