public class Coordinates {
        public double latitude;
        public double longitude;

        public Coordinates(double latitude, double longitude) {
                this.latitude = latitude;
                this.longitude = longitude;
        }

        @Override
        public String toString() {
                return "Coordinates{" +
                        "latitude=" + latitude +
                        ", longitude=" + longitude +
                        '}';
        }
}
