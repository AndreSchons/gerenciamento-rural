package Model;

public class AgriculturalInputs {

    private int inputId;
    private String inputName;
    private String inputType; // e.g., "Fertilizer", "Pesticide", etc.
    private double quantity; // in kg or liters
    private String applicationMethod; // e.g., "Spray", "Soil Application", etc.

    public AgriculturalInputs(int inputId, String inputName, String inputType, double quantity, String applicationMethod) {
        this.inputId = inputId;
        this.inputName = inputName;
        this.inputType = inputType;
        this.quantity = quantity;
        this.applicationMethod = applicationMethod;
    }

    public AgriculturalInputs(String inputName, String inputType, double quantity, String applicationMethod) {
        this.inputName = inputName;
        this.inputType = inputType;
        this.quantity = quantity;
        this.applicationMethod = applicationMethod;
    }

    public int getInputId() {
        return inputId;
    }

    public void setInputId(int inputId) {
        this.inputId = inputId;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getApplicationMethod() {
        return applicationMethod;
    }

    public void setApplicationMethod(String applicationMethod) {
        this.applicationMethod = applicationMethod;
    }

    
}
