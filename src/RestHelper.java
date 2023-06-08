import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestHelper {

    public static String getResponseOldWay(String address) {
        try {
            URL url = new URL(address); // paduodamas adresas

            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // atidaromas connectionas

            connection.setRequestMethod("GET"); // nurodomas metodas

            int responseCode = connection.getResponseCode(); // gaunam atsakyma

            if(responseCode != 200) return "";

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream())); // gauti atsakymo turini
            String line;
            StringBuilder response = new StringBuilder();

            while( (line = br.readLine()) != null) { // reading all lines
                response.append(line); // adding read lines to sb
            }
            br.close(); // closing buffered reader

            connection.disconnect(); // closing connection

            return response.toString();
        } catch (IOException e) {
            throw new RuntimeException(e); // catching exception
        }
    }

    public static String getResponseNewWay(String address) {
        HttpClient client = HttpClient.newHttpClient(); // sukuriam klienta, kreipsis i API

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            int responseCode = response.statusCode();
            return response.body();

        } catch (IOException e) {
            e.printStackTrace();
        } catch ( InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "";
    }


}
