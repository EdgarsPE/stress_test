import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebPageStressTester {
    public static void main(String[] args) {
        String url = "https://www.apollokino.lv";
        int numberOfRequest = 10;

        for (int i = 0; i < numberOfRequest; i++) {
            sendHttpRequest(url);
        }

    }

    private static void sendHttpRequest(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set up the request method
            connection.setRequestMethod("GET");


            // Getting answers in code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // Extracting the content of answers
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Process the response according to your needs
            //   System.out.println("Response: " + response.toString());

            // Release resources
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
