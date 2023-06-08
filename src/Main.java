public class Main {

    final static String API_URI = "https://api.meteo.lt/v1/stations";

    public static void main(String[] args) {

        String data = RestHelper.getResponseNewWay(API_URI);
        System.out.println(data);


    }
}
