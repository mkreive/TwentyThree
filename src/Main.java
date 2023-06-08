import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        MeteoData data = getLatestObservations();
        List<Observation> observations = new ArrayList<>(data.observations);
        List<Observation> hot = observations.stream()
                .filter(obs -> obs.airTemperature >= 23.0)
                .toList();
//        System.out.println("Today will be hot (23 degrees or more):");
//        hot.forEach(obs -> System.out.println(obs.observationTimeUtc));

        List<Observation> formatedObs = observations.stream()
                .map(Main::addIcons)
                .toList();

        formatedObs.forEach(System.out::print);


    }

    static Observation addIcons(Observation o) {
        String condition = o.conditionCode;
        switch (condition) {
            case "partly-cloudy" -> o.icon = "⛅";
            case "clear" -> o.icon = "\uD83D\uDD06";
            case "rain" -> o.icon = "\uD83C\uDF26";
            default -> o.icon = "☉";
        }
        return o;
    }

    static Observation formatTime(Observation obs) throws ParseException {
        Observation obsCopy = obs;
        DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = utcFormat.parse(obsCopy.observationTimeUtc);
        System.out.println(date);

        DateFormat pstFormat = new SimpleDateFormat("MM-dd'T'HH:mm:ss.SSS'Z'");
        pstFormat.setTimeZone(TimeZone.getTimeZone("PST"));

        obsCopy.observationTimeUtc = pstFormat.format(date);
        return obsCopy;
    }

    static MeteoData getLatestObservations() {
        String API_URI = "https://api.meteo.lt/v1/stations/kauno-ams/observations/latest";
        String json = RestHelper.getResponseNewWay(API_URI);
        MeteoData data = JsonHelper.jsonToMeteoData(json);
        return data;

    }

    static void getStations() {
        String API_URI = "https://api.meteo.lt/v1/stations";
        String json = RestHelper.getResponseNewWay(API_URI);
        Station[] stations = JsonHelper.jsonToStations(json);

        for (Station st : stations) {
            System.out.println(st);
        }
    }

}