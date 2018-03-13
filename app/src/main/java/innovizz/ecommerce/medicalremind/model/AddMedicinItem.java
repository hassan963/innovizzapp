package innovizz.ecommerce.medicalremind.model;

/**
 * Created by asif on 04-Mar-18.
 */

public class AddMedicinItem {
    private String madicineName;
    private String morning;
    private String afternoon;
    private String night;
    private String mill;

    public AddMedicinItem(String madicineName, String morning, String afternoon, String night, String mill) {
        this.madicineName = madicineName;
        this.morning = morning;
        this.afternoon = afternoon;
        this.night = night;
        this.mill = mill;
    }

    public String getMadicineName() {
        return madicineName;
    }

    public void setMadicineName(String madicineName) {
        this.madicineName = madicineName;
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getMill() {
        return mill;
    }

    public void setMill(String mill) {
        this.mill = mill;
    }
}
