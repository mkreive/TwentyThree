import java.util.ArrayList;

public class MeteoData {
        public Station station;
        public ArrayList<Observation> observations;

    @Override
    public String toString() {
        String result = station.toString() + "\n";
        for (Observation obs: observations) {
            result += obs + "\n";
        }
        return result;
    }
}
