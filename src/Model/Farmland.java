package Model;

import java.util.List;

public class Farmland {

    private int farmlandId;
    private String farmlandName;
    private double area; // in hectares
    private Farm farm; // Association with Farm
    private Crop crop; // Association with Crop
    private List<AgriculturalInputs> inputs; // List of agricultural inputs used

    public Farmland(int farmlandId, String farmlandName, double area, Farm farm, Crop crop) {
        this.farmlandId = farmlandId;
        this.farmlandName = farmlandName;
        this.area = area;
        this.farm = farm;
        this.crop = crop;
    }

    public int getFarmlandId() {
        return farmlandId;
    }

    public void setFarmlandId(int farmlandId) {
        this.farmlandId = farmlandId;
    }

    public String getFarmlandName() {
        return farmlandName;
    }

    public void setFarmlandName(String farmlandName) {
        this.farmlandName = farmlandName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Crop getCrop() {
        return crop;
    }

    public void setCrop(Crop crop) {
        this.crop = crop;
    }

    public List<AgriculturalInputs> getInputs() {
        return inputs;
    }

    public void setInputs(List<AgriculturalInputs> inputs) {
        this.inputs = inputs;
    }

    
}
