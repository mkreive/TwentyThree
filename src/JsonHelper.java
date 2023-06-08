import com.google.gson.Gson;

public class JsonHelper {
    static Gson gson = new Gson();

    public static Station[] jsonToStations(String json) {
        return gson.fromJson(json, Station[].class);
    }

    public static MeteoData jsonToMeteoData(String json) {
        return gson.fromJson(json, MeteoData.class);
    }
}
