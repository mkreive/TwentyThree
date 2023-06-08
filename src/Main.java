public class Main {
    public static void main(String[] args) {
        getLatestObservations();

    }

    static void getLatestObservations() {
        String API_URI = "https://api.meteo.lt/v1/stations/kauno-ams/observations/latest";
        String json = RestHelper.getResponseNewWay(API_URI);
        MeteoData data = JsonHelper.jsonToMeteoData(json);
        System.out.println(data);

    }

    static void getStations() {
        String API_URI = "https://api.meteo.lt/v1/stations";
        String json = RestHelper.getResponseNewWay(API_URI);
        Station[] stations = JsonHelper.jsonToStations(json);

        for (Station st: stations) {
            System.out.println(st);
        }
    }
}
