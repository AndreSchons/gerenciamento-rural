package Model;

public class Crop {

    private int cropId;
    private String cropName;
    private String variety;
    private String season; // e.g., "Spring", "Summer", etc.
    private int expectedGrowthTime; // in days

    public Crop(int cropId, String cropName, String variety, String season, int expectedGrowthTime) {
        this.cropId = cropId;
        this.cropName = cropName;
        this.variety = variety;
        this.season = season;
        this.expectedGrowthTime = expectedGrowthTime;
    }

    public int getCropId() {
        return cropId;
    }

    public void setCropId(int cropId) {
        this.cropId = cropId;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getExpectedGrowthTime() {
        return expectedGrowthTime;
    }

    public void setExpectedGrowthTime(int expectedGrowthTime) {
        this.expectedGrowthTime = expectedGrowthTime;
    }

    

}
