package Model;

import java.util.List;

public class Farm {

    private int farmId;
    private String farmName;
    private String location;
    private List<Farmland> farmlands;
    private double totalArea; // in hectares

    public Farm(int farmId, String farmName, String location, double totalArea) {
        this.farmId = farmId;
        this.farmName = farmName;
        this.location = location;
        this.totalArea = totalArea;
        calculateArea();
    }

    

    public Farm(String farmName, String location, List<Farmland> farmlands) {
        this.farmName = farmName;
        this.location = location;
        this.farmlands = farmlands;
        calculateArea();
    }



    public void calculateArea() {
        this.totalArea = 0;
        for(Farmland farmland: farmlands) {
            this.totalArea += farmland.getArea();
        }
        setTotalArea(totalArea);
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Farmland> getFarmlands() {
        return farmlands;
    }

    public void setFarmlands(List<Farmland> farmlands) {
        this.farmlands = farmlands;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    
}
