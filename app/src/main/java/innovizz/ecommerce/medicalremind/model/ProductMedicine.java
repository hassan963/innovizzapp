package innovizz.ecommerce.medicalremind.model;

/**
 * Created by Ashraful Hassan on 3/12/2018.
 */

public class ProductMedicine {
    private String medicineName;
    private String medicinePrice;
    private String medicineImage;

    public ProductMedicine(String medicineName, String medicinePrice, String medicineImage) {
        this.medicineName = medicineName;
        this.medicinePrice = medicinePrice;
        this.medicineImage = medicineImage;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(String medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getMedicineImage() {
        return medicineImage;
    }

    public void setMedicineImage(String medicineImage) {
        this.medicineImage = medicineImage;
    }
}
